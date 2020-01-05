
package acme.features.administrator.challenge;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goalGold", "goalSilver", "goalBronze", "rewardGold", "rewardSilver", "rewardBronze");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result;

		result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		//		Date deadline = entity.getDeadline();
		//		errors.state(request, deadline != null, "deadline", "administrator.challenge.form.errors.deadline.null");
		//
		//		Money rewardGold = entity.getRewardGold();
		//		errors.state(request, rewardGold != null, "rewardGold", "administrator.challenge.form.errors.reward.gold.null");
		//
		//		Money rewardSilver = entity.getRewardSilver();
		//		errors.state(request, rewardSilver != null, "rewardSilver", "administrator.challenge.form.errors.reward.silver.null");
		//
		//		Money rewardBronze = entity.getRewardBronze();
		//		errors.state(request, rewardBronze != null, "rewardBronze", "administrator.challenge.form.errors.reward.bronze.null");

		if (!errors.hasErrors("deadline")) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			errors.state(request, entity.getDeadline().after(calendar.getTime()), "deadline", "administrator.challenge.form.errors.deadline.week");
		}

		Boolean rewardGold = false;
		Boolean rewardSilver = false;
		Boolean rewardBronze = false;
		if (!errors.hasErrors("rewardGold")) {
			rewardGold = entity.getRewardGold().getCurrency().equals("EUR") || entity.getRewardGold().getCurrency().equals("€");
			errors.state(request, rewardGold, "rewardGold", "administrator.challenge.form.errors.reward.currency");
		}

		if (!errors.hasErrors("rewardSilver")) {
			rewardSilver = entity.getRewardSilver().getCurrency().equals("EUR") || entity.getRewardSilver().getCurrency().equals("€");
			errors.state(request, rewardSilver, "rewardSilver", "administrator.challenge.form.errors.reward.currency");
		}

		if (!errors.hasErrors("rewardBronze")) {
			rewardBronze = entity.getRewardBronze().getCurrency().equals("EUR") || entity.getRewardBronze().getCurrency().equals("€");
			errors.state(request, rewardBronze, "rewardBronze", "administrator.challenge.form.errors.reward.currency");
		}

		if (rewardGold && rewardSilver && rewardBronze) {
			errors.state(request, entity.getRewardGold().getAmount() > entity.getRewardSilver().getAmount() && entity.getRewardGold().getAmount() > entity.getRewardBronze().getAmount(), "rewardGold", "administrator.challenge.form.errors.reward.amount");
			errors.state(request, entity.getRewardSilver().getAmount() > entity.getRewardBronze().getAmount(), "rewardSilver", "administrator.challenge.form.errors.reward.amount");
		}

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {

		this.repository.save(entity);

	}
}

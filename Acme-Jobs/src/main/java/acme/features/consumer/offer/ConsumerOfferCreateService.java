
package acme.features.consumer.offer;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	@Autowired
	private ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("rangeMax") || !errors.hasErrors("rangeMin")) {
			//Check if currency is in EUR-----------------------------------------------------
			Boolean maxIsEur = entity.getRangeMax().getCurrency().equals("EUR") || entity.getRangeMax().getCurrency().equals("€");
			Boolean minIsEur = entity.getRangeMin().getCurrency().equals("EUR") || entity.getRangeMin().getCurrency().equals("€");
			errors.state(request, maxIsEur, "rangeMax", "consumer.offer.form.errors.rangeMax.currency");
			errors.state(request, minIsEur, "rangeMin", "consumer.offer.form.errors.rangeMin.currency");

			if (maxIsEur && minIsEur) {
				//Check rangeMax > rangeMin-------------------------------------------------------
				errors.state(request, entity.getRangeMax().getAmount() >= entity.getRangeMin().getAmount(), "rangeMin", "consumer.offer.form.errors.maxbiggerthanmin");
			}

		}

		if (!errors.hasErrors("deadline")) {
			//Check if deadline is in future------------------------------------------------------
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			errors.state(request, entity.getDeadline().after(calendar.getTime()), "deadline", "consumer.offer.form.errors.deadline.week");
		}

		//Check if user confirmed on the check-box--------------------------------------------
		if (!errors.hasErrors("check")) {
			errors.state(request, request.getModel().getBoolean("check"), "check", "consumer.offer.form.errors.check");
		}

		// Check if ticker already exists-----------------------------------------------------
		String ticker = entity.getTicker();
		Offer exists = this.repository.findOneByTicker(ticker);
		errors.state(request, exists == null, "ticker", "consumer.offer.form.errors.ticker");
	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		Offer result = new Offer();
		return result;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.transfer(request.getModel(), "check");
		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("check", false);
		request.unbind(entity, model, "deadline", "moment", "rangeMax", "rangeMin", "text", "ticker", "title");
	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		this.repository.save(entity);
	}

}

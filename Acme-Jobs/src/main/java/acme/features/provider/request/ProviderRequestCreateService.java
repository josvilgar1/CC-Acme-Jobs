
package acme.features.provider.request;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.request.Request;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestCreateService implements AbstractCreateService<Provider, Request> {

	@Autowired
	ProviderRequestRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.transfer(request.getModel(), "check");
		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("check", false);
		request.unbind(entity, model, "title", "deadline", "text", "reward", "ticker");

	}

	@Override
	public Request instantiate(final acme.framework.components.Request<Request> request) {
		Request req = new Request();
		return req;
	}

	@Override
	public void validate(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("reward")) {
			errors.state(request, entity.getReward().getCurrency().equals("EUR") || entity.getReward().getCurrency().equals("€"), "reward", "provider.request.form.errors.reward.currency");
		}
		if (!errors.hasErrors("deadline")) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			errors.state(request, entity.getDeadline().after(calendar.getTime()), "deadline", "provider.request.form.errors.deadline.week");
		}

		if (!errors.hasErrors("check")) {
			errors.state(request, request.getModel().getBoolean("check"), "check", "provider.request.form.errors.check");
		}

		String ticker = entity.getTicker();
		Request exists = this.repository.findOneByTicker(ticker);
		errors.state(request, exists == null, "ticker", "provider.request.form.errors.ticker");
	}

	@Override
	public void create(final acme.framework.components.Request<Request> request, final Request entity) {
		Date date = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(date);
		this.repository.save(entity);
	}

}

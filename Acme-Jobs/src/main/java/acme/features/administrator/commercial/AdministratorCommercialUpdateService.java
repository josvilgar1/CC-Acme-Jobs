
package acme.features.administrator.commercial;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Commercial;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorCommercialUpdateService implements AbstractUpdateService<Administrator, Commercial> {

	// Internal state ---------------------------------------------------------
	@Autowired
	AdministratorCommercialRepository repository;


	// AbstractCreateService interface ----------------------------------------
	@Override
	public boolean authorise(final Request<Commercial> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Commercial> request, final Commercial entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Commercial> request, final Commercial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "url", "creditCardCVV", "creditCardMonth", "creditCardName", "creditCardNumber", "creditCardYear", "creditCardType");
	}

	@Override
	public Commercial findOne(final Request<Commercial> request) {
		assert request != null;

		Commercial result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Commercial> request, final Commercial entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Calendar c = new GregorianCalendar();

		Integer actualMonth = c.get(Calendar.MONTH) + 1;
		Integer actualYear = c.get(Calendar.YEAR);

		Integer year = null;
		if (!errors.hasErrors("creditCardYear")) {
			year = entity.getCreditCardYear();
			errors.state(request, year >= actualYear, "creditCardYear", "administrator.commercial.form.errors.creditCardYearExpired");
		}

		if (!errors.hasErrors("creditCardMonth")) {
			if (year != null && year.equals(actualYear)) {
				errors.state(request, entity.getCreditCardMonth() >= actualMonth, "creditCardMonth", "administrator.commercial.form.errors.creditCardMonthExpired");
			}
		}

		if (!errors.hasErrors("creditCardName")) {
			errors.state(request, entity.getCreditCardName().length() > 5, "creditCardName", "administrator.commercial.form.errors.nameNotValid");
		}
	}

	@Override
	public void update(final Request<Commercial> request, final Commercial entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}

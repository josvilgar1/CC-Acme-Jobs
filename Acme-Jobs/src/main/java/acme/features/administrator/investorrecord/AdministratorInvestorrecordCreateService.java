
package acme.features.administrator.investorrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorrecords.Investorrecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorInvestorrecordCreateService implements AbstractCreateService<Administrator, Investorrecord> {

	@Autowired
	private AdministratorInvestorrecordRepository repository;


	@Override
	public boolean authorise(final Request<Investorrecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Investorrecord> request, final Investorrecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "statement", "stars");

	}

	@Override
	public void bind(final Request<Investorrecord> request, final Investorrecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Investorrecord instantiate(final Request<Investorrecord> request) {
		assert request != null;

		Investorrecord result = new Investorrecord();

		return result;
	}

	@Override
	public void validate(final Request<Investorrecord> request, final Investorrecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Investorrecord> request, final Investorrecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}

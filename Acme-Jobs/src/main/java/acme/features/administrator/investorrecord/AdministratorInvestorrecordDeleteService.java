
package acme.features.administrator.investorrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorrecords.Investorrecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorInvestorrecordDeleteService implements AbstractDeleteService<Administrator, Investorrecord> {

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
	public void validate(final Request<Investorrecord> request, final Investorrecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public Investorrecord findOne(final Request<Investorrecord> request) {
		assert request != null;

		Investorrecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void delete(final Request<Investorrecord> request, final Investorrecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

}

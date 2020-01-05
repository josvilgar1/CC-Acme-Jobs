
package acme.features.administrator.noncommercial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Noncommercial;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorNonCommercialUpdateService implements AbstractUpdateService<Administrator, Noncommercial> {

	// Internal state ---------------------------------------------------------
	@Autowired
	AdministratorNonCommercialRepository repository;


	// AbstractCreateService interface ----------------------------------------
	@Override
	public boolean authorise(final Request<Noncommercial> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Noncommercial> request, final Noncommercial entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Noncommercial> request, final Noncommercial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "url", "jingle");
	}

	@Override
	public Noncommercial findOne(final Request<Noncommercial> request) {
		assert request != null;

		Noncommercial result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Noncommercial> request, final Noncommercial entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<Noncommercial> request, final Noncommercial entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}

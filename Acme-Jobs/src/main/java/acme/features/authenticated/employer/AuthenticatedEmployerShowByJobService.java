
package acme.features.authenticated.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedEmployerShowByJobService implements AbstractShowService<Authenticated, Employer> {

	@Autowired
	private AuthenticatedEmployerRepository repository;


	@Override
	public boolean authorise(final Request<Employer> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Employer> request, final Employer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "identity.fullName", "identity.email", "company", "sector");

	}

	@Override
	public Employer findOne(final Request<Employer> request) {
		assert request != null;

		Employer result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneByJobId(id);

		return result;
	}

}

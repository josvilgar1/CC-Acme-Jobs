
package acme.features.auditor.auditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorAuditorShowService implements AbstractShowService<Auditor, Auditor> {

	@Autowired
	AuditorAuditorRepository repository;


	@Override
	public boolean authorise(final Request<Auditor> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Auditor> request, final Auditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "responsibility");
	}

	@Override
	public Auditor findOne(final Request<Auditor> request) {
		assert request != null;

		Auditor result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}

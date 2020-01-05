
package acme.features.administrator.noncommercial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Noncommercial;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorNonCommercialShowService implements AbstractShowService<Administrator, Noncommercial> {

	@Autowired
	private AdministratorNonCommercialRepository repository;


	@Override
	public boolean authorise(final Request<Noncommercial> request) {
		assert request != null;
		return true;
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
}


package acme.features.administrator.noncommercial;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Noncommercial;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorNonCommercialListService implements AbstractListService<Administrator, Noncommercial> {

	@Autowired
	AdministratorNonCommercialRepository repository;


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

		request.unbind(entity, model, "picture", "slogan", "url");
	}

	@Override
	public Collection<Noncommercial> findMany(final Request<Noncommercial> request) {
		assert request != null;

		Collection<Noncommercial> result;

		result = this.repository.findMany();

		return result;
	}

}

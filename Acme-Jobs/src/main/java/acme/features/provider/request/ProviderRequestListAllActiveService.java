
package acme.features.provider.request;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.request.Request;
import acme.entities.roles.Provider;
import acme.framework.components.Model;
import acme.framework.services.AbstractListService;

@Service
public class ProviderRequestListAllActiveService implements AbstractListService<Provider, Request> {

	@Autowired
	ProviderRequestRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "deadline", "text");
	}

	@Override
	public Collection<Request> findMany(final acme.framework.components.Request<Request> request) {
		assert request != null;

		Collection<Request> result = this.repository.findManyAllActive(new Date());

		return result;
	}

}


package acme.features.sponsor.commercial;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Commercial;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class SponsorCommercialBannerListMineService implements AbstractListService<Sponsor, Commercial> {

	@Autowired
	SponsorCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<Commercial> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Commercial> request, final Commercial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "url");

	}

	@Override
	public Collection<Commercial> findMany(final Request<Commercial> request) {
		assert request != null;

		Collection<Commercial> result;
		Principal principal;

		principal = request.getPrincipal();

		result = this.repository.findManyBySponsorId(principal.getActiveRoleId());

		return result;
	}

}


package acme.features.sponsor.noncommercial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Noncommercial;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class SponsorNonCommercialBannerShowService implements AbstractShowService<Sponsor, Noncommercial> {

	@Autowired
	private SponsorNonCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<Noncommercial> request) {
		assert request != null;

		boolean result;
		int noncommercialId;
		Noncommercial nonCommercial;
		Sponsor sponsor;
		Principal principal;

		noncommercialId = request.getModel().getInteger("id");
		nonCommercial = this.repository.findOneNonCommercialById(noncommercialId);
		sponsor = nonCommercial.getSponsor();
		principal = request.getPrincipal();
		result = sponsor.getUserAccount().getId() == principal.getAccountId();

		return result;
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

		result = this.repository.findOneNonCommercialById(id);

		return result;
	}

}

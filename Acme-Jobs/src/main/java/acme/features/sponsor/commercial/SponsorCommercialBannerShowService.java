
package acme.features.sponsor.commercial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Commercial;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class SponsorCommercialBannerShowService implements AbstractShowService<Sponsor, Commercial> {

	@Autowired
	private SponsorCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<Commercial> request) {
		assert request != null;

		boolean result;
		int commercialId;
		Commercial commercial;
		Sponsor sponsor;
		Principal principal;

		commercialId = request.getModel().getInteger("id");
		commercial = this.repository.findOneCommercialById(commercialId);
		sponsor = commercial.getSponsor();
		principal = request.getPrincipal();
		result = sponsor.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Commercial> request, final Commercial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "url", "creditCardCVV", "creditCardMonth", "creditCardName", "creditCardNumber", "creditCardType", "creditCardYear");

	}

	@Override
	public Commercial findOne(final Request<Commercial> request) {
		assert request != null;

		Commercial result;

		int id;
		id = request.getModel().getInteger("id");

		result = this.repository.findOneCommercialById(id);

		return result;
	}

}

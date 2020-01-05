
package acme.features.anonymous.investorrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorrecords.Investorrecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousInvestorRecordShowService implements AbstractShowService<Anonymous, Investorrecord> {

	@Autowired
	AnonymousInvestorRecordRepository repository;


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
	public Investorrecord findOne(final Request<Investorrecord> request) {
		assert request != null;

		Investorrecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}

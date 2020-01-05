
package acme.features.administrator.investorrecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorrecords.Investorrecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorInvestorrecordListService implements AbstractListService<Administrator, Investorrecord> {

	@Autowired
	AdministratorInvestorrecordRepository repository;


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
	public Collection<Investorrecord> findMany(final Request<Investorrecord> request) {
		assert request != null;

		Collection<Investorrecord> result;

		result = this.repository.findMany();

		return result;
	}

}

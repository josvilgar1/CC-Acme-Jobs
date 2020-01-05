
package acme.features.administrator.investorrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorrecords.Investorrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorInvestorrecordRepository extends AbstractRepository {

	@Query("select a from Investorrecord a where a.id = ?1")
	Investorrecord findOneById(int id);

	@Query("select a from Investorrecord a")
	Collection<Investorrecord> findMany();

}

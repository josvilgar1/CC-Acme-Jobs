
package acme.features.anonymous.investorrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorrecords.Investorrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousInvestorRecordRepository extends AbstractRepository {

	@Query("select i from Investorrecord i")
	Collection<Investorrecord> findMany();

	@Query("select i from Investorrecord i where i.id = ?1")
	Investorrecord findOneById(int id);

	@Query("select i from Investorrecord i where i.stars = 5")
	Collection<Investorrecord> findManyTop();
}

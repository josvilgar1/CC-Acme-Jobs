
package acme.features.anonymous.companyrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.companyrecords.Companyrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousCompanyrecordRepository extends AbstractRepository {

	@Query("select a from Companyrecord a where a.id = ?1")
	Companyrecord findOneById(int id);

	@Query("select a from Companyrecord a")
	Collection<Companyrecord> findMany();

	@Query("select i from Companyrecord i where i.stars = 5")
	Collection<Companyrecord> findManyTop();

}

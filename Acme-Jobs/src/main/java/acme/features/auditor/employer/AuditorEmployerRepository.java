
package acme.features.auditor.employer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.roles.Employer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorEmployerRepository extends AbstractRepository {

	@Query("select j from Employer j where j.id = ?1")
	Employer findOneById(int id);

}

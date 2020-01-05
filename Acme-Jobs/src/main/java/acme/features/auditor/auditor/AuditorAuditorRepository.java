
package acme.features.auditor.auditor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditorRepository extends AbstractRepository {

	@Query("select j from Auditor j where j.id = ?1")
	Auditor findOneById(int id);

}

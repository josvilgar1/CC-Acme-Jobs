
package acme.features.auditor.duty;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.duties.Duty;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorDutyRepository extends AbstractRepository {

	@Query("select j from Duty j where j.id = ?1")
	Duty findOneById(int id);

	@Query("select j from Duty j where j.job.id = ?1")
	Collection<Duty> findDutiesByJob(Integer id);

}


package acme.features.worker.employer;

import org.springframework.data.jpa.repository.Query;

import acme.entities.roles.Employer;
import acme.framework.repositories.AbstractRepository;

public interface WorkerEmployerRepository extends AbstractRepository {

	@Query("select e from Employer e where e.id = (select j.employer.id from Job j where j.id = ?1)")
	Employer findOneByJobId(int id);

}

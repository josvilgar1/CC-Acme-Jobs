
package acme.features.authenticated.auditrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditrecords.Auditrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuditrecordRepository extends AbstractRepository {

	@Query("select a from Auditrecord a where a.id = ?1")
	Auditrecord findOneById(int id);

	@Query("select a from Auditrecord a where a.job.id = ?1 and a.finalMode is not false")
	Collection<Auditrecord> findManyByJobId(int id);
}


package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneById(int id);

	@Query("select j from Job j where j.finalMode is not false and (not exists(select ar from Auditrecord ar where ar.job.id = j.id) or j.id not in (select ar.job.id from Auditrecord ar where ar.auditor.userAccount.id = ?1))")
	Collection<Job> jobNotHasAuditrecord(int id);

	@Query("select j from Job j where j.finalMode is not false and j.id in (select ar.job.id from Auditrecord ar where ar.auditor.userAccount.id = ?1)")
	Collection<Job> jobHasAuditrecord(int id);

}

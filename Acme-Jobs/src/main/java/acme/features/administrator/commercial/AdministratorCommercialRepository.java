
package acme.features.administrator.commercial;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banners.Commercial;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorCommercialRepository extends AbstractRepository {

	@Query("select c from Commercial c where c.id = ?1")
	Commercial findOneById(int id);

	@Query("select c from Commercial c")
	Collection<Commercial> findMany();

}


package acme.features.administrator.noncommercial;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banners.Noncommercial;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorNonCommercialRepository extends AbstractRepository {

	@Query("select nc from Noncommercial nc where nc.id = ?1")
	Noncommercial findOneById(int id);

	@Query("select nc from Noncommercial nc")
	Collection<Noncommercial> findMany();

}

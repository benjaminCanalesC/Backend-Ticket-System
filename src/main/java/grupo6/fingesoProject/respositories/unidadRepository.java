package grupo6.fingesoProject.respositories;

import org.springframework.data.repository.CrudRepository;
import grupo6.fingesoProject.entities.unidadEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface unidadRepository extends CrudRepository<unidadEntity, Long> {
}

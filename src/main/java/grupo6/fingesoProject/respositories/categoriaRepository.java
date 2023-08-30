package grupo6.fingesoProject.respositories;

import org.springframework.data.repository.CrudRepository;
import grupo6.fingesoProject.entities.categoriaEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriaRepository extends CrudRepository<categoriaEntity, Long> {
}

package grupo6.fingesoProject.respositories;

import org.springframework.data.repository.CrudRepository;
import grupo6.fingesoProject.entities.usuarioEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends CrudRepository<usuarioEntity, Long> {
}

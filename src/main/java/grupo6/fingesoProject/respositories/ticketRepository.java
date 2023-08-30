package grupo6.fingesoProject.respositories;

import org.springframework.data.repository.CrudRepository;
import grupo6.fingesoProject.entities.ticketEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketRepository extends CrudRepository<ticketEntity, Long> {
}

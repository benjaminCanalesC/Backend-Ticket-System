package grupo6.fingesoProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grupo6.fingesoProject.respositories.ticketRepository;
import grupo6.fingesoProject.entities.ticketEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ticketService {
    @Autowired

    ticketRepository ticketRepositoryInstance;

    public ticketEntity createTicket(ticketEntity newTicket){
        newTicket.setFechaCreacion(LocalDate.now());
        newTicket.setHoraCreacion(LocalTime.now());
        return ticketRepositoryInstance.save(newTicket);
    }

    public List<ticketEntity> findAll(){return (List<ticketEntity>) ticketRepositoryInstance.findAll();}

    public void editAnalist(Long id_ticket, int id_analista){
        Optional<ticketEntity> ticket1 = ticketRepositoryInstance.findById(id_ticket);
        ticketEntity ticket2 = ticket1.get();
        ticket2.setId_analista(id_analista);

        createTicket(ticket2);
    }
    public List<ticketEntity> findAllByUnidadId (Long id_unidad){
        List<ticketEntity> ticketsEncontrados = new ArrayList<>();
        List<ticketEntity> tickets = findAll();
        for(int i = 0; i < tickets.size(); i++){
            if(Objects.equals(tickets.get(i).getUnidad().getId_unidad(), id_unidad)){
                assert false;
                ticketsEncontrados.add(tickets.get(i));
            }
        }
        return ticketsEncontrados;
    }
}

package grupo6.fingesoProject.controllers;

import grupo6.fingesoProject.entities.ticketEntity;
import grupo6.fingesoProject.services.ticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ticketController {
    @Autowired
    ticketService ticketServiceInstance;

    @PostMapping("/ticket")
    public ResponseEntity<ticketEntity> guardar(@RequestBody ticketEntity newTicket){
        return ResponseEntity.ok(ticketServiceInstance.createTicket(newTicket));
    }

    @PostMapping("/ticket/{id_ticket}/mod/analista/{id_analista}")
    public String modificarAnalista(@PathVariable Long id_ticket, @PathVariable int id_analista) {
        ticketServiceInstance.editAnalist(id_ticket, id_analista);
        return "ok";
    }

    @GetMapping("/tickets/unidad/{id_unidad}")
    public Iterable<ticketEntity> buscarTicketsUnidad(@PathVariable Long id_unidad) {return ticketServiceInstance.findAllByUnidadId(id_unidad);}
}

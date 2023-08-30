package grupo6.fingesoProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_ticket;
    int status;
    LocalTime horaCreacion;
    LocalDate fechaCreacion;
    int id_analista;

    @OneToOne
    @JoinColumn (name="id_categoria")
    public categoriaEntity categoria;

    @ManyToOne
    @JoinColumn (name="id_usuario")
    public usuarioEntity usuario;

    @ManyToOne
    @JoinColumn (name="id_unidad")
    public unidadEntity unidad;
}

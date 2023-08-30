package grupo6.fingesoProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class categoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_categoria;
    String motivo;
    String departamento;
    String descripcion;

    @ManyToOne
    @JoinColumn (name="id_unidad")
    public unidadEntity unidad;
}

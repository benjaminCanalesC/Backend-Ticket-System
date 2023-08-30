package grupo6.fingesoProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class usuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_usuario;
    String nombre;
    String apellido_paterno;
    String apellido_materno;
    String correo;
    String nombre_usuario;
    String contrasena;
    int privilegio;

    @ManyToOne
    @JoinColumn (name="id_unidad")
    public unidadEntity unidad;
}

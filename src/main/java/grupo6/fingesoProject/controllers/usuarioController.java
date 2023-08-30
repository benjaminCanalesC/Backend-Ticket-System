package grupo6.fingesoProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import grupo6.fingesoProject.services.usuarioService;
import grupo6.fingesoProject.entities.usuarioEntity;

import java.lang.reflect.Array;
import java.util.Optional;

@RestController
@CrossOrigin
public class usuarioController {
    @Autowired
    usuarioService usuarioServiceInstance;

    @PostMapping("/usuario")
    public usuarioEntity guardar(@RequestBody usuarioEntity newUsuarioEntity){
        return usuarioServiceInstance.guardar(newUsuarioEntity);
    }

    @GetMapping("/usuarios")
    public Iterable<usuarioEntity> allUsers() {return usuarioServiceInstance.findAll();}

    @GetMapping("/usuario/{id_usuario}")
    public Optional<usuarioEntity> buscarUsuario(@PathVariable Long id_usuario){return usuarioServiceInstance.buscarUsuarioId(id_usuario);}

    @GetMapping("/usuarios/unidad/{id_unidad}")
    public Iterable<usuarioEntity> buscarUsuariosUnidad(@PathVariable Long id_unidad) {return usuarioServiceInstance.findAllByUnidadId(id_unidad);}

    @GetMapping("/usuarios/analistas/unidad/{id_unidad}")
    public Iterable<usuarioEntity> buscarAnalistasPorUnidad(@PathVariable Long id_unidad) { return usuarioServiceInstance.findAllAnalistByUnidadId(id_unidad);}

    @GetMapping("login/{username}/{password}")
    public Iterable<String> login(@PathVariable String username, @PathVariable String password) {return usuarioServiceInstance.login(username, password);}
}

package grupo6.fingesoProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import grupo6.fingesoProject.services.categoriaService;
import grupo6.fingesoProject.entities.categoriaEntity;

@RestController
@CrossOrigin
public class categoriaController {
    @Autowired
    categoriaService categoriaServiceInstace;

    @PostMapping("/categoria")
    public ResponseEntity<categoriaEntity> guardar(@RequestBody categoriaEntity newCategoria){
        return ResponseEntity.ok(categoriaServiceInstace.guardar(newCategoria));
    }

    @GetMapping("/categorias")
    public Iterable<categoriaEntity> obtenerTodos() {return categoriaServiceInstace.getAll();}
}

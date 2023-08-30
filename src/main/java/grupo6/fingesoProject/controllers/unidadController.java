package grupo6.fingesoProject.controllers;

import grupo6.fingesoProject.entities.unidadEntity;
import grupo6.fingesoProject.services.unidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class unidadController {
    @Autowired
    unidadService unidadServiceInstance;

    @PostMapping("/unidad")
    public unidadEntity guardar(@RequestBody unidadEntity newUnidadEntity){
        return unidadServiceInstance.guardar(newUnidadEntity);
    }
}

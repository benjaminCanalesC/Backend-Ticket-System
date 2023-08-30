package grupo6.fingesoProject.services;

import grupo6.fingesoProject.entities.usuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grupo6.fingesoProject.respositories.unidadRepository;
import grupo6.fingesoProject.entities.unidadEntity;

@Service
public class unidadService {
    @Autowired

    unidadRepository unidadRepositoryInstace;

    public unidadEntity guardar(unidadEntity newUnidadEntity){ return unidadRepositoryInstace.save(newUnidadEntity);}
    public unidadEntity createUnidad(unidadEntity newUnidad){
        return unidadRepositoryInstace.save(newUnidad);
    }
}

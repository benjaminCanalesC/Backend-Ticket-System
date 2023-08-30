package grupo6.fingesoProject.services;

import grupo6.fingesoProject.entities.categoriaEntity;
import grupo6.fingesoProject.entities.usuarioEntity;
import grupo6.fingesoProject.respositories.categoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class categoriaService {
    @Autowired
    categoriaRepository categoriaRepositoryInstance;

    public categoriaEntity guardar(categoriaEntity newCategoria){ return categoriaRepositoryInstance.save(newCategoria);}
    public categoriaEntity createCategorizacion(categoriaEntity newCategorizacion){
        return categoriaRepositoryInstance.save(newCategorizacion);
    }

    public Iterable<categoriaEntity> getAll(){
        return categoriaRepositoryInstance.findAll();
    }
}

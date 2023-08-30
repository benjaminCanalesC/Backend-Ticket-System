package grupo6.fingesoProject.services;

import grupo6.fingesoProject.entities.unidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grupo6.fingesoProject.respositories.usuarioRepository;
import grupo6.fingesoProject.entities.usuarioEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class usuarioService{
    @Autowired
    usuarioRepository usuarioRepositoryInstance;

    public usuarioEntity guardar(usuarioEntity newUsuarioEntity){ return usuarioRepositoryInstance.save(newUsuarioEntity);}
    public Optional<usuarioEntity> buscarUsuarioId(Long id_usuario) {
        return usuarioRepositoryInstance.findById(id_usuario);
    }

    public List<usuarioEntity> findAll(){return (List<usuarioEntity>) usuarioRepositoryInstance.findAll();}

    public List<usuarioEntity> findAllByUnidadId (Long id_unidad){
        List<usuarioEntity> usuariosEncontrados = new ArrayList<>();
        List<usuarioEntity> usuarios = findAll();
        for(int i = 0; i < usuarios.size(); i++){
            if(Objects.equals(usuarios.get(i).getUnidad().getId_unidad(), id_unidad)){
                assert false;
                usuariosEncontrados.add(usuarios.get(i));
            }
        }
        return usuariosEncontrados;
    }
    public usuarioEntity findByUsername(String username){
        List<usuarioEntity> usuarios = (List<usuarioEntity>) usuarioRepositoryInstance.findAll();

        for(int i = 0; i < usuarios.size(); i++){
            if(Objects.equals(usuarios.get(i).getNombre_usuario(), username)){
                assert false;
                return usuarios.get(i);
            }
        }
        return null;
    }

    public List<usuarioEntity> findAllAnalistByUnidadId(Long id_unidad){
        List<usuarioEntity> usuarios = findAllByUnidadId(id_unidad);
        List<usuarioEntity> analistas = new ArrayList<>();
        for(int i = 0; i < usuarios.size(); i++){
            if(Objects.equals(usuarios.get(i).getPrivilegio(), 2)){
                assert false;
                analistas.add(usuarios.get(i));
            }
        }
        return analistas;
    }
    public List<String> login(String username, String password){
        List<String> parametros = new ArrayList<>();
        usuarioEntity usuario = findByUsername(username);
        if(usuario == null){
            parametros.add("Usuario no existe");
            return parametros;
        }
        else if(Objects.equals(usuario.getContrasena(), password) && usuario.getPrivilegio() == 3){
            String unidad = String.valueOf(usuario.getUnidad().getId_unidad());
            String id = String.valueOf(usuario.getId_usuario());
            parametros.add("ok3");
            parametros.add(unidad);
            parametros.add(id);
            return parametros;
        }
        else if(Objects.equals(usuario.getContrasena(), password) && usuario.getPrivilegio() == 1){
            String unidad = String.valueOf(usuario.getUnidad().getId_unidad());
            String id = String.valueOf(usuario.getId_usuario());
            parametros.add("ok1");
            parametros.add(unidad);
            parametros.add(id);
            return parametros;
        }
        else if(Objects.equals(usuario.getContrasena(), password) && usuario.getPrivilegio() == 2){
            String unidad = String.valueOf(usuario.getUnidad().getId_unidad());
            String id = String.valueOf(usuario.getId_usuario());
            parametros.add("ok2");
            parametros.add(unidad);
            parametros.add(id);
            return parametros;
        }
        else{
            parametros.add("Contraseña incorrecta");
            return parametros;
        }
    }
}

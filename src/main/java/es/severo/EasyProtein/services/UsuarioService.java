package es.severo.EasyProtein.services;

import es.severo.EasyProtein.entities.Usuario;
import es.severo.EasyProtein.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository readerRepository;

    public UsuarioService(UsuarioRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public Usuario getUsuario(String username, String password) {
        // Buscar un usuario en la base de datos con el nombre de usuario y la contraseña encriptada
        return readerRepository.findByUsernameAndPassword(username, password);
    }


    public void createUsuario(Usuario usuario) {
        readerRepository.save(usuario);
    }




}

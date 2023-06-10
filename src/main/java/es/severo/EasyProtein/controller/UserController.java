package es.severo.EasyProtein.controller;

import es.severo.EasyProtein.entities.Usuario;
import es.severo.EasyProtein.services.UsuarioService;
import es.severo.EasyProtein.util.EncryptionUtil;
import es.severo.EasyProtein.util.Login;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UsuarioService usuarioService;

    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public String login(Usuario usuario, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        Usuario user = usuarioService.getUsuario(usuario.getUsername(), EncryptionUtil.encrypt(usuario.getPassword()));
        if (user == null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        } else {
            redirectAttributes.addFlashAttribute("usuario", usuario.getUsername());
            Usuario sessionUser = (Usuario) request.getSession().getAttribute("user");
            if (sessionUser == null) {
                request.getSession().setAttribute("user", user);
            }
            return "redirect:/";
        }
    }


    @PostMapping("/registrarse")
    public String registro(Login usuario, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (usuarioService.getUsuario(usuario.getUsername(), EncryptionUtil.encrypt(usuario.getPassword())) != null) {
            return "registrarse";
        } else {
            redirectAttributes.addFlashAttribute("usuario", usuario.getUsername());
            Usuario user = usuarioService.createUsuario(new Usuario(usuario.getUsername(), EncryptionUtil.encrypt(usuario.getPassword())));
            redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");

            Usuario sessionUser = (Usuario) request.getSession().getAttribute("user");
            if (sessionUser == null) {
                request.getSession().setAttribute("user", user);
            }
            return "redirect:/";
        }
    }

}

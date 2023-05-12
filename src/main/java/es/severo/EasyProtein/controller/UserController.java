package es.severo.EasyProtein.controller;

import es.severo.EasyProtein.entities.Usuario;
import es.severo.EasyProtein.services.UsuarioService;
import es.severo.EasyProtein.util.EncryptionUtil;
import es.severo.EasyProtein.util.Login;
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
    public String login(Usuario usuario, Model model, RedirectAttributes redirectAttributes) {
        if (usuarioService.getUsuario(usuario.getUsername(), EncryptionUtil.encrypt(usuario.getPassword())) == null) {
//            model.addAttribute(WebUtil.ERROR_ATTRIBUTE, WebUtil.MSG_CREDENTIALS);
            return "login";
        } else {
            redirectAttributes.addFlashAttribute("usuario", usuario.getUsername());
            return "redirect:/";
        }
    }

    @PostMapping("/registrarse")
    public String registro(Login usuario, Model model, RedirectAttributes redirectAttributes) {
        if (usuarioService.getUsuario(usuario.getUsername(), EncryptionUtil.encrypt(usuario.getPassword())) != null) {
//            model.addAttribute(WebUtil.ERROR_ATTRIBUTE, WebUtil.MSG_CREDENTIALS);
            return "registrarse";
        } else {
            redirectAttributes.addFlashAttribute("usuario", usuario.getUsername());
            usuarioService.createUsuario(new Usuario(usuario.getUsername(), EncryptionUtil.encrypt(usuario.getPassword())));
            return "redirect:/";
        }
    }
}

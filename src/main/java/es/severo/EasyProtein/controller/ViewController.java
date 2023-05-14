package es.severo.EasyProtein.controller;

import es.severo.EasyProtein.entities.Proteina;
import es.severo.EasyProtein.services.DatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {
    private final DatabaseService databaseService;

    public ViewController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @RequestMapping
    public String homePage() {
        //return "index"
        return "redirect:/";
    }

    //--------------------------------- GET ---------------------------------

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registrarse")
    public String registro() {
        return "registrarse";
    }

    @GetMapping("/proteinas")
    public String proteinas(Model model, String nombre) {
        model.addAttribute("proteinas", databaseService.findAllProteinas());
        return "proteinas";
    }

    @GetMapping("/proteina/{id}")
    public String proteina(Model model, @PathVariable(value = "id") Long id) {
        Proteina proteina = databaseService.findProteinaById(id).orElse(null);
        if (proteina == null) {
            return "redirect:/proteinas";
        } else {
            model.addAttribute("proteina", proteina);
            return "productoProteina";
        }
    }

    @GetMapping("/creatinas")
    public String creatina(Model model, String nombre) {
        model.addAttribute("creatina", databaseService.findAllCreatina());
        return "creatina";
    }


}






package es.severo.EasyProtein.controller;

import es.severo.EasyProtein.entities.Proteina;
import es.severo.EasyProtein.services.DatabaseService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ViewController {
    private final DatabaseService databaseService;
    @Autowired
    private EntityManager entityManager;

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

    public String AllProductos(Model model) {
        model.addAttribute("proteinas", databaseService.findAllProteinas());
        return "index";
    }

    //--------------------------------- Proteinas ---------------------------------

    @GetMapping("/proteinas")
    public String proteinas(Model model) {
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

    @GetMapping("/cesta/proteina/{id}")
    public String cestaProteina(Model model, @PathVariable(value = "id") Long id) {
        Proteina proteina = databaseService.findProteinaById(id).orElse(null);
        if (proteina == null) {
            return "redirect:/proteinas";
        } else {
            model.addAttribute("proteina", proteina);
            return "cestaProteina";
        }
    }

    //filtrar proteina por tipo, donde el tipo sea igual a "whey"
    @GetMapping("/proteinas/tipo/{tipo}")
    public String proteinasPorTipo(@PathVariable String tipo, @RequestParam(required = false) String tipoProteina, Model model) {
        if (tipoProteina.equalsIgnoreCase("whey")){
            model.addAttribute("proteinas", databaseService.findProteinaByTipo("whey"));
            return "proteinasWheyList";
        } else if (tipoProteina.equalsIgnoreCase("vegana")){
            model.addAttribute("proteinas", databaseService.findProteinaByTipo("vegana"));
            return "proteinasVeganList";
        }
        return "redirect:/proteinas";
    }

//    @GetMapping("/proteinas/marca/{marca}}")
//    public String proteinasPorMarca(@PathVariable String tipo, @RequestParam(required = false) String tipoProteina, Model model) {
//        if (tipoProteina.equalsIgnoreCase("hsn")){
//            model.addAttribute("proteinas", databaseService.findProteinaByTipo("whey"));
//            return "proteinasWheyList";
//        } else if (tipoProteina.equalsIgnoreCase("myProtein")){
//            model.addAttribute("proteinas", databaseService.findProteinaByTipo("vegana"));
//            return "proteinasVeganList";
//        }
//        return "redirect:/proteinas";
//    }

    @RequestMapping(value = "/api/places", method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public List<Proteina> getProteinasFiltradas() {
        StringBuilder sb = new StringBuilder("SELECT * FROM proteina p where 1 = 1 ");
        return entityManager.createNativeQuery(sb.toString()).getResultList();
    }


//
//    @GetMapping("/proteinas/marca/myprotein")
//    public String proteinasMyprotein(Model model) {
//        model.addAttribute("proteinas", databaseService.findProteinaByMarca("myprotein"));
//        return "proteinas";
//    }
//
//    //filtrar proteina por el sabor
//    @GetMapping("/proteinas/sabor/chocolate")
//    public String proteinasChocolate(Model model) {
//        model.addAttribute("proteinas", databaseService.findProteinaBySabor("chocolate"));
//        return "proteinas";
//    }
//
//    @GetMapping("/proteinas/sabor/fresa")
//    public String proteinasFresa(Model model) {
//        model.addAttribute("proteinas", databaseService.findProteinaBySabor("fresa"));
//        return "proteinas";
//    }
//
//    @GetMapping("/proteinas/sabor/cafe")
//    public String proteinasCafe(Model model) {
//        model.addAttribute("proteinas", databaseService.findProteinaBySabor("cafe"));
//        return "proteinas";
//    }





    //--------------------------------- Creatina ---------------------------------
    @GetMapping("/creatinas")
    public String creatina(Model model, String nombre) {
        model.addAttribute("creatina", databaseService.findAllCreatina());
        return "creatina";
    }




}






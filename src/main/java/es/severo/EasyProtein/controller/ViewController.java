package es.severo.EasyProtein.controller;

import es.severo.EasyProtein.entities.Cesta;
import es.severo.EasyProtein.entities.Producto;
import es.severo.EasyProtein.entities.Proteina;
import es.severo.EasyProtein.entities.Usuario;
import es.severo.EasyProtein.services.DatabaseService;
import es.severo.EasyProtein.services.UsuarioService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ViewController {
    @Autowired
    private final DatabaseService databaseService;

    @Autowired
    private UsuarioService usuarioService;
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

    @GetMapping("/proteinas/marca/{marca}")
    public String proteinasPorMarca(@PathVariable String marca, @RequestParam(required = false) String marcaProteina, Model model) {
        if (marcaProteina.equalsIgnoreCase("hsn")){
            model.addAttribute("proteinas", databaseService.findProteinaByMarca("hsn"));
            return "proteinasHsnList";
        } else if (marcaProteina.equalsIgnoreCase("MyProtein")){
            model.addAttribute("proteinas", databaseService.findProteinaByMarca("MyProtein"));
            return "proteinasMPList";
        }
        return "redirect:/proteinas";
    }

    @GetMapping("/proteinas/sabor/{sabor}")
    public String proteinasPorSabor(@PathVariable String sabor, @RequestParam(required = false) String saborProteina, Model model) {
        if (saborProteina.equalsIgnoreCase("chocolate")){
            model.addAttribute("proteinas", databaseService.findProteinaBySabor("Chocolate"));
            return "proteinasChocolateList";
        } else if (saborProteina.equalsIgnoreCase("fresa")){
            model.addAttribute("proteinas", databaseService.findProteinaBySabor("Fresa"));
            return "proteinasFresaList";
        } else if (saborProteina.equalsIgnoreCase("cafe")){
            model.addAttribute("proteinas", databaseService.findProteinaBySabor("Cafe"));
            return "proteinasCafeList";
        }else if (saborProteina.equalsIgnoreCase("vainilla")){
            model.addAttribute("proteinas", databaseService.findProteinaBySabor("Vainilla"));
            return "proteinasVainillaList";
        }
        return "redirect:/proteinas";
    }

    @GetMapping("/productos/search")
    public String buscarProductos(@RequestParam(required = false) String filter, Model model) {
        model.addAttribute("productos", databaseService.findProductoBy(filter));
        System.out.println(filter);
        return "productosSearchList";
    }

//    @GetMapping("/cesta/{id}")
//    public String mostrarProducto(@PathVariable Long id, Model model) {
//
//        Cesta cesta = databaseService.findCestaById(id).orElse(null);
//        if (cesta != null) {
//            model.addAttribute("cesta", cesta);
//            return "cesta";
//        }
//        return "redirect:/proteinas";
//    }

    @GetMapping("/cesta/{id}")
    public String mostrarCesta(@PathVariable Long id, Model model, HttpServletRequest request){
        Usuario sessionUser = (Usuario) request.getSession().getAttribute("user");
        if (sessionUser == null) {
            return "redirect:/login";
        }
        // Crear una nueva instancia de Cesta
        Cesta cesta;
        if (sessionUser.getCesta() == null) {
            cesta = new Cesta(sessionUser);
            // Obtener la lista de productos de la cesta
            List<Producto> productos = cesta.getProductos();
        }
        cesta = databaseService.findCestaById(id).orElse(null);
        if (cesta != null) {
            model.addAttribute("cesta", cesta);
            return "cesta";
        }
        return "redirect:/";
    }


//    @PostMapping("/cesta")
//    public String agregarProductoACesta(@ModelAttribute("producto") Producto producto, HttpServletRequest request) {
//        // Verificar si el producto está en estado "detached"
//        if (entityManager.contains(producto)) {
//            // Si el producto está en estado "detached", realizar merge para asociarlo a la sesión de Hibernate
//            producto = entityManager.merge(producto);
//        }
//        Usuario sessionUser = (Usuario) request.getSession().getAttribute("user");
//        if (sessionUser == null) {
//            return "redirect:/login";
//        }
//        // Crear una nueva instancia de Cesta
//        Cesta cesta;
//        if (sessionUser.getCesta() == null) {
//            cesta = new Cesta(sessionUser);
//            // Obtener la lista de productos de la cesta
//            List<Producto> productos = cesta.getProductos();
//            // Agregar el producto a la lista de productos de la cesta
//            productos.add(producto);
//
//        }else{
//            cesta = sessionUser.getCesta();
//            // Obtener la lista de productos de la cesta
//            List<Producto> productos = cesta.getProductos();
//            // Agregar el producto a la lista de productos de la cesta
//            productos.add(producto);
//        }
//        cesta = databaseService.saveCesta(cesta);
//        sessionUser.setCesta(cesta);
//        usuarioService.createUsuario(sessionUser);
//        return "redirect:/cesta/" + cesta.getId(); // Redirige a la página de la cesta
//    }

    @PostMapping("/cesta")
    public String agregarProductoACesta(@ModelAttribute("producto") Producto producto, HttpServletRequest request) {
        Usuario sessionUser = (Usuario) request.getSession().getAttribute("user");
        if (sessionUser == null) {
            return "redirect:/login";
        }

        // Verificar si el producto está en estado "detached" o no existe en la base de datos
        if (!entityManager.contains(producto) || producto.getId() == null) {
            // Guardar el producto en la base de datos
            databaseService.saveProducto(producto);
        } else {
            // Cargar el producto en un estado persistente desde la base de datos
            producto = databaseService.findProductoById(producto.getId()).orElse(null);
            if (producto == null) {
                // El producto no existe en la base de datos, redirigir a una página de error o mostrar un mensaje de error
                return "redirect:/error";
            }
        }

        Cesta cesta = sessionUser.getCesta();
        if (cesta == null) {
            cesta = new Cesta(sessionUser);
            sessionUser.setCesta(cesta);
        }

        // Obtener la lista de productos de la cesta
        List<Producto> productos = cesta.getProductos();
        // Agregar el producto a la lista de productos de la cesta
        productos.add(producto);

        databaseService.saveCesta(cesta);
        usuarioService.createUsuario(sessionUser);
        request.getSession().setAttribute("user", sessionUser);

        return "redirect:/cesta/" + cesta.getId(); // Redirige a la página de la cesta
    }




    //borrar producto de la cesta
    @PostMapping("/cesta/{id}/delete/{idProducto}")
    public String borrarProductoDeCesta(@PathVariable("id") Long id, @PathVariable("idProducto") Long idProducto, HttpServletRequest request) {
        Usuario sessionUser = (Usuario) request.getSession().getAttribute("user");
        if (sessionUser == null) {
            return "redirect:/login";
        }
        Cesta cesta = databaseService.findCestaById(id).orElse(null);
        if (cesta != null) {
            Producto producto = databaseService.findProductoById(idProducto).orElse(null);
            if (producto != null) {
                cesta.getProductos().remove(producto);
                producto.getCestas().remove(cesta);
//                databaseService.deleteProductoFromCesta(producto.getId(), cesta.getId());
                databaseService.saveCesta(cesta);
                databaseService.saveProducto(producto);
                sessionUser.setCesta(cesta);
                request.getSession().setAttribute("user", sessionUser);
                return "redirect:/cesta/" + cesta.getId(); // Redirige a la página de la cesta
            }
        }
        return "redirect:/cesta/" + id;
    }

    //borrar cesta por id
    @GetMapping("/cesta/{id}/delete")
    public String borrarCesta(@PathVariable("id") Long id) {
        databaseService.deleteCesta(id);
        return "redirect:/proteinas";
    }



    @RequestMapping(value = "/api/places", method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public List<Proteina> getProteinasFiltradas() {
        return entityManager.createNativeQuery("SELECT * FROM proteina p where 1 = 1 ").getResultList();
    }


    //--------------------------------- Creatina ---------------------------------
    @GetMapping("/creatinas")
    public String creatina(Model model) {
        model.addAttribute("creatinas", databaseService.findAllCreatina());
        return "creatina";
    }

    //--------------------------------- Carbohidratos ---------------------------------
    @GetMapping("/carbos")
    public String carbos(Model model) {
        model.addAttribute("carbos", databaseService.findAllCarbohidratos());
        return "carbohidratos";
    }

    //--------------------------------- Aminoacidos ---------------------------------
    @GetMapping("/aminoacidos")
    public String aminoacidos(Model model) {
        model.addAttribute("aminoacidos", databaseService.findAllAminoacidos());
        return "aminoacidos";
    }

    //--------------------------------- Vitaminas ---------------------------------

    @GetMapping("/vitaminas")
    public String vitaminas(Model model) {
        model.addAttribute("vitaminas", databaseService.findAllVitaminas());
        return "vitaminas";
    }

    //--------------------------------- Barritas ---------------------------------

    @GetMapping("/barritas")
    public String barritas(Model model) {
        model.addAttribute("barritas", databaseService.findAllBarritas());
        return "barritas";
    }




}






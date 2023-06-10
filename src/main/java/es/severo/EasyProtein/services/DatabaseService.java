package es.severo.EasyProtein.services;

import es.severo.EasyProtein.entities.*;
import es.severo.EasyProtein.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {
    private final AminoacidoRepository aminoacidoRepository;
    private final CarbohidratosRepository carbohidratosRepository;
    private final ProteinaRepository proteinaRepository;
    private final VitaminaRepository vitaminaRepository;
    private final CreatinaRepository creatinaRepository;

    private final ProductosRepository productoRepository;

    private final CestaRepository cestaRepository;

    private final BarritasRepository barritasRepository;

    public DatabaseService(AminoacidoRepository aminoacidoRepository, CarbohidratosRepository carbohidratosRepository, ProteinaRepository proteinaRepository, VitaminaRepository vitaminaRepository, CreatinaRepository creatinaRepository, ProductosRepository productoRepository, CestaRepository cestaRepository, BarritasRepository barritasRepository) {
        this.aminoacidoRepository = aminoacidoRepository;
        this.carbohidratosRepository = carbohidratosRepository;
        this.proteinaRepository = proteinaRepository;
        this.vitaminaRepository = vitaminaRepository;
        this.creatinaRepository = creatinaRepository;
        this.productoRepository = productoRepository;
        this.cestaRepository = cestaRepository;
        this.barritasRepository = barritasRepository;
    }

    //--------------------------------- Proteinas ---------------------------------

    public List<Proteina> findAllProteinas() {
        return proteinaRepository.findAll();
    }

    //filtrar proteina por tipo, donde el tipo sea igual a "whey"
    public List<Proteina> findProteinaByTipo(String tipo) {
        return proteinaRepository.findProteinaByTipo(tipo);
    }

    //filtrar proteina por marca, donde la marca sea igual a "Optimum Nutrition"
    public List<Proteina> findProteinaByMarca(String marca) {
        return proteinaRepository.findProteinaByMarca(marca);
    }

    //filtrar proteina por sabor
    public List<Proteina> findProteinaBySabor(String sabor) {
        return proteinaRepository.findProteinaBySabor(sabor);
    }

    //filtrar proteina por nombre
    public List<Producto> findProductoBy(String filter) {
        System.out.println(productoRepository.findProducto(filter));
        return productoRepository.findProducto(filter);
    }

    //findProteinaById
    public Optional<Proteina> findProteinaById(Long id) {
        return proteinaRepository.findById(id);
    }

    //--------------------------------- Creatina ---------------------------------

    public List<Creatina> findAllCreatina() {
        return creatinaRepository.findAll();
    }

    //--------------------------------- Carbohidratos ---------------------------------

    //findAllCarbohidratos
    public List<Carbohidrato> findAllCarbohidratos() {
        return carbohidratosRepository.findAll();
    }

    //--------------------------------- Aminoacidos ---------------------------------

    public List<Aminoacido> findAllAminoacidos() {
        return aminoacidoRepository.findAll();
    }

    //--------------------------------- Vitaminas ---------------------------------

    public List<Vitamina> findAllVitaminas() {
        return vitaminaRepository.findAll();
    }

    //--------------------------------- Barritas ---------------------------------

    public List<Barrita> findAllBarritas() {
        return barritasRepository.findAll();
    }

    //--------------------------------- Cesta ---------------------------------


    //find cesta by id
    public Optional<Cesta> findCestaById(Long id) {
        return cestaRepository.findById(id);
    }

    public Cesta saveCesta(Cesta cesta) {    //save
        return cestaRepository.save(cesta);
    }


    //delete cesta
    public boolean deleteCesta(Long id){
        if (cestaRepository.existsById(id)) {
            cestaRepository.deleteById(id);
            return true;
        }
        return false;
    }




    //--------------------------------- Productos ---------------------------------

    //añadir producto a la cesta
    public void addProductoToCesta(Long id) {
        productoRepository.addProductoToCesta(id);
    }

    public Optional<Producto> findProductoById(Long id) {
        return productoRepository.findById(id);
    }

    //get producto by id
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    //save
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    //delete
    public boolean deleteProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }




}

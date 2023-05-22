package es.severo.EasyProtein.services;

import es.severo.EasyProtein.entities.Creatina;
import es.severo.EasyProtein.entities.Proteina;
import es.severo.EasyProtein.repository.*;
import jakarta.transaction.Transactional;
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


    public DatabaseService(AminoacidoRepository aminoacidoRepository, CarbohidratosRepository carbohidratosRepository, ProteinaRepository proteinaRepository, VitaminaRepository vitaminaRepository, CreatinaRepository creatinaRepository) {
        this.aminoacidoRepository = aminoacidoRepository;
        this.carbohidratosRepository = carbohidratosRepository;
        this.proteinaRepository = proteinaRepository;
        this.vitaminaRepository = vitaminaRepository;
        this.creatinaRepository = creatinaRepository;
    }

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

    public List<Proteina> findProteinaBySabor(String columnaSabor, String sabor) {
        return proteinaRepository.findProteinaBySabor(columnaSabor, sabor);
    }


    //findProteinaById
    public Optional<Proteina> findProteinaById(Long id) {
        return proteinaRepository.findById(id);
    }

//    select * from prot where 1 = 1
//    string builder.append




//    public List<Proteina> findProteinaByMarca(String marca) {
//        return proteinaRepository.findProteinaByMarca(marca);
//    }
//
//    public List<Proteina> findProteinaBySabor(String sabor) {
//        return proteinaRepository.findProteinaBySabor(sabor);
//    }


    public List<Creatina> findAllCreatina() {
        return creatinaRepository.findAll();
    }
}

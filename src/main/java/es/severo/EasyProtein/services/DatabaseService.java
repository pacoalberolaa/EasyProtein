package es.severo.EasyProtein.services;

import es.severo.EasyProtein.entities.Creatina;
import es.severo.EasyProtein.entities.Proteina;
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

    //findProteinaById
    public Optional<Proteina> findProteinaById(Long id) {
        return proteinaRepository.findById(id);
    }

    public List<Creatina> findAllCreatina() {
        return creatinaRepository.findAll();
    }
}

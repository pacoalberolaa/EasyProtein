package es.severo.EasyProtein.services;

import es.severo.EasyProtein.entities.Aminoacidos;
import es.severo.EasyProtein.entities.Proteina;
import es.severo.EasyProtein.repository.AminoacidoRepository;
import es.severo.EasyProtein.repository.CarbohidratosRepository;
import es.severo.EasyProtein.repository.ProteinaRepository;
import es.severo.EasyProtein.repository.VitaminaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {
    private final AminoacidoRepository aminoacidoRepository;
    private final CarbohidratosRepository carbohidratosRepository;
    private final ProteinaRepository proteinaRepository;
    private final VitaminaRepository vitaminaRepository;


    public DatabaseService(AminoacidoRepository aminoacidoRepository, CarbohidratosRepository carbohidratosRepository, ProteinaRepository proteinaRepository, VitaminaRepository vitaminaRepository) {
        this.aminoacidoRepository = aminoacidoRepository;
        this.carbohidratosRepository = carbohidratosRepository;
        this.proteinaRepository = proteinaRepository;
        this.vitaminaRepository = vitaminaRepository;
    }

    public List<Proteina> findAllProteinas() {
        return proteinaRepository.findAll();
    }
}

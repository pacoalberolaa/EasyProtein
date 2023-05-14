package es.severo.EasyProtein.repository;

import es.severo.EasyProtein.entities.Proteina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProteinaRepository extends JpaRepository<Proteina, Long> {
    Optional<Proteina> findById(Long id);
}

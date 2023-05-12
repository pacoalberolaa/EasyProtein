package es.severo.EasyProtein.repository;

import es.severo.EasyProtein.entities.Vitaminas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitaminaRepository extends JpaRepository<Vitaminas, Long> {
}

package es.severo.EasyProtein.repository;

import es.severo.EasyProtein.entities.Aminoacido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AminoacidoRepository extends JpaRepository<Aminoacido, Long> {
}

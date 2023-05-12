package es.severo.EasyProtein.repository;

import es.severo.EasyProtein.entities.Aminoacidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AminoacidoRepository extends JpaRepository<Aminoacidos, Long> {
}

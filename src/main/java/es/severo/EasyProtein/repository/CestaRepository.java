package es.severo.EasyProtein.repository;

import es.severo.EasyProtein.entities.Cesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("CestaRepository")
public interface CestaRepository extends JpaRepository<Cesta, Long> {

    // borrar una cesta
    void deleteCestaById(@Param("id") Long id);

    // buscar una cesta por id
    Long findCestaIdById(@Param("id") Long id);
}

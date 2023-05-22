package es.severo.EasyProtein.repository;

import es.severo.EasyProtein.entities.Proteina;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProteinaRepository extends JpaRepository<Proteina, Long> {
    Optional<Proteina> findById(Long id);
    List<Proteina> findProteinaByTipo(String tipo);

    @Transactional
    @Query(value = "SELECT * FROM Proteina p where 1 = 1", nativeQuery = true)
    List<Proteina> findAllProteinas();



//    List<Proteina> findProteinaByMarca(String marca);
//
//    List<Proteina> findProteinaBySabor(String sabor);
}

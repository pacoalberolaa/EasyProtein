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

    //Filtrar por marca
    List<Proteina> findProteinaByMarca(String marca);

    //Filtar por todos los sabores posibles, sabor1, sabor2, sabor3, sabor4, sabor5
    @Transactional
    @Query(value = "SELECT * FROM Proteina p WHERE ?1 IN (p.sabor1, p.sabor2, p.sabor3, p.sabor4, p.sabor5)", nativeQuery = true)
    List<Proteina> findProteinaBySabor(String columnaSabor, String sabor);

    @Transactional
    @Query(value = "SELECT * FROM Proteina p where 1 = 1", nativeQuery = true)
    List<Proteina> findAllProteinas();


//
//    List<Proteina> findProteinaBySabor(String sabor);
}

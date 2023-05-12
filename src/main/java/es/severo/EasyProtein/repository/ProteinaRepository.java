package es.severo.EasyProtein.repository;

import es.severo.EasyProtein.entities.Proteina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProteinaRepository extends JpaRepository<Proteina, Long> {

    //Buscar proteina por sabor
    public Proteina findBySaboresProteina(String sabor);
}

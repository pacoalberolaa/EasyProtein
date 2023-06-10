package es.severo.EasyProtein.repository;

import es.severo.EasyProtein.entities.Producto;
import es.severo.EasyProtein.entities.Proteina;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductosRepository")
public interface ProductosRepository extends JpaRepository<Producto, Long>{

//    @Query(value = "SELECT p "
//            + "FROM Producto p "
//            + "LEFT JOIN Proteina pr ON p.id = pr.id "
//            + "LEFT JOIN Creatina c ON p.id = c.id "
//            + "LEFT JOIN Carbohidrato ca ON p.id = ca.id "
//            + "LEFT JOIN Vitamina v ON p.id = v.id "
//            + "LEFT JOIN Barrita b ON p.id = b.id "
//            + "WHERE pr.nombre LIKE %:filter% OR pr.tipo LIKE %:filter% OR "
//            + "c.nombre LIKE %:filter% OR ca.nombre LIKE %:filter% OR ca.tipo LIKE %:filter% OR v.nombre LIKE %:filter% OR b.nombre LIKE %:filter%")
    @Query(value = "SELECT p FROM Producto p" +
            "            LEFT JOIN Proteina pr ON p.id = pr.producto" +
            "            LEFT JOIN Creatina c ON p.id = c.producto" +
            "            WHERE (pr.nombre LIKE (%:filter%)  OR pr.tipo LIKE (%:filter%) OR c.nombre LIKE (%:filter%))")
    List<Producto> findProducto(@Param("filter") String filter);

    //añadir producto a la cesta
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Cesta (productos) VALUES (:id)")
    void addProductoToCesta(@Param("id") Long id);

    //borrar producto a partir de un Id de una cesta a partir de su id





}

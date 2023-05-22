package es.severo.EasyProtein.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Otros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipos;
    private String marca;
    private Double precio;
    private String descripcion;
    private String imagenUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Productos_id")
    private Producto producto;
}

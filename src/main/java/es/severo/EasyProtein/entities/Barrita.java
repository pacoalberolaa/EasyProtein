package es.severo.EasyProtein.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "Barritas")
public class Barrita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private Double precio;
    private String sabores;
    private String descripcion;
    private String imagenUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Productos_id")
    private Producto producto;

}

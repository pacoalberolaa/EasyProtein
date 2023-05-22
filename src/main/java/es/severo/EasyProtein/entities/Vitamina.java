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

@Table(name = "Vitaminas")
public class Vitamina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private Double precio;
    private Double cantidad;
    private String descripcion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Productos_id")
    private Producto producto;
}

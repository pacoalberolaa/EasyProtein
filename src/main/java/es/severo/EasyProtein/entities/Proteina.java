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

public class Proteina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private Double precio;
    private Double cantidad1;
    private Double cantidad2;
    private Double cantidad3;
    private String tipo;
    private String sabor1;
    private String sabor2;
    private String sabor3;
    private String sabor4;
    private String sabor5;
    private String descripcion;
    @Column(name = "imagen_url")
    private String imagenUrl;
    @Column(name = "producto_estrella")
    private boolean productoEstrella;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Productos_id")
    private Producto producto;
}

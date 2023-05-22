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

public class Creatina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private Double precio;
    private Double cantidad;
    private boolean creapure;
    private String sabor1;
    private String sabor2;
    private String sabor3;
    private String sabor4;
    private String sabor5;
    private String descripcion;
    private String imagenUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Productos_id")
    private Producto producto;
}

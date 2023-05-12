package es.severo.EasyProtein.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "carbohidratos")
public class Carbohidratos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private Double precio;
    private Double cantidad;
    private String tipo;
    private String sabor1;
    private String sabor2;
    private String sabor3;
    private String sabor4;
    private String sabor5;
    private String descripcion;
    private String imagenUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_cesta")
    private Cesta cesta;

}

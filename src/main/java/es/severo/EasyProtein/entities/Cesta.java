package es.severo.EasyProtein.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Cesta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Cesta_has_Productos",
            joinColumns = @JoinColumn(name = "Cesta_id"),
            inverseJoinColumns = @JoinColumn(name = "Productos_id"))

    private List<Producto> productos;



}

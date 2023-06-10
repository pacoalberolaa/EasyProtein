package es.severo.EasyProtein.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity

@Table(name = "Cesta")
@NoArgsConstructor
public class Cesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Cesta_has_Productos",
            joinColumns = @JoinColumn(name = "Cesta_id"),
            inverseJoinColumns = @JoinColumn(name = "Productos_id"))

    private List<Producto> productos;

    @OneToOne
    @JoinColumn(name = "Usuario_id")
    private Usuario usuario;


    public Cesta(Usuario usuario) {
        this.productos = new ArrayList<>();
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

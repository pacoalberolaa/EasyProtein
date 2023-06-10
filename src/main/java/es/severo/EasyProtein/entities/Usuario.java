package es.severo.EasyProtein.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "usuario")
    private String username;

    @Column(nullable = false, name = "`contraseña`")
    private String password;

    @OneToOne(mappedBy = "usuario")
    private Cesta cesta;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

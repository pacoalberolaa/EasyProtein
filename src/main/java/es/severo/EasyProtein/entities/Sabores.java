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

@Table(name = "sabores")
public class Sabores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sabores;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_aminoacidos")
    private Aminoacidos aminoacidos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_creatina")
    private Creatina creatina;
}

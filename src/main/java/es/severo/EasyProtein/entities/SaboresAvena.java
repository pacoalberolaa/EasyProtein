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

@Table(name = "sabores_avena")
public class SaboresAvena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sabores_avena")
    private String saboresAvena;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_carbohidratos")
    private Carbohidratos carbohidratos;
}

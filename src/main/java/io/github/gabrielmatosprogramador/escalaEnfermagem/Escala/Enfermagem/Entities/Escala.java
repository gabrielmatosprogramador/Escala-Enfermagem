package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @OneToMany(mappedBy = "Profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Object> id_profissional = new ArrayList<Object>();

    @Column(nullable = false)
    @OneToMany(mappedBy = "Sitio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Object> id_sitio = new ArrayList<Object>();

    @Column(nullable = false)
    private LocalDateTime data;

}

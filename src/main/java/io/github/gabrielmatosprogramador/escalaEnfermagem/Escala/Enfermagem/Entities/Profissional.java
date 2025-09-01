package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome_completo;

    @Column(nullable = false)
    private String cargo;


    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Escala> escalas = new ArrayList<>();

    private Boolean ativo;

    @Column(nullable = false)
    private LocalDateTime data_cadastro;
}

package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sitio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;


    @OneToMany(mappedBy = "sitio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Escala> escalas = new ArrayList<>();

    private Boolean ativo;
}

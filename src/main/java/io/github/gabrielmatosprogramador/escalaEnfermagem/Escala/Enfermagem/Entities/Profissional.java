package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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


    private Boolean ativo;

    @Column(nullable = false)
    private LocalDateTime data_cadastro;

}

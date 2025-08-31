package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Escala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfissionalResponseDTO {

    private Long id;

    private String nome_completo;

    private String cargo;

    private Escala escala;

    private Boolean ativo;

    private LocalDateTime data_cadastro;

}

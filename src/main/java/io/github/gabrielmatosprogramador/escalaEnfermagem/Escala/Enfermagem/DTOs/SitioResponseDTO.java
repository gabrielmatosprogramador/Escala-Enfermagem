package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SitioResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Boolean ativo;

}

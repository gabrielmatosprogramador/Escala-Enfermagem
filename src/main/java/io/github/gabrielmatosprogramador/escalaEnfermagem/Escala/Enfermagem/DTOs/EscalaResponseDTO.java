package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Profissional;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Sitio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EscalaResponseDTO {
    private Long id;
    private List<ProfissionalResponseDTO> profissionais;
    private List<SitioResponseDTO> sitios;
    private LocalDateTime data;
}

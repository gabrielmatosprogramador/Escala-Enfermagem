package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EscalaResponseDTO {
    private Long id;
    private LocalDate data;
    private String profissionalNome;
    private String sitioNome;
    private Long profissionalId;
    private Long sitioId;
}

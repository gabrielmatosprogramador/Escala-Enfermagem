package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EscalaDTO {
    private Long profissionalId;
    private Long sitioId;
    private LocalDate data;
}

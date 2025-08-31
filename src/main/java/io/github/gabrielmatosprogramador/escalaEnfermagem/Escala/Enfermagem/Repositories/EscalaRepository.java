package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Repositories;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Escala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscalaRepository extends JpaRepository<Escala, Long> {
}

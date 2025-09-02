package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Repositories;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Escala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EscalaRepository extends JpaRepository<Escala, Long> {

    List<Escala> findByProfissionalIdAndDataBetween(Long profissionalId, LocalDate dataInicio, LocalDate dataFim);

    Optional<Escala> findByProfissionalIdAndData(Long profissionalId, LocalDate data);
}

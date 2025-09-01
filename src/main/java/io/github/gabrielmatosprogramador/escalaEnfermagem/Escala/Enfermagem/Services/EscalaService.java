package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Services;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.EscalaDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.EscalaResponseDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Escala;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Profissional;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Sitio;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Repositories.EscalaRepository;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Repositories.ProfissionalRepository;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Repositories.SitioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EscalaService {

    @Autowired
    private EscalaRepository escalaRepository;
    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private SitioRepository sitioRepository;

    public EscalaResponseDTO salvarOuAtualizarEscala(EscalaDTO dto) {
        Optional<Escala> escalaExistenteOpt = escalaRepository.findByProfissionalIdAndData(dto.getProfissionalId(), dto.getData());

        Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado com ID: " + dto.getProfissionalId()));

        Sitio sitio = sitioRepository.findById(dto.getSitioId())
                .orElseThrow(() -> new EntityNotFoundException("Sítio não encontrado com ID: " + dto.getSitioId()));

        Escala escala;
        if (escalaExistenteOpt.isPresent()) {
            escala = escalaExistenteOpt.get();
            escala.setSitio(sitio);
        } else {
            escala = new Escala();
            escala.setProfissional(profissional);
            escala.setSitio(sitio);
            escala.setData(dto.getData());
        }
        Escala escalaSalva = escalaRepository.save(escala);
        return converterParaResponseDTO(escalaSalva);
    }

    public List<EscalaResponseDTO> buscarEscalaPorProfissionalEMes(Long profissionalId, int ano, int mes) {
        YearMonth anoMes = YearMonth.of(ano, mes);
        LocalDate dataInicio = anoMes.atDay(1);
        LocalDate dataFim = anoMes.atEndOfMonth();

        List<Escala> escalasDoMes = escalaRepository.findByProfissionalIdAndDataBetween(profissionalId, dataInicio, dataFim);

        return escalasDoMes.stream()
                .map(this::converterParaResponseDTO)
                .collect(Collectors.toList());
    }

    public void removerAlocacao(Long escalaId) {
        if (!escalaRepository.existsById(escalaId)) {
            throw new EntityNotFoundException("Registro de escala não encontrado com ID: " + escalaId);
        }
        escalaRepository.deleteById(escalaId);
    }

    private EscalaResponseDTO converterParaResponseDTO(Escala escala) {
        return new EscalaResponseDTO(
                escala.getId(),
                escala.getData(),
                escala.getProfissional().getNome_completo(),
                escala.getSitio().getNome(),
                escala.getProfissional().getId(),
                escala.getSitio().getId()
        );
    }
}

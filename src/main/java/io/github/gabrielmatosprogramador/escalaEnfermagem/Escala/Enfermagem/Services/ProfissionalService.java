package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Services;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.ProfissionalDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.ProfissionalResponseDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Profissional;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Repositories.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Profissional salvarProfissional(ProfissionalDTO dto){
        Profissional profissional = new Profissional();
        profissional.setNome_completo(dto.getNome());
        profissional.setCargo(dto.getCargo());
        profissional.setData_cadastro(LocalDateTime.now());
        profissional.setAtivo(true);

        return profissionalRepository.save(profissional);
    }

    public List<Profissional> listarProfissionaisAtivos(){
       List<Profissional> profissionais = new ArrayList<Profissional>();
       profissionais = profissionalRepository.findAll();

       return profissionais;
    }

    public Profissional buscarProfissionalPorId (Long profissionalId){
        return profissionalRepository.findById(profissionalId).orElseThrow(() -> new RuntimeException("Profissional nao encontrado"));
    }

    public Profissional atualizarNomeCargoProfissional(Long id, ProfissionalDTO profissionalAtualizado){

        Profissional profissional = buscarProfissionalPorId(id);
        profissional.setNome_completo(profissionalAtualizado.getNome());
        profissional.setCargo(profissionalAtualizado.getCargo());
        profissional.setAtivo(true);

        return profissionalRepository.save(profissional);
    }

    public void desativarProfissional(Long id){
        Profissional profissional = buscarProfissionalPorId(id);
        profissional.setAtivo(false);

        profissionalRepository.save(profissional);
    }

    public void ativarProfissional(Long id){
        Profissional profissional = buscarProfissionalPorId(id);
        profissional.setAtivo(true);

        profissionalRepository.save(profissional);
    }


}

package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Controllers;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.ProfissionalDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Profissional;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Services.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    ProfissionalService profissionalService;

    @PostMapping
    public Profissional salvarProfissional(@RequestBody ProfissionalDTO dto){
        return profissionalService.salvarProfissional(dto);
    }

    @GetMapping
    public List<Profissional> findAll() {
        return profissionalService.listarProfissionaisAtivos();
    }

    @PutMapping("/{id}")
    public Profissional atualizarProfissional(@PathVariable Long id, ProfissionalDTO dto){
        return profissionalService.atualizarNomeCargoProfissional(id, dto);
    }

    @PutMapping("/{id}")
    public void desativarProfissional (@PathVariable Long id){
        profissionalService.desativarProfissional(id);
    }

    @PutMapping("/{id}")
    public void ativarProfissional (@PathVariable Long id){
        profissionalService.ativarProfissional(id);
    }

}

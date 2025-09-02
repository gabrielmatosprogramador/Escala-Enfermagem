package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Controllers;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.EscalaDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.EscalaResponseDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Services.EscalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escalas")
@CrossOrigin(origins = "*")
public class EscalaController {

    @Autowired
    EscalaService escalaService;

    @PostMapping
    public EscalaResponseDTO salvarOuAtualizar(@RequestBody EscalaDTO dto){
        return escalaService.salvarOuAtualizarEscala(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<EscalaResponseDTO>> buscarProfissionalPorData(@PathVariable Long id, @RequestParam int ano, @RequestParam int mes){
        List<EscalaResponseDTO> escalas = escalaService.buscarEscalaPorProfissionalEMes(id, ano, mes);

        return ResponseEntity.ok(escalas);
    }

    @DeleteMapping("/{escalaId}")
    public void removerAlocacao(@PathVariable Long escalaId){
        escalaService.removerAlocacao(escalaId);
    }
}

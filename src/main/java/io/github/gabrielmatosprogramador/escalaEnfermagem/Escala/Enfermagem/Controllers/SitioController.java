package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Controllers;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.SitioDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Sitio;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Services.SitioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sitios")
@CrossOrigin(origins = "*")
public class SitioController {

    @Autowired
    SitioService sitioService;

    @PostMapping
    public Sitio salvarSitio(@RequestBody SitioDTO dto){
        return sitioService.criarSitio(dto);
    }

    @GetMapping
    public List<Sitio> findAll() {
        return sitioService.todosOsSitios();
    }

    @PutMapping("/{id}/update")
    public Sitio atualizarProfissional(@PathVariable Long id, SitioDTO dto){
        return sitioService.atualizarSitio(id, dto);
    }

    @PutMapping("/{id}/desativar")
    public void desativarProfissional (@PathVariable Long id){
        sitioService.desativarSitio(id);
    }

    @PutMapping("/{id}/ativar")
    public void ativarProfissional (@PathVariable Long id){
        sitioService.ativarSitio(id);
    }

}

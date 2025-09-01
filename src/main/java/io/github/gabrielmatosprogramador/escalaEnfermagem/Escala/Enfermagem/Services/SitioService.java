package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Services;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.SitioDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.DTOs.SitioResponseDTO;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Sitio;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Repositories.SitioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SitioService {

    @Autowired
    private SitioRepository sitioRepository;

    public Sitio criarSitio(SitioDTO dto){
        Sitio sitio = new Sitio();
        sitio.setNome(dto.getNome());
        sitio.setDescricao(dto.getDescricao());
        sitio.setAtivo(true);

        return sitioRepository.save(sitio);
    }

    public List<Sitio> todosOsSitios (){
        List<Sitio> sitios = new ArrayList<>();
        sitios = sitioRepository.findAll();

        return sitios;
    }

    public Sitio buscarPorId(Long id){
        return sitioRepository.findById(id).orElseThrow(() -> new RuntimeException("Profissional nao encontrado"));
    }

    public Sitio atualizarSitio(Long id, SitioDTO dto){
        Sitio sitio = buscarPorId(id);
        sitio.setNome(dto.getNome());
        sitio.setDescricao(dto.getDescricao());
        sitio.setAtivo(true);

        return sitio;
    }

    public void desativarSitio (Long id){
        Sitio sitio = buscarPorId(id);
        sitio.setAtivo(false);

        sitioRepository.save(sitio);
    }

    public void ativarSitio (Long id){
        Sitio sitio = buscarPorId(id);
        sitio.setAtivo(true);

        sitioRepository.save(sitio);
    }

}

package io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Services;

import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Entities.Profissional;
import io.github.gabrielmatosprogramador.escalaEnfermagem.Escala.Enfermagem.Repositories.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Profissional salvarProfissional(){
        return null;
    }

}

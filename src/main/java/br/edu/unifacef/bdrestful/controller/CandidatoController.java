package br.edu.unifacef.bdrestful.controller;

import br.edu.unifacef.bdrestful.model.Candidato;
import br.edu.unifacef.bdrestful.service.CandidatoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
    // cria um obj da classe CandidatoService
    CandidatoService candidatoService;
    public CandidatoController(CandidatoService candidatoService){
        this.candidatoService = candidatoService;
    }

    // método que consulta os dados
    @GetMapping
    public List<Candidato> listaTodos(){
        return candidatoService.listaCandidatos();
    }


}

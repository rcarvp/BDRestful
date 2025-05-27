package br.edu.unifacef.bdrestful.controller;

import br.edu.unifacef.bdrestful.model.Candidato;
import br.edu.unifacef.bdrestful.service.CandidatoService;
import org.springframework.web.bind.annotation.*;

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

    // método que adiciona um candidato ao banco de dados
    @PostMapping
    public Candidato addCandidato(@RequestBody Candidato candidato){
        return candidatoService.addCandidato(candidato);
    }

    // método que remove por id um candidato do banco de dados
    @DeleteMapping("/{id}")
    public String removeCandidato(@PathVariable Long id){
        return (candidatoService.removeCandidato(id)) ?
            "Candidato removido com sucesso" :
            "Candidato não encontrado";
    }
}

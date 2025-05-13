package br.edu.unifacef.bdrestful.service;

import br.edu.unifacef.bdrestful.model.Candidato;
import br.edu.unifacef.bdrestful.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // padrão de projeto esteriótipo
// essa classe tem as regras de negócio do backend
public class CandidatoService {
    // cria um obj do tipo da interface CandidatoReposiitory
    CandidatoRepository candidatoRepository;
    // construtor com parametros
    CandidatoService(CandidatoRepository candidatoRepository){
        this.candidatoRepository = candidatoRepository;
    }

    public List<Candidato> listaCandidatos(){
        // select * from candidato
        return candidatoRepository.findAll();
    }
}

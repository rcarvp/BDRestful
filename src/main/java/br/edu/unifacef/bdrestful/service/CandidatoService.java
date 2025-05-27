package br.edu.unifacef.bdrestful.service;

import br.edu.unifacef.bdrestful.model.Candidato;
import br.edu.unifacef.bdrestful.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    // insere um candidato no banco
    public Candidato addCandidato(Candidato candidato){
        // insert into candidato
        return candidatoRepository.save(candidato);
    }
    // remove um candidato do banco
    public boolean removeCandidato(Long id){
        // verifica se o candidato existe
        if(candidatoRepository.existsById(id)){
            candidatoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Candidato> atualizaCandidato(Long id, Candidato novo){
        return candidatoRepository.findById(id).map(cand -> {
            cand.setNome(novo.getNome());
            cand.setCidade(novo.getCidade());
            cand.setEndereco(novo.getEndereco());
            cand.setNiver(novo.getNiver());
            // atualiza por cand ter id
            return candidatoRepository.save(cand);
        });
    }
}

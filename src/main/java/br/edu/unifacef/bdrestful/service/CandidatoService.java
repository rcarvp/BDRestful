package br.edu.unifacef.bdrestful.service;

import br.edu.unifacef.bdrestful.model.Candidato;
import br.edu.unifacef.bdrestful.model.Formulario;
import br.edu.unifacef.bdrestful.repository.CandidatoRepository;
import br.edu.unifacef.bdrestful.repository.FormularioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // padrão de projeto esteriótipo
// essa classe tem as regras de negócio do backend
public class CandidatoService {
    // cria um obj do tipo da interface CandidatoReposiitory
    CandidatoRepository candidatoRepository;
    FormularioRepository formularioRepository;
    // construtor com parametros
    public CandidatoService(CandidatoRepository candidatoRepository, FormularioRepository formularioRepository){
        this.candidatoRepository = candidatoRepository;
        this.formularioRepository = formularioRepository;
    }

    public List<Candidato> listaCandidatos(){
        // select * from candidato
        return candidatoRepository.findAll();
    }
    // insere um candidato no banco
    public Candidato addCandidato(Candidato candidato){
        // verifica se o formulário associado ao candidato tem no BD
        Formulario formulario = formularioRepository.findById(candidato.getFormulario().getId()).orElse(null);
        if(formulario != null) {
            // insert into candidato
            candidato.setFormulario(formulario);
            return candidatoRepository.save(candidato);
        }
        return null;
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

    public Optional<Candidato> encontrarCandidato(Long id){
        return candidatoRepository.findById(id);
    }
}

package br.edu.unifacef.bdrestful.repository;

import br.edu.unifacef.bdrestful.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

// classe interface
// todos os métodos são abstratos, não são implementados aqui
// interface herda de outra, JpaRepository
// o repositório do banco está vinculado à tabela Candidato
// a chave primária desta tabela é de tipo Long
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    // inclui todos os métodos com a tabela Candidato
    // ex: findAll (select), save (insert), remove (delete)

}

package br.edu.unifacef.bdrestful.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity // classe será uma tabela no banco de dados
public class Candidato {
    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome, endereco, cidade;
    private Date niver;

    public Candidato(Long id, String nome, String endereco, String cidade, Date niver) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.niver = niver;
    }

    public Candidato() {
    }

}

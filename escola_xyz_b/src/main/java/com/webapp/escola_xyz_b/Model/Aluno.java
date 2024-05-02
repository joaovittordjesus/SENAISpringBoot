package com.webapp.escola_xyz_b.Model;

import jakarta.persistence.Entity; // Importa a anotação @Entity para mapear a classe como uma entidade JPA
import jakarta.persistence.GeneratedValue; // Importa a anotação @GeneratedValue para especificar como a chave primária será gerada
import jakarta.persistence.GenerationType; // Importa a enumeração GenerationType para definir a estratégia de geração da chave primária
import jakarta.persistence.Id; // Importa a anotação @Id para indicar a chave primária da entidade

@Entity // Indica que esta classe é uma entidade persistente no banco de dados
public class Aluno {
    @Id // Indica que o atributo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração da chave primária como autoincremento
    private Long id; // Identificador único do aluno
    private String nome; // Nome do aluno
    private String email; // Email do aluno
    private String senha; // Senha do aluno
    private Long cpf; // CPF do aluno

    // Getters e setters para os atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}

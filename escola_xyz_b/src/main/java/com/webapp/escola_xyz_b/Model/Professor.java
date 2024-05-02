package com.webapp.escola_xyz_b.Model;

import jakarta.persistence.Entity; // Importa a anotação @Entity para mapear a classe como uma entidade JPA
import jakarta.persistence.GeneratedValue; // Importa a anotação @GeneratedValue para especificar como a chave primária será gerada
import jakarta.persistence.GenerationType; // Importa a enumeração GenerationType para definir a estratégia de geração da chave primária
import jakarta.persistence.Id; // Importa a anotação @Id para indicar a chave primária da entidade

@Entity // Indica que esta classe é uma entidade persistente no banco de dados
public class Professor {
    @Id // Indica que o atributo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração da chave primária como autoincremento
    private Long id; // Identificador único do professor

    private String nome; // Nome do professor
    private String email; // Email do professor
    private String senha; // Senha do professor
    private Long cpf; // CPF do professor

    // Getters e Setters para os atributos

    public Long getId() {
        return id; // Retorna o id do professor
    }

    public void setId(Long id) {
        this.id = id; // Define o id do professor
    }

    public String getNome() {
        return nome; // Retorna o nome do professor
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome do professor
    }

    public String getEmail() {
        return email; // Retorna o email do professor
    }

    public void setEmail(String email) {
        this.email = email; // Define o email do professor
    }

    public String getSenha() {
        return senha; // Retorna a senha do professor
    }

    public void setSenha(String senha) {
        this.senha = senha; // Define a senha do professor
    }

    public Long getCpf() {
        return cpf; // Retorna o CPF do professor
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf; // Define o CPF do professor
    }
}

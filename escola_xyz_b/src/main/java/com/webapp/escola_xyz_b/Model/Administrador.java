package com.webapp.escola_xyz_b.Model;

import java.io.Serializable;
import jakarta.persistence.Entity; // Importa a anotação @Entity para mapear a classe como uma entidade JPA
import jakarta.persistence.Id; // Importa a anotação @Id para indicar a chave primária da entidade

@Entity // Indica que esta classe é uma entidade persistente no banco de dados
public class Administrador implements Serializable {
    //Atributos

    @Id // Indica que o atributo 'id' é a chave primária da entidade
    private Long id;
    private String cpf; // CPF do administrador
    private String nome; // Nome do administrador
    private String email; // Email do administrador
    private String senha; // Senha do administrador

    // Getters e setters para os atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}

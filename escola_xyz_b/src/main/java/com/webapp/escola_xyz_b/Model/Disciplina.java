package com.webapp.escola_xyz_b.Model;

import jakarta.persistence.Entity; // Importa a anotação @Entity para mapear a classe como uma entidade JPA
import jakarta.persistence.GeneratedValue; // Importa a anotação @GeneratedValue para especificar como a chave primária será gerada
import jakarta.persistence.GenerationType; // Importa a enumeração GenerationType para definir a estratégia de geração da chave primária
import jakarta.persistence.Id; // Importa a anotação @Id para indicar a chave primária da entidade

@Entity // Indica que esta classe é uma entidade persistente no banco de dados
public class Disciplina {

    @Id // Indica que o atributo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração da chave primária como autoincremento
    private Long id; // Identificador único da disciplina
    private String nome; // Nome da disciplina
    private String codigo; // Código da disciplina
    private int cargaHoraria; // Carga horária da disciplina

    // Construtor

    public Disciplina(String nome, String codigo, int cargaHoraria) {
        this.nome = nome; // Inicializa o nome da disciplina
        this.codigo = codigo; // Inicializa o código da disciplina
        this.cargaHoraria = cargaHoraria; // Inicializa a carga horária da disciplina
    }

    // Getters e Setters para os atributos

    public Long getId() {
        return id; // Retorna o id da disciplina
    }

    public void setId(Long id) {
        this.id = id; // Define o id da disciplina
    }

    public String getNome() {
        return nome; // Retorna o nome da disciplina
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome da disciplina
    }

    public String getCodigo() {
        return codigo; // Retorna o código da disciplina
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo; // Define o código da disciplina
    }

    public int getCargaHoraria() {
        return cargaHoraria; // Retorna a carga horária da disciplina
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria; // Define a carga horária da disciplina
    }

    // Método toString para facilitar a visualização dos dados

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}

package com.webapp.escola_xyz_b.Model;

import jakarta.persistence.Entity; // Importa a anotação @Entity para mapear a classe como uma entidade JPA
import jakarta.persistence.GeneratedValue; // Importa a anotação @GeneratedValue para especificar como a chave primária será gerada
import jakarta.persistence.GenerationType; // Importa a enumeração GenerationType para definir a estratégia de geração da chave primária
import jakarta.persistence.Id; // Importa a anotação @Id para indicar a chave primária da entidade
import jakarta.persistence.JoinColumn; // Importa a anotação @JoinColumn para definir a coluna de junção em uma associação ManyToOne
import jakarta.persistence.ManyToOne; // Importa a anotação @ManyToOne para definir uma associação muitos-para-um

@Entity // Indica que esta classe é uma entidade persistente no banco de dados
public class Matricula {
    @Id // Indica que o atributo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração da chave primária como autoincremento
    private Long id; // Identificador único da matrícula

    @ManyToOne // Define uma associação muitos-para-um com a entidade Aluno
    @JoinColumn(name = "aluno_id") // Define a coluna de junção para a associação com a entidade Aluno
    private Aluno aluno; // Aluno matriculado

    @ManyToOne // Define uma associação muitos-para-um com a entidade Disciplina
    @JoinColumn(name = "disciplina_id") // Define a coluna de junção para a associação com a entidade Disciplina
    private Disciplina disciplina; // Disciplina matriculada

    private double nota; // Nota do aluno na disciplina
    private int frequencia; // Frequência do aluno na disciplina
    
    // Getters e Setters para os atributos

    public Long getId() {
        return id; // Retorna o id da matrícula
    }

    public void setId(Long id) {
        this.id = id; // Define o id da matrícula
    }

    public Aluno getAluno() {
        return aluno; // Retorna o aluno matriculado
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno; // Define o aluno matriculado
    }

    public Disciplina getDisciplina() {
        return disciplina; // Retorna a disciplina matriculada
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina; // Define a disciplina matriculada
    }

    public double getNota() {
        return nota; // Retorna a nota do aluno na disciplina
    }

    public void setNota(double nota) {
        this.nota = nota; // Define a nota do aluno na disciplina
    }

    public int getFrequencia() {
        return frequencia; // Retorna a frequência do aluno na disciplina
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia; // Define a frequência do aluno na disciplina
    }
}

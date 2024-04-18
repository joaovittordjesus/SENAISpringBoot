package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação @Autowired para injetar dependências
import org.springframework.stereotype.Controller; // Importa a anotação @Controller para identificar a classe como um controlador
import org.springframework.web.bind.annotation.*; // Importa classes relacionadas à manipulação de requisições HTTP
import org.springframework.ui.Model; // Importa a classe Model para lidar com dados que serão enviados para a view
import com.webapp.escola_xyz_b.Model.Disciplina; // Importa a classe Disciplina
import com.webapp.escola_xyz_b.Repository.DisciplinaRepository; // Importa o repositório DisciplinaRepository

@Controller // Indica que esta classe é um controlador Spring MVC
@RequestMapping("disciplinas") // Define o prefixo para todas as URLs mapeadas por este controlador
public class DisciplinaController {
    @Autowired // Anotação para injetar automaticamente uma instância de DisciplinaRepository
    private DisciplinaRepository disciplinaRepository; // Repositório para realizar operações de banco de dados relacionadas à Disciplina

    // Método para listar todas as disciplinas
    @GetMapping
    public String listarDisciplinas(Model model){
        Iterable<Disciplina> disciplinas = disciplinaRepository.findAll(); // Busca todas as disciplinas no banco de dados
        model.addAttribute("disciplinas", disciplinas); // Adiciona a lista de disciplinas ao Model
        return "lista-disciplinas"; // Retorna o nome da view que será exibida ao usuário
    }

    // Método para cadastrar uma nova disciplina
    @PostMapping
    public String cadastrarDisciplina(@ModelAttribute Disciplina disciplina){
        disciplinaRepository.save(disciplina); // Salva a disciplina no banco de dados
        return "redirect:/disciplinas"; // Redireciona o usuário de volta à página de listagem de disciplinas
    }

    // Método para mostrar os detalhes de uma disciplina específica
    @GetMapping("/{id}")
    public String detalhesDisciplina(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de disciplina inválido: " + id)); // Busca a disciplina com o ID fornecido
        model.addAttribute("disciplina", disciplina); // Adiciona a disciplina ao Model
        return "detalhes-disciplina"; // Retorna o nome da view que exibirá os detalhes da disciplina
    }

    // Método para mostrar o formulário de edição de uma disciplina
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de disciplina inválido: " + id)); // Busca a disciplina com o ID fornecido
        model.addAttribute("disciplina", disciplina); // Adiciona a disciplina ao Model
        return "formulario-edicao-disciplina"; // Retorna o nome da view que exibirá o formulário de edição
    }

    // Método para editar uma disciplina
    @PostMapping("/editar/{id}")
    public String editarDisciplina(@PathVariable Long id, @ModelAttribute Disciplina disciplinaAtualizada) {
        disciplinaAtualizada.setId(id); // Define o ID da disciplina atualizada
        disciplinaRepository.save(disciplinaAtualizada); // Salva a disciplina atualizada no banco de dados
        return "redirect:/disciplinas"; // Redireciona o usuário de volta à página de listagem de disciplinas
    }

    // Método para excluir uma disciplina
    @GetMapping("/excluir/{id}")
    public String excluirDisciplina(@PathVariable Long id) {
        disciplinaRepository.deleteById(id); // Exclui a disciplina com o ID fornecido do banco de dados
        return "redirect:/disciplinas"; // Redireciona o usuário de volta à página de listagem de disciplinas
    }
}

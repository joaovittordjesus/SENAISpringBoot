package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.webapp.escola_xyz_b.Model.Disciplina;
import com.webapp.escola_xyz_b.Repository.DisciplinaRepository;

@Controller
@RequestMapping("disciplinas")
public class DisciplinaController {

    // Injeção de dependência do repositório de Disciplina
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    // Método para listar todas as disciplinas
    @GetMapping
    public String listarDisciplinas(Model model){
        Iterable<Disciplina> disciplinas = disciplinaRepository.findAll();
        model.addAttribute("disciplinas", disciplinas);
        return "lista-disciplinas"; // Retorna a página HTML com a lista de disciplinas
    }

    // Método para cadastrar uma nova disciplina
    @PostMapping
    public String cadastrarDisciplina(@ModelAttribute Disciplina disciplina){
        disciplinaRepository.save(disciplina);
        return "redirect:/disciplinas"; // Redireciona para a página de listagem de disciplinas após o cadastro
    }

    // Método para exibir os detalhes de uma disciplina específica
    @GetMapping("/{id}")
    public String detalhesDisciplina(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de disciplina inválido: " + id));
        model.addAttribute("disciplina", disciplina);
        return "detalhes-disciplina"; // Retorna a página HTML com os detalhes da disciplina
    }

    // Método para exibir o formulário de edição de uma disciplina
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de disciplina inválido: " + id));
        model.addAttribute("disciplina", disciplina);
        return "formulario-edicao-disciplina"; // Retorna a página HTML com o formulário de edição
    }

    // Método para editar uma disciplina
    @PostMapping("/editar/{id}")
    public String editarDisciplina(@PathVariable Long id, @ModelAttribute Disciplina disciplinaAtualizada) {
        disciplinaAtualizada.setId(id);
        disciplinaRepository.save(disciplinaAtualizada);
        return "redirect:/disciplinas"; // Redireciona para a página de listagem de disciplinas após a edição
    }

    // Método para excluir uma disciplina
    @GetMapping("/excluir/{id}")
    public String excluirDisciplina(@PathVariable Long id) {
        disciplinaRepository.deleteById(id);
        return "redirect:/disciplinas"; // Redireciona para a página de listagem de disciplinas após a exclusão
    }
}

package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.webapp.escola_xyz_b.Model.Professor;
import com.webapp.escola_xyz_b.Repository.ProfessorRepository;

@Controller
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;

    Boolean professorAutenticadoBoolean = false;

    @PostMapping("/cadastrar-professor")
    public String cadastrarProfessor(Professor professor){
        //Verifica se o cpf já esta cadastrado no banco de dados
        Boolean cpfJaCadastrado = professorRepository.existsByCpf(professor.getCpf());
        if (!cpfJaCadastrado) {
            professorRepository.save(professor);
            System.out.println("Cadastro realizado com sucesso!");
        } else{
            System.out.println("Falha ao cadastrar: CPF ja cadastrado!");
        }
        return "/login/login-professor";
    }
    
    @GetMapping("interna-professor")
    public String processaPaginaInternaProfessor() {
        String url = "";
        if (professorAutenticadoBoolean) {
            url = "interna/interna-professor";
        } else{
            url = "redirect:/login-professor";
        }
        return url;
    }

    @PostMapping("acesso-professor")
    public String acessoProfessor(
        @RequestParam String cpf,
        @RequestParam String senha
    ){
        try{
            Professor professor = professorRepository.findByCpf(cpf);
            if (professor != null && professor.getSenha().equals(senha)){
                return "redirect:/interna-professor";
            } else{
                return "redirect:/login-professor";
            }
        } catch(Exception exception){
            System.out.println(exception);
            return "redirect:/login-professor";
        }
        
    }

}

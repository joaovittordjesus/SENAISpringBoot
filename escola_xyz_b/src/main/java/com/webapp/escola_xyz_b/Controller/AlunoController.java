package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.escola_xyz_b.Model.Aluno;
import com.webapp.escola_xyz_b.Repository.AlunoRepository;

@Controller
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;

    Boolean alunoAutenticadoBoolean = false;

    @PostMapping("/cadastrar-aluno")
    public String cadastrarAluno(Aluno aluno){
        //Verifica se o cpf já esta cadastrado no banco de dados
        Boolean cpfJaCadastrado = alunoRepository.existsByCpf(aluno.getCpf());
        if (!cpfJaCadastrado) {
            alunoRepository.save(aluno);
            System.out.println("Cadastro realizado com sucesso!");
        } else{
            System.out.println("Falha ao cadastrar: CPF ja cadastrado!");
        }
        return "/login/login-aluno";
    }
    
    @GetMapping("interna-aluno")
    public String processaPaginaInternaAluno() {
        String url = "";
        if (alunoAutenticadoBoolean) {
            url = "interna/interna-aluno";
        } else{
            url = "redirect:/login-aluno";
        }
        return url;
    }

    @PostMapping("acesso-aluno")
    public String acessoAluno(
        @RequestParam String cpf,
        @RequestParam String senha
    ){
        try{
            Aluno aluno = alunoRepository.findByCpf(cpf);
            if (aluno != null && aluno.getSenha().equals(senha)){
                return "redirect:/interna-aluno";
            } else{
                return "redirect:/login-aluno";
            }
        } catch(Exception exception){
            System.out.println(exception);
            return "redirect:/login-aluno";
        }
        
    }
    

}

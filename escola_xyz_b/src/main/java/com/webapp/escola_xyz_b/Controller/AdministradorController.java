package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.escola_xyz_b.Model.Administrador;
import com.webapp.escola_xyz_b.Repository.AdministradorRepository;
import com.webapp.escola_xyz_b.Repository.VerificaCadastroAdmRepository;

@Controller
public class AdministradorController {

    @Autowired
    AdministradorRepository administradorRepository;

    @Autowired
    VerificaCadastroAdmRepository verificaCadastroAdmRepository;

    Boolean acessoAdministradorBoolean = false;

    // Método para lidar com o cadastro de administradores
    @PostMapping("/cadastrar-adm") // Anotação indicando que esse método responde a requisições POST para /cadastrar-adm
    public String cadastrarAdmBD(Administrador adm) {
        // Verifica se o CPF já está cadastrado no banco de dados
        Boolean cpfJaCadastrado = verificaCadastroAdmRepository.existsById(adm.getCpf());
        if (!cpfJaCadastrado) { // Verifica se o CPF não está cadastrado
            administradorRepository.save(adm); // Salva o administrador no banco de dados
            System.out.println("Cadastro realizado com sucesso");
        } else {
            System.out.println("Falha ao cadastrar: CPF já cadastrado");
        }

        return "/login/login-adm"; // Retorna a página de login do administrador
    }

    // Método para acessar a área interna do administrador
    @GetMapping("/interna-adm") // Anotação indicando que esse método responde a requisições GET para /interna-adm
    public String getMethodName() {
        String url = "";
        if (acessoAdministradorBoolean) {
            url = "interna/interna-adm";
        } else {
            url = "redirect:/login-adm";
        }
        return url; // Retorna o redirecionamento para a página interna do administrador ou para o login
    }

    // Método para lidar com o acesso do administrador
    @PostMapping("/acesso-adm") // Anotação indicando que esse método responde a requisições POST para /acesso-adm
    public String acessoAdm(@RequestParam String cpf,
            @RequestParam String senha) {
        try {
            // Verifica se o CPF e a senha correspondem a um administrador no banco de dados
            Boolean verificaCpfBoolean = administradorRepository.existsById(cpf);
            Boolean verificaSenhaBoolean = administradorRepository.findByCpf(cpf).getSenha().equals(senha);
            String url = "";

            if (verificaCpfBoolean && verificaSenhaBoolean) {
                acessoAdministradorBoolean = true; // Define o acesso do administrador como verdadeiro
                url = "redirect:/interna-adm"; // Redireciona para a área interna do administrador
            } else {
                url = "redirect:/login-adm"; // Redireciona de volta para o login
            }
            return url; // Retorna o redirecionamento
        } catch (Exception exception) {
            System.out.println(exception);
            return "redirect:/login-adm"; // Redireciona de volta para o login em caso de exceção
            
        }
    }

}

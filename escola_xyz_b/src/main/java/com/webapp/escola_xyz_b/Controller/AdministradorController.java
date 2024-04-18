package com.webapp.escola_xyz_b.Controller;

import com.webapp.escola_xyz_b.Model.Administrador;
import com.webapp.escola_xyz_b.Repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdministradorController {

    @Autowired
    AdministradorRepository administradorRepository;

    Boolean acessoAdministradorBoolean = false;

    @PostMapping("/cadastrar-adm")
    public String cadastrarAdmBD(Administrador adm) {
        // Verifica se o CPF já está cadastrado no banco de dados
        Boolean cpfJaCadastrado = administradorRepository.existsByCpf(adm.getCpf());
        if (!cpfJaCadastrado) { // Verifica se o CPF não está cadastrado
            administradorRepository.save(adm); // Salva o administrador no banco de dados
            System.out.println("Cadastro realizado com sucesso");
        } else {
            System.out.println("Falha ao cadastrar: CPF já cadastrado");
        }

        return "/login/login-adm"; // Retorna a página de login do administrador
    }

    @GetMapping("/interna-adm")
    public String getMethodName() {
        String url = "";
        if (acessoAdministradorBoolean) {
            url = "interna/interna-adm";
        } else {
            url = "redirect:/login-adm";
        }
        return url; // Retorna o redirecionamento para a página interna do administrador ou para o login
    }

    @PostMapping("/acesso-adm")
    public String acessoAdm(@RequestParam String cpf,
                            @RequestParam String senha) {
        try {
            // Verifica se o CPF e a senha correspondem a um administrador no banco de dados.
            Administrador adm = administradorRepository.findByCpf(cpf);
            if (adm != null && adm.getSenha().equals(senha)) {
                acessoAdministradorBoolean = true; // Define o acesso do administrador como verdadeiro.
                return "redirect:/interna-adm"; // Redireciona para a área interna do administrador.
            } else {
                return "redirect:/login-adm"; // Redireciona de volta para o login.
            }
        } catch (Exception exception) {
            System.out.println(exception);
            return "redirect:/login-adm"; // Redireciona de volta para o login em caso de exceção.
        }
    }
}

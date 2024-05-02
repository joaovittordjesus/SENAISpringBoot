package com.webapp.escola_xyz_b.Controller;

import com.webapp.escola_xyz_b.Model.Administrador; // Importa a classe Administrador
import com.webapp.escola_xyz_b.Repository.AdministradorRepository; // Importa o repositório AdministradorRepository
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação @Autowired para injetar dependências
import org.springframework.stereotype.Controller; // Importa a anotação @Controller para identificar a classe como um controlador
import org.springframework.web.bind.annotation.*; // Importa classes relacionadas à manipulação de requisições HTTP

@Controller // Indica que esta classe é um controlador Spring MVC
public class AdministradorController {

    @Autowired // Anotação para injetar automaticamente uma instância de AdministradorRepository
    AdministradorRepository administradorRepository;

    Boolean administradorAutenticadBoolean = false; // Variável para controlar o acesso do administrador

    @PostMapping("/cadastrar-adm") // Mapeia uma requisição POST para "/cadastrar-adm" para este método
    public String cadastrarAdmBD(Administrador administrador) {
        // Verifica se o CPF já está cadastrado no banco de dados
        Boolean cpfJaCadastrado = administradorRepository.existsByCpf(administrador.getCpf());
        if (!cpfJaCadastrado) { // Verifica se o CPF não está cadastrado
            administradorRepository.save(administrador); // Salva o administrador no banco de dados
            System.out.println("Cadastro realizado com sucesso"); // Imprime uma mensagem de sucesso
        } else {
            System.out.println("Falha ao cadastrar: CPF já cadastrado"); // Imprime uma mensagem de falha
        }

        return "/login/login-adm"; // Retorna a página de login do administrador
    }

    @GetMapping("/interna-adm") // Mapeia uma requisição GET para "/interna-adm" para este método
    public String processaPaginaInternaAdministrador() {
        String url = ""; // Inicializa uma variável de URL vazia
        if (administradorAutenticadBoolean) { // Verifica se o acesso do administrador é verdadeiro
            url = "interna/interna-adm"; // Define a URL para a página interna do administrador
        } else {
            url = "redirect:/login-adm"; // Define a URL para redirecionar para a página de login do administrador
        }
        return url; // Retorna a URL correspondente
    }

    @PostMapping("/acesso-adm") // Mapeia uma requisição POST para "/acesso-adm" para este método
    public String acessoAdm(@RequestParam String cpf,
                            @RequestParam String senha) {
        try {
            // Verifica se o CPF e a senha correspondem a um administrador no banco de dados.
            Administrador administrador = administradorRepository.findByCpf(cpf); // Busca o administrador pelo CPF
            if (administrador != null && administrador.getSenha().equals(senha)) { // Verifica se o administrador foi encontrado e a senha está correta
                administradorAutenticadBoolean = true; // Define o acesso do administrador como verdadeiro.
                return "redirect:/interna-adm"; // Redireciona para a área interna do administrador.
            } else {
                return "redirect:/login-adm"; // Redireciona de volta para o login.
            }
        } catch (Exception exception) {
            System.out.println(exception); // Imprime qualquer exceção ocorrida
            return "redirect:/login-adm"; // Redireciona de volta para o login em caso de exceção.
        }
    }
}

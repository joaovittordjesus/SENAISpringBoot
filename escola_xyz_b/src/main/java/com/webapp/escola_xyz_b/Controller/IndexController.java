package com.webapp.escola_xyz_b.Controller;

import org.springframework.stereotype.Controller; // Importa a anotação @Controller para identificar a classe como um controlador
import org.springframework.web.bind.annotation.GetMapping; // Importa a anotação @GetMapping para mapear solicitações GET

@Controller // Indica que esta classe é um controlador Spring MVC
public class IndexController {

    // Define um método para mapear a solicitação GET para "/home"
    @GetMapping("/home")
    public String acessoHomePage() {
        return "index"; // Retorna o nome da página "index"
    }

    // Define um método para mapear a solicitação GET para "/login-adm"
    @GetMapping("login-adm")
    public String acessoPageLoginAdm() {
        return "login/login-adm"; // Retorna o nome da página "login-adm" dentro do diretório "login"
    }
    
    // Define um método para mapear a solicitação GET para "/cadastro-adm"
    @GetMapping("cadastro-adm")
    public String getMethodName() {
        return "cadastro/cadastro-adm"; // Retorna o nome da página "cadastro-adm" dentro do diretório "cadastro"
    }
}

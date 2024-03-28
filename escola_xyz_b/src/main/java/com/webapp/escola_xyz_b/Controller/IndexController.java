package com.webapp.escola_xyz_b.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
    //Criando o endereços/links e definindo o local da página/mapeamento.

    @GetMapping("/home")
    public String acessoHomePage() {
        return "index";
    }

    @GetMapping("login-adm")
    public String acessoPageLoginAdm() {
        return "login/login-adm";
    }
    @GetMapping("cadastro-adm")
    public String getMethodName() {
        return "cadastro/cadastro-adm";
    }
    
    
    
}

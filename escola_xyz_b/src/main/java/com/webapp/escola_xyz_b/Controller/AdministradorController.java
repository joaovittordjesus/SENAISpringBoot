package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.webapp.escola_xyz_b.Model.Administrador;
import com.webapp.escola_xyz_b.Repository.AdministradorRepository;
import com.webapp.escola_xyz_b.Repository.VerificaCadastroAdmRepository;


@Controller
public class AdministradorController {

    @Autowired//Informa que essa interface será utilizada para registrar as informações no BD
    AdministradorRepository administradorRepository;

    @Autowired
    VerificaCadastroAdmRepository verificaCadastroAdmRepository;
    
    @PostMapping("cadastrar-adm")
    public String cadastrarAdmBD(Administrador adm) {
        Boolean verificaCpf = verificaCadastroAdmRepository.existsById(adm.getCpf());
        if (verificaCpf.equals(adm.getCpf())){
            administradorRepository.save(adm);
            System.out.println("Cadastro realizado com sucesso");
        }
        else{
            System.out.println("Falha na ao cadastrar");
        }

        return "/login/login-adm";
    }
    
    @PostMapping("aceso-adm")
    public String postMethodName() {
        //Metodo para verificar acesso
        return entity;
    }
    
}

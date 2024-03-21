package com.escola.escola_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.escola.escola_crud.repository.AdministradorRepository;

@Controller
public class AdministradorController {
    @Autowired
    private AdministradorRepository administradorRepository;
    //Métodos para CRUD de administradores
}

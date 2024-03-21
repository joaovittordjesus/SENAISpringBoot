package com.escola.escola_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.escola.escola_crud.repository.AlunoRepository;

@Controller
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;
    //Métodos para CRUD de alunos
}

package com.escola.escola_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.escola.escola_crud.repository.ProfessorRepository;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;
    //Métodos para CRUD de professores
}

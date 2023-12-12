package com.example.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/req")
public class Requerimientos {
    @GetMapping
    public String mostrarPagina() {
        return "index";
    }
}

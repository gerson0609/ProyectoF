package com.example.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manual")
public class ManualUsuario {
    @GetMapping
    public String mostrarPagina() {
        return "index2";
    }
}

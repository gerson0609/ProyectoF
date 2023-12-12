package com.example.proyecto;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private DatabaseService databaseService; // Inject DatabaseService here

    @GetMapping
    public String hello(){
        return "Hello word";
    }

    @GetMapping("/all")
    public List<Nota> all() {
        return databaseService.getAllNot() ;
    }
    @GetMapping("/get")
    public Nota all(int id) {
        return databaseService.getNota(id) ;
    }

    @PutMapping("/edit")
    public void update(String nombre, String descripcion, int id, int prioridad, String titulo) {
        Nota nota = new Nota(id, nombre, descripcion, prioridad, titulo, titulo);
        databaseService.updateNota(nota) ;
    }
    
    @PostMapping("/post")
    public void insert(String nombre, String descripcion, int id, String titulo, int prioridad) {

        Nota nota = new Nota(id, nombre, descripcion, prioridad, titulo, titulo);
        databaseService.insertNota(nota) ;
    }

    @PostMapping("/login")
    public Usuario loginUser(String username, String password) {
    Usuario  tmpUser =  databaseService.authenticateUser(username,password) ;
    tmpUser.setJTW();
    return tmpUser;
    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        databaseService.deleteNota(id) ;
    }
}

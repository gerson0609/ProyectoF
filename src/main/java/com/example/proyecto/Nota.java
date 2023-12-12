package com.example.proyecto;

public class Nota {
    //atributos
    private int id;
    private String titulo;
    private String nombre;
    private String descripcion;
    private int prioridad;

    //Constructor
    public Nota(int id, String titulo, String descripcion, int prioridad, String titulo2, String prioridad2) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }   

    public Nota(int id2, String nombre, String descripcion2, String titulo2, int prioridad2) {
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void add(Nota nota) {
    }

    public String getNombre() {
        return nombre;
    }
        public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package com.example.luma.biblioteca.Listas;

public class ListaLibros {
        public String nombre;
        public String fecha1;
        public String fecha2;
     ;

    public ListaLibros(String nombre, String fecha1, String fecha2) {
        this.nombre = nombre;
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }
}

package com.example.luma.biblioteca.Modelos;

public class Prestamo {

    private int id_prestamo;
    private String fecha_prestamo;
    private String fecha_entrega;
    private String id_libro;
    private  int id_usuario;
    private String created_at;
    private String updated_at;
    private String deleted_at;

    public Prestamo(int id_prestamo, String fecha_prestamo, String fecha_entrega, String id_libro, int id_usuario, String created_at, String updated_at, String deleted_at) {
        this.id_prestamo = id_prestamo;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_entrega = fecha_entrega;
        this.id_libro = id_libro;
        this.id_usuario = id_usuario;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public String getId_libro() {
        return id_libro;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
}

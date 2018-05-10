package com.example.luma.biblioteca.Modelos;

public class Usuario {

    private  int id_usuario;
    private String correo;
    private String cc;
    private String nombre;
    private String apellido;
    private String password;
    private String genero;
    private int edad;
    private String remember_token;
    private String api_token;
    private String created_at;
    private String updated_at;
    private String deleted_at;

    public Usuario(int id_usuario, String correo, String cc, String nombre, String apellido, String password, String genero, int edad, String remember_token, String api_token, String created_at, String updated_at, String deleted_at) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.cc = cc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.genero = genero;
        this.edad = edad;
        this.remember_token = remember_token;
        this.api_token = api_token;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCc() {
        return cc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public String getApi_token() {
        return api_token;
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

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
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

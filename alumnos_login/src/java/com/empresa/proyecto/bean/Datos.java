package com.empresa.proyecto.bean;

public class Datos {
    int Id;
    String Nombre;
    String Apellido_p;
    String Apellido_M;
    String Mail;
    String User;
    String Pass;
    String Mensaje;

    public Datos() {}
    
    public Datos(int Id, String Nombre, String Apellido_P, String Apellido_M, String Mail, String User, String Pass, String Mensaje) {
   
    this.Id = Id;
    this.Nombre = Nombre;
    this.Apellido_p = Apellido_P;
    this.Apellido_M = Apellido_M;
    this.Mail = Mail;
    this.User = User;
    this.Pass = Pass;
    this.Mensaje = Mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido_p() {
        return Apellido_p;
    }

    public void setApellido_p(String Apellido_p) {
        this.Apellido_p = Apellido_p;
    }

    public String getApellido_M() {
        return Apellido_M;
    }

    public void setApellido_M(String Apellido_M) {
        this.Apellido_M = Apellido_M;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
}
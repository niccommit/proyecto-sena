package com.inventpro.model;

/**
 * User
 */
public class User {

    private int idUsuario;
    private String nombreCompleto;
    private String email;
    private String passwordHash;
    private String rol;
    private int idOrganizacion;

    public User() {
    };

    public User(int idUsuario, String nombreCompleto, String email, String passwordHash, String rol,
            int idOrganizacion) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.idOrganizacion = idOrganizacion;
    };

    // Getters & Setters
    public int getIdUser() {
        return idUsuario;
    };

    public void setIdUser(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getName() {
        return nombreCompleto;
    };

    public void setName(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    };

    public String getEmail() {
        return email;
    };

    public void setEmail(String email) {
        this.email = email;
    };

    public String getPasswordHash() {
        return passwordHash;
    };

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    };

    public String getRole() {
        return rol;
    };

    public void setRole(String rol) {
        this.rol = rol;
    };

    public int getIdOrganization() {
        return idOrganizacion;
    };

    public void setIdOrganization(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    };

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario = " + idUsuario +
                ", nombre = " + nombreCompleto +
                ", email = " + email +
                ", rol = " + rol +
                ", id_organizacion = " + idOrganizacion +
                "}";
    }

}

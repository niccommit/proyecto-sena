package com.inventpro.dao;

import com.inventpro.connection.InnerConnectionDB;
import com.inventpro.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO
 */
public class UserDAO {

    public void insert(User user) {
        String sql = "INSERT INTO Usuario (id_usuario, nombre_completo, email, password_hash, rol) VALUES (?, ?, ?, ?, ?);";
        try (Connection conn = InnerConnectionDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getIdUser());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPasswordHash());
            stmt.setString(5, user.getRole());
            // stmt.setInt(5, user.getIdOrganization());
            stmt.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(" Error al insertar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para consultar todos los usuarios (R)
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Connection conn = InnerConnectionDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("id_usuario"));
                user.setName(rs.getString("nombre_completo"));
                user.setEmail(rs.getString("email"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setRole(rs.getString("rol"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(" Error al listar usuarios: " + e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    // Método par actualizar un usuario (U)
    public void update(User user) {
        String sql = "UPDATE Usuario SET nombre_completo = ?, email = ?, password_hash = ?, rol = ?, id_organizacion = ? WHERE id_usuario = ?;";
        try (Connection conn = InnerConnectionDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Asignación de los valores de los parámetros en el orden correcto
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPasswordHash());
            stmt.setString(4, user.getRole());
            stmt.setNull(5, java.sql.Types.INTEGER);
            stmt.setInt(6, user.getIdUser());

            stmt.executeUpdate();
            System.out.println("✅ Usuario con ID: " + user.getIdUser() + " actualizado.");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para eliminar un usuario (D)
    public void delete(int idUser) {
        String sql = "DELETE FROM Usuario WHERE id_usuario= ?;";
        try (Connection conn = InnerConnectionDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUser);
            stmt.executeUpdate();
            System.out.println(" Usuario con ID: " + idUser + " eliminado.");
        } catch (SQLException e) {
            System.out.println(" Error al eliminar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

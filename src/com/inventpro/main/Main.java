package com.inventpro.main;

import com.inventpro.dao.UserDAO;
import com.inventpro.model.User;

import java.util.List;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        UserDAO userDao = new UserDAO();

        // 1. Insertar un nuevo usuario
        System.out.println("--- PRUEBA INSERTAR USUARIO---");
        User newUser = new User();
        newUser.setIdUser(1);
        newUser.setName("Nicolás Pantoja");
        newUser.setEmail("nicolasa@mail.com");
        newUser.setPasswordHash("Root1234");
        newUser.setRole("Admin");
        // newUser.setIdOrganization(1);
        userDao.insert(newUser);
        try {
            Thread.sleep(1000); // Pausa el programa por 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n --- PRUEBA: LISTAR TODOS LOS USUARIOS ---");
        List<User> usersList = userDao.findAll();
        for (User user : usersList) {
            System.out.println(user.toString());
        }

        // Asumiendo que el usuario insertado tiene ID 1 (si el campo es serial
        // auto-increment)
        int idUserUpdate = 1;
        User userUpdate = new User();
        userUpdate.setIdUser(idUserUpdate);
        userUpdate.setName("Samuel Pantoja");
        userUpdate.setEmail("samuel@mail.com");
        userUpdate.setPasswordHash("new123");
        userUpdate.setRole("Director");
        // userUpdate.setIdOrganization(null);

        System.out.println("\n ---- PRUEBA: ACTUALIZAR USUARIO----");
        userDao.update(userUpdate);

        System.out.println("\n ---- PRUEBA: LISTAR USUARIOS ACTUALIZADOS ----");
        userDao.findAll().forEach(System.out::println);

        // 4. Eliminar un usuario
        int idUserDelete = 1;
        System.out.println("\n ---- PRUEBA: ELIMINAR USUARIO ----");
        userDao.delete(idUserDelete);

        System.out.println("\n PRUEBA: LISTAR USUARIOS DESPUÉS DE ELIMINADOS.");
        userDao.findAll().forEach(System.out::println);
    }
}

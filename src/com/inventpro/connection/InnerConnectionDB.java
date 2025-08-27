package com.inventpro.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * InnerConnectionDB
 */
public class InnerConnectionDB {
    /*
     *
     * "POSTGRES_PASSWORD=inventpro",
     * "POSTGRES_USER=inventpro",
     * "POSTGRES_DB=inventpro-db",
     * "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/postgresql/17/bin",
     * "GOSU_VERSION=1.17",
     * "LANG=en_US.utf8",
     * "PG_MAJOR=17",
     * "PG_VERSION=17.6-1.pgdg13+1",
     * "PGDATA=/var/lib/postgresql/data"
     */
    private static final String URL = "jdbc:postgresql://172.17.0.2:5432/inventpro-db";
    private static final String USER = "inventpro";
    private static final String PASSWORD = "inventpro";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            // Carga el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Establece la conexión
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión establecida con la DB");
        } catch (ClassNotFoundException e) {
            System.out.println(" Error: Driver de postgresql no encontrado.");
        } catch (SQLException e) {
            System.out.println(" Error al conectar la DB: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Cierre de conexión.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package com.tienda.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/tienda_mvc_java";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "";

    public static Connection getConexion() {

        Connection con = null;

        try {

            Class.forName(
                    "org.mariadb.jdbc.Driver");

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);

            System.out.println(
                    "CONEXION EXITOSA");

        } catch (Exception e) {

            System.out.println(
                    "CONEXION FALLIDA");

            e.printStackTrace();
        }

        return con;
    }
}
package com.tienda.dao;

import com.tienda.config.Conexion;
import com.tienda.util.Hash;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean login(String correo, String password) {

        try {

            String sql =
                    "SELECT * FROM usuarios WHERE correo=?";

            con = Conexion.getConexion();

            ps = con.prepareStatement(sql);

            ps.setString(1, correo);

            rs = ps.executeQuery();

            if (rs.next()) {

                String hashBD =
                        rs.getString("password_hash");

                String hashJava =
                        Hash.sha256(password);

                return hashBD.equals(hashJava);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    public boolean registrar(String nombre,
                         String correo,
                         String password) {

    try {

        String sql =
        "INSERT INTO usuarios(nombre, correo, password_hash, id_rol) VALUES(?,?,?,?)";

        con = Conexion.getConexion();

        System.out.println("CONEXION = " + con);

        ps = con.prepareStatement(sql);

        ps.setString(1, nombre);
        ps.setString(2, correo);
        ps.setString(3, Hash.sha256(password));
        ps.setInt(4, 2);

        System.out.println("INTENTANDO INSERTAR");

        int filas = ps.executeUpdate();

        System.out.println("FILAS = " + filas);

        return filas > 0;

    } catch (Exception e) {

        System.out.println("ERROR EN REGISTRO");

        e.printStackTrace();
    }

    return false;
}
}
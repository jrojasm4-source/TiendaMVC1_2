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
                    "INSERT INTO usuarios(nombre, correo, password_hash, rol_id) VALUES(?,?,?,?)";

            con = Conexion.getConexion();

            ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, Hash.sha256(password));

            // Rol CLIENTE
            ps.setInt(4, 2);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
}
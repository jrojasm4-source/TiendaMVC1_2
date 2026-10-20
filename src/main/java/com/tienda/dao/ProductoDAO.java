package com.tienda.dao;

import com.tienda.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import com.tienda.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDAO {

    public List<Producto> listar() {

    List<Producto> lista = new ArrayList<>();

    try {

        Connection con = Conexion.getConexion();

        String sql =
                "SELECT * FROM productos WHERE activo = 1";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Producto p = new Producto();

            p.setId(rs.getInt("id_producto"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setPrecio(rs.getDouble("precio"));
            p.setStock(rs.getInt("stock"));
            p.setFoto(rs.getString("foto"));
            p.setActivo(rs.getBoolean("activo"));

            lista.add(p);
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}
    public Producto buscarPorId(int id) {

        for (Producto p : listar()) {

            if (p.getId() == id) {
                return p;
            }

        }

        return null;
    }

    public boolean guardar(Producto producto) {

        System.out.println("Producto guardado: " +
                producto.getNombre());

        return true;
    }

    public boolean actualizar(Producto producto) {

        System.out.println("Producto actualizado: " +
                producto.getNombre());

        return true;
    }

    public boolean eliminar(int id) {

        System.out.println("Producto eliminado: " + id);

        return true;
    }
}
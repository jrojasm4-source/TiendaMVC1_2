package com.tienda.dao;

import com.tienda.config.Conexion;
import java.sql.*;

public class PedidoDAO {

    public int crearPedido(int idUsuario, double total) {

        int idPedido = 0;

        try {

            Connection con = Conexion.getConexion();

            String sql =
                    "INSERT INTO pedidos(id_usuario,total,estado) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(
                            sql,
                            Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idUsuario);
            ps.setDouble(2, total);
            ps.setString(3, "PENDIENTE");

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idPedido = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return idPedido;
    }

    public void crearDetalle(
            int idPedido,
            int idProducto,
            int cantidad,
            double precio,
            double subtotal) {

        try {

            Connection con = Conexion.getConexion();

            String sql =
                    "INSERT INTO pedido_detalle(id_pedido,id_producto,cantidad,precio_unitario,subtotal) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, idPedido);
            ps.setInt(2, idProducto);
            ps.setInt(3, cantidad);
            ps.setDouble(4, precio);
            ps.setDouble(5, subtotal);

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
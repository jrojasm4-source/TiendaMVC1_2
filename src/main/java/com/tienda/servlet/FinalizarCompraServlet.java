package com.tienda.servlet;

import com.tienda.dao.PedidoDAO;
import com.tienda.modelo.ItemCarrito;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/finalizar")
public class FinalizarCompraServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        HttpSession sesion =
                request.getSession();

        List<ItemCarrito> carrito =
                (List<ItemCarrito>)
                sesion.getAttribute("carrito");

        if (carrito == null || carrito.isEmpty()) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/carrito.jsp");

            return;
        }

        double total = 0;

        for (ItemCarrito item : carrito) {

            total += item.getSubtotal();

        }

        PedidoDAO dao = new PedidoDAO();

        // Usuario de prueba
        int idPedido =
                dao.crearPedido(1, total);

        for (ItemCarrito item : carrito) {

            dao.crearDetalle(
                    idPedido,
                    item.getProducto().getId(),
                    item.getCantidad(),
                    item.getProducto().getPrecio(),
                    item.getSubtotal());

        }

        sesion.removeAttribute("carrito");

        response.sendRedirect(
                request.getContextPath()
                + "/carrito.jsp");
    }
}
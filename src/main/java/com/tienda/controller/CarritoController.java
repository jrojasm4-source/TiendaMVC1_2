package com.tienda.controller;

import com.tienda.dao.ProductoDAO;
import com.tienda.modelo.ItemCarrito;
import com.tienda.modelo.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/carrito")
public class CarritoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int idProducto =
                Integer.parseInt(
                        request.getParameter("idProducto"));

        int cantidad =
                Integer.parseInt(
                        request.getParameter("cantidad"));

        ProductoDAO dao =
                new ProductoDAO();

        Producto producto =
                dao.buscarPorId(idProducto);

        HttpSession sesion =
                request.getSession();

        List<ItemCarrito> carrito =
                (List<ItemCarrito>)
                sesion.getAttribute("carrito");

        if (carrito == null) {

            carrito = new ArrayList<>();

        }

        ItemCarrito item =
                new ItemCarrito(
                        producto,
                        cantidad);

        carrito.add(item);

        sesion.setAttribute(
                "carrito",
                carrito);

        response.sendRedirect(
                request.getContextPath()
                + "/carrito.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion =
                request.getParameter("accion");

        if ("vaciar".equals(accion)) {

            HttpSession sesion =
                    request.getSession();

            sesion.removeAttribute("carrito");

            response.sendRedirect(
                    request.getContextPath()
                    + "/carrito.jsp");
        }
    }
}

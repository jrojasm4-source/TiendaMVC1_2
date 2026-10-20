package com.tienda.controller;

import com.tienda.dao.ProductoDAO;
import com.tienda.modelo.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/productos")
public class ProductoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ProductoDAO dao = new ProductoDAO();

        List<Producto> productos = dao.listar();

        request.setAttribute("productos", productos);

        request.getRequestDispatcher("/productos.jsp")
               .forward(request, response);
    }
}

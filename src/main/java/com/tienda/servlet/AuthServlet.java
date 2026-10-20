package com.tienda.servlet;

import com.tienda.controller.AuthController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().println(
                "AuthServlet funcionando");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion =
                request.getParameter("accion");

        if ("login".equals(accion)) {

            String correo =
                    request.getParameter("correo");

            String password =
                    request.getParameter("password");

            AuthController auth =
                    new AuthController();

            boolean acceso =
                    auth.autenticar(
                            correo,
                            password);

            if (acceso) {

                HttpSession sesion =
                        request.getSession();

                sesion.setAttribute(
                        "usuario",
                        correo);

                response.sendRedirect(
                        "index.jsp");

            } else {

                request.setAttribute(
                        "error",
                        "Correo o contraseña incorrectos");

                request.getRequestDispatcher(
                        "login.jsp")
                        .forward(request, response);
            }

        } else if ("registro".equals(accion)) {

            String nombre =
                    request.getParameter("nombre");

            String correo =
                    request.getParameter("correo");

            String password =
                    request.getParameter("password");

            AuthController auth =
                    new AuthController();

            boolean registrado =
                    auth.registrar(
                            nombre,
                            correo,
                            password);

            if (registrado) {

                request.setAttribute(
                        "mensaje",
                        "Usuario registrado correctamente");

                request.getRequestDispatcher(
                        "login.jsp")
                        .forward(request, response);

            } else {

                request.setAttribute(
                        "error",
                        "No fue posible registrar el usuario");

                request.getRequestDispatcher(
                        "registro.jsp")
                        .forward(request, response);
            }

        } else if ("logout".equals(accion)) {

            HttpSession sesion =
                    request.getSession();

            sesion.invalidate();

            response.sendRedirect(
                    "login.jsp");
        }
    }
}
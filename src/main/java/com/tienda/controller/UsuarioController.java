package com.tienda.controller;

import com.tienda.dao.UsuarioDAO;

public class UsuarioController {

    private UsuarioDAO dao = new UsuarioDAO();

    public boolean login(String correo,
                         String password) {

        return dao.login(
                correo,
                password);

    }

    public boolean registrar(String nombre,
                             String correo,
                             String password) {

        return dao.registrar(
                nombre,
                correo,
                password);

    }
}
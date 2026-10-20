package com.tienda.controller;

public class AuthController {

    public boolean autenticar(
            String correo,
            String password) {

        UsuarioController uc =
                new UsuarioController();

        return uc.login(
                correo,
                password);
    }

    public boolean registrar(
            String nombre,
            String correo,
            String password) {

        UsuarioController uc =
                new UsuarioController();

        return uc.registrar(
                nombre,
                correo,
                password);
    }
}
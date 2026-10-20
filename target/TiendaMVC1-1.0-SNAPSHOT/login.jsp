<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Ingresar | Tienda MVC</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
    </head>

    <body>
        <%@ include file="/WEB-INF/jspf/menu.jspf" %>
        <main class="auth">
            <section class="auth-copy"><span>BIENVENIDO</span>
                <h1>Todo lo que necesitas en un solo lugar</h1>
                <p>Ingresa para finalizar compras, consultar pedidos y disfrutar una experiencia personalizada.
                </p>
            </section>
            <section class="auth-card">
                <h2>Iniciar sesión</h2>
                <c:if test="${not empty error}">
                    <div class="alert error">${error}</div>
                </c:if>
                <c:if test="${not empty mensaje}">
                    <div class="alert success">${mensaje}</div>
                </c:if>
                <form action="${pageContext.request.contextPath}/auth" method="post"><input type="hidden"
                                                                                            name="accion" value="login"><label>Correo<input type="email" name="correo" required
                                                                    autocomplete="email"></label><label>Contraseña<input type="password" name="password"
                                                                         required autocomplete="current-password"></label><button
                        class="btn-primary">Ingresar</button></form>

                <p style="margin-top:15px;">
                    Prueba administrador:
                    admin@tienda.com / admin123
                </p>

                <p>
                    Prueba cliente:
                    cliente@tienda.com / cliente123
                </p>

                <p>
                    ¿No tienes cuenta?  
                    <a href="${pageContext.request.contextPath}/registro.jsp">Regístrate</a>

                </p>
            </section>
        </main>
    </body>

</html>
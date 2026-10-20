<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro | Tienda MVC</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<%@ include file="/WEB-INF/jspf/menu.jspf" %>

<main class="auth-container">
    <section class="auth-card">
        <h1>Crear cuenta</h1>
        <p>Regístrate como cliente para agregar productos al carrito.</p>

        <form action="${pageContext.request.contextPath}/auth" method="post">
            <input type="hidden" name="accion" value="registro">

            <label>Nombre completo</label>
            <input type="text" name="nombre" required>

            <label>Correo</label>
            <input type="email" name="correo" required>

            <label>Contraseña</label>
            <input type="password" name="password" required>

            <button type="submit" class="btn-primary">Registrarme</button>
        </form>

        <a href="${pageContext.request.contextPath}/login.jsp">Ya tengo cuenta</a>
    </section>
</main>
</body>
</html>
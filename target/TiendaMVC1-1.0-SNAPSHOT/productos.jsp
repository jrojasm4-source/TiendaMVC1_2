<%-- 
    Document   : productos
    Created on : 7/10/2026, 10:28:10?p. m.
    Author     : JOSE YOVANY ROJAS M
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Productos | Tienda MVC</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/assets/css/styles.css">
    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/menu.jspf" %>

        <div class="container">

            <h1>Catálogo de Productos</h1>

            <div class="product-grid">

                <c:forEach var="p" items="${productos}">

                    <div class="product-card">

                        <img src="${pageContext.request.contextPath}/assets/img/${p.foto.replace('.svg','.jpg')}"
                             alt="${p.nombre}"
                             class="product-image">

                        <h3>${p.nombre}</h3>

                        <p>${p.descripcion}</p>

                        <p><strong>Precio:</strong> $ ${p.precio}</p>

                        <p><strong>Stock:</strong> ${p.stock}</p>

                        <form action="${pageContext.request.contextPath}/carrito"
                              method="post">

                            <input type="hidden"
                                   name="idProducto"
                                   value="${p.id}">

                            <input type="number"
                                   name="cantidad"
                                   value="1"
                                   min="1"
                                   max="${p.stock}">

                            <button class="btn-primary"
                                    type="submit">

                                Agregar al carrito

                            </button>

                        </form>

                    </div>

                </c:forEach>

            </div>

        </div>

    </body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String usuario
            = (String) session.getAttribute("usuario");

    if (usuario == null) {

        response.sendRedirect("login.jsp");
        return;
    }
%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>


<!doctype html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Inicio | Tienda MVC</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
    </head>

    <body>
        <%@ include file="/WEB-INF/jspf/menu.jspf" %>
        <header class="hero-home">
            <div><span class="eyebrow">Tecnología para todos</span>
                <h1>Compra tecnología, accesorios y productos para tu día a día</h1>
                <p>Descubre productos seleccionados, ofertas especiales y entregas confiables en una tienda
                    construida para comprar sin complicaciones.</p>
                <div class="actions"><a class="btn-primary"
                                        href="${pageContext.request.contextPath}/productos">Explorar catálogo</a><a
                                        class="btn-light" href="#categorias">Ver categorías</a></div>
            </div>
            <div class="hero-visual">
                <div class="orb">⚡</div><strong>Compra inteligente</strong><span>Ofertas, seguridad y
                    garantía</span>
            </div>
        </header>
        <section class="benefits">
            <article><b>🚚 Envíos rápidos</b><span>Despachos seguros a tu ciudad</span></article>
            <article><b>🔒 Pagos seguros</b><span>Opciones confiables de pago</span></article>
            <article><b>💬 Soporte</b><span>Acompañamiento al cliente</span></article>
            <article><b>✓ Garantía</b><span>Productos respaldados</span></article>
        </section>
        <main class="container">
            <section id="categorias" class="section">
                <div class="section-title"><span>Explora</span>
                    <h2>Categorías destacadas</h2>
                </div>
                <div class="category-grid">
                    <c:forEach var="c" items="${categorias}"> <a
                            href="${pageContext.request.contextPath}/productos?categoria=${c.idCategoria}">
                            <div>⌁</div>
                            <h3>${c.nombre}</h3>
                            <p>${c.descripcion}</p>
                        </a></c:forEach>
                    </div>
                </section>
                <section class="section">
                    <div class="section-title"><span>Selección especial</span>
                        <h2>Productos destacados</h2>
                    </div>
                    <div class="product-grid">
                    <c:forEach var="p" items="${destacados}" end="3"> 
                        <%@ include file="/WEB-INF/jspf/product-card.jspf" %>
                    </c:forEach>
                </div>
            </section>
            <section class="promo">
                <div><span>OFERTA DE BIENVENIDA</span>
                    <h2>Envío gratis desde $200.000</h2>
                    <p>Arma tu carrito y recibe tus productos con envío sin costo.</p>
                </div><a class="btn-light" href="${pageContext.request.contextPath}/productos">Comprar
                    ahora</a>
            </section>
            <section class="section">
                <div class="section-title"><span>Recién llegados</span>
                    <h2>Productos nuevos</h2>
                </div>
                <div class="product-grid">
                    <c:forEach var="p" items="${nuevos}" end="3"> 
                        <%@ include file="/WEB-INF/jspf/product-card.jspf" %>
                    </c:forEach>
                </div>
            </section>
            <section class="testimonials">
                <article>
                    <p>“La compra fue rápida y el producto llegó en excelente estado.”</p><strong>Laura
                        Gómez</strong>
                </article>
                <article>
                    <p>“El catálogo es claro y pude revisar mi pedido fácilmente.”</p><strong>Carlos
                        Ramírez</strong>
                </article>
                <article>
                    <p>“Muy buena atención y precios competitivos.”</p><strong>María Torres</strong>
                </article>
            </section>
        </main>
        <%@ include file="/WEB-INF/jspf/footer.jspf" %>
        
        <div style="padding:10px 20px;color:white;">
            Bienvenido: <%= usuario%>
        </div>

    </body>

</html>




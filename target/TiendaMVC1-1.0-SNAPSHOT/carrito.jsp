<%@ page import="java.util.List" %>
<%@ page import="com.tienda.modelo.ItemCarrito" %>

<%
    List<ItemCarrito> carrito
            = (List<ItemCarrito>) session.getAttribute("carrito");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Carrito de Compras</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/assets/css/styles.css">
    </head>
    <body>

        <%@ include file="/WEB-INF/jspf/menu.jspf" %>

        <div class="container">

            <h1>Carrito de Compras</h1>

            <%
                if (carrito == null || carrito.isEmpty()) {
            %>

            <p>No hay productos agregados.</p>

            <%
            } else {

                double total = 0;
            %>

            <table border="1" width="100%">

                <tr>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Subtotal</th>
                </tr>

                <%
                    for (ItemCarrito item : carrito) {

                        total += item.getSubtotal();
                %>

                <tr>

                    <td>
                        <%= item.getProducto().getNombre()%>
                    </td>

                    <td>
                        <%= item.getCantidad()%>
                    </td>

                    <td>
                        $ <%= item.getProducto().getPrecio()%>
                    </td>

                    <td>
                        $ <%= item.getSubtotal()%>
                    </td>

                </tr>

                <%
                    }
                %>

                <tr>

                    <td colspan="3">
                        <strong>Total</strong>
                    </td>

                    <td>
                        <strong>
                            $ <%= total%>
                        </strong>
                    </td>

                </tr>

            </table>

            <%
                }
            %>

            <br>

            <a href="${pageContext.request.contextPath}/productos">
                Seguir comprando
            </a>

            <br><br>

            <form action="${pageContext.request.contextPath}/carrito"
                  method="get">

                <input type="hidden"
                       name="accion"
                       value="vaciar">

                <button type="submit"
                        class="btn-primary">
                    Vaciar carrito
                </button>

            </form>

            <br><br>

            <form action="${pageContext.request.contextPath}/finalizar"
                  method="post">

                <button type="submit"
                        class="btn-primary">
                    Finalizar Compra
                </button>

            </form>


        </div>

    </body>
</html>

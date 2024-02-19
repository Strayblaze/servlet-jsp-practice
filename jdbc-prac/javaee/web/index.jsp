<%@ page import="java.util.List" %>
<%@ page import="kz.alabs.academy.entity.Student" %>
<%@ page import="kz.alabs.academy.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
    <div>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
        %>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">name</th>
                <th scope="col">description</th>
                <th scope="col">expiration_date</th>
                <th scope="col">details</th>
            </tr>
            </thead>
            <%
                for(Product product : products) {
            %>
            <tbody>
            <tr>
                <th scope="row"><%=product.getId()%></th>
                <td><%=product.getName()%></td>
                <td><%=product.getDescription()%></td>
                <td><%=product.getExpiration_date()%></td>
                <td>
                    <a class="btn btn-primary" href="/details?id=<%=product.getId()%>">Details</a>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <form action="/addProduct" method="post">
            <div class="mb-3">
                <label class="form-label">Enter product`s name</label>
                <input class="form-control" placeholder="examples: Milk, Bread, Fanta" name="productName">
            </div>
            <div class="mb-3">
                <label class="form-label">Enter product`s description</label>
                <input class="form-control" placeholder="examples: Sweet drink, contains sugar and water..." name="productDescription">
            </div>
            <div class="mb-3">
                <label class="form-label">Enter product`s expiry date</label>
                <input type="date" class="form-control" placeholder="" name="productExpirationDate">
            </div>
            <button class="btn btn-primary">Add Product</button>
        </form>
<%--        <form action="students" method="get">--%>
<%--&lt;%&ndash;        <label for="fullName">Full Name:</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <input type="text" id="fullName" name="fullName" required><br><br>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <label for="score">Exam evaluation:</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <input type="number" id="score" name="eval" required><br><br>&ndash;%&gt;--%>

<%--        <input type="submit" value="Submit">--%>
<%--        </form>--%>

    </div>
</body>
</html>

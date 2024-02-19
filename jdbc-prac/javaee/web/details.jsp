<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="kz.alabs.academy.entity.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <%
        Product product = (Product) request.getAttribute("product");
    %>
    <h1 class="mt-5">Product Details</h1>
    <div class="row mt-3">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title">Product Information</h5>
                </div>
                <div class="card-body">
<%--                    <p><strong>Name:</strong> <%=product.getName()%></p>--%>
<%--                    <p><strong>Description:</strong> <%=product.getDescription()%></p>--%>
<%--                    <p><strong>Expiration Date:</strong> <%=product.getExpiration_date()%></p>--%>
                    <form>
                        <input type="hidden" value="<%=product.getId()%>" name="productId">
                        <div class="mb-3">
                            <label class="form-label">Name: </label>
                            <input class="form-control" placeholder="<%= product.getName()%>" name="productName" readonly>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Description: </label>
                            <input class="form-control" placeholder="<%=product.getDescription()%>" name="productDescription" readonly>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Expiry date: </label>
                            <input type="date" class="form-control" value="<%=product.getExpiration_date()%>" name="productExpirationDate" readonly>
                        </div>
                    </form>
                    <button type="button" data-bs-toggle="modal" data-bs-target="#updateProduct">
                            Edit Product
                    </button>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteProduct">
                        Delete Product
                    </button>

                    <!-- Modal -->
                    <form action="/deleteProduct" method="post" class="form-control">
                        <div class="modal fade" id="deleteProduct" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="deleteProduct" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Delete Product</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" value="<%=product.getId()%>" name="productId">
                                        <h2>
                                            Are you sure you want to delete this product? Action is irreversible.
                                        </h2>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- updateModal -->
                    <div class="modal fade" id="updateProduct" tabindex="-1" aria-labelledby="updateProduct" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="/updateProduct" method="post">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Update Product</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                            <input type="hidden" value="<%=product.getId()%>" name="productId">
                                            <div class="mb-3">
                                                <label class="form-label">Name: </label>
                                                <input class="form-control" value="<%= product.getName()%>" name="productName">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Description: </label>
                                                <input class="form-control" value="<%=product.getDescription()%>" name="productDescription">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Expiry date: </label>
                                                <input type="date" class="form-control" value="<%=product.getExpiration_date()%>" name="productExpirationDate">
                                            </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
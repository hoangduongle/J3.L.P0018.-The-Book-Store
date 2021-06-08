

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>History <b>Order</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="MainController?action=home" class="btn btn-success" data-toggle="modal"><span>Back to Home</span></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Date</th>
                            <th>Total Price</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.HISTORY}" varStatus="counter" var="h">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${h.getDateOrder()}</td>
                                <td>${h.getTotal()}$</td>
                                <td>
                                    <a href="MainController?action=MoreDetail&OrderID=${h.getOrderID()}"  class="btn btn-success" data-toggle="modal"><span>More</span></a>	
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Edit Modal HTML -->
        <div id="seeMore" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="MainController" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">List Book in Order</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                ${param.total}
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" type="text" placeholder="Link image" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <input name="quantity" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Author</label>
                                <input name="author" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${sessionScope.listc}" var="c">
                                        <option value="${c.getCategoryID()}">${c.getCategoryName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>              
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>
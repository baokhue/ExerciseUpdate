<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 5/22/2023
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>


    <title>Ứng dụng bán hàng trực tuyến</title>
    <style>
        .popup {
            position: fixed;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            background: rgba(0, 0, 0, 0.6);
            display: none;
        }

        #xmas-popup-edit .popup-content {
            width: 400px;
            height: 200px;
            background: #bbb;
            margin: 100px auto;
            position: relative;
            border: 5px solid #fff;
        }

        #xmas-popup-Add .popup-content {
            width: 400px;
            height: 200px;
            background: #bbb;
            margin: 100px auto;
            position: relative;
            border: 5px solid #fff;
        }

        #xmas-popup-delete .popup-content {
            width: 400px;
            height: 200px;
            background: #bbb;
            margin: 100px auto;
            position: relative;
            border: 5px solid #fff;
        }

        #popup-delete .popup-content {
            width: 400px;
            height: 200px;
            background: #bbb;
            margin: 100px auto;
            position: relative;
            border: 5px solid #fff;
        }


        .close {
            position: absolute;
            top: 5px;
            right: 5px;
            border-radius: 50%;
            background: #222;
            border: 3px solid #fff;
            color: #fff;
            text-decoration: none;
            line-height: 0;
            padding: 9px 0 11px;
            width: 20px;
            text-align: center;
        }

        .popup:target {
            display: block;
        }

        .btn-primary {
            margin-left: 10px;
        }


    </style>
</head>
<body>
<div class="container">
    <header>
        <h1>Ứng dụng bán hàng trực tuyến</h1>
        <nav id="nav_menu">
            <form method="get">
                <table>
                    <tr>
                        <td><a href="/ProductServlet?action=null"><input type="button" value="Product"></a></td>
                        <td><a href="/CustomerServlet?action=null"><input type="button" value="Customer"></a></td>
                    </tr>
                </table>
            </form>
        </nav>
        <form action="/ProductServlet?action=showById" method="post">
            <h2><label for="inputShowById">Find By id</label><br></h2>
            <input type="number" id="inputShowById" name="showById" style="width: 400px; height: 30px;"
                   placeholder="Enter the id you want to search for">
            <label><input type="submit" value="Show" style="height: 30px"></label>
        </form>
    </header>
    <main id="main_product">

        <table>
                <tr>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myUpdateModal">
                        Edit
                    </button>

                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myDeleteModal">
                        Delete
                    </button>

                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myAddModal">Add
                    </button>
                </tr>
                <tr>
                    <th>Mã sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá sản phẩm</th>
                    <th>Số lượng</th>
                </tr>
                <c:forEach var="list" items="${productList}">
                    <tr>
                        <td>${list.id}</td>
                        <td>${list.name}</td>
                        <td>${list.price}</td>
                        <td>${list.amount}</td>
                    </tr>
                </c:forEach>



        </table>
        <div class="modal fade" id="myUpdateModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Update</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <form action="/ProductServlet" method="post">
                        <!-- Modal body -->
                        <div class="modal-body">

                            <label for="idUpdate">id</label>
                            <input type="number" class="form-control" name="idUpdate" id="idUpdate">
<c:forEach var="list" items="${productList}">
    <label for="nameUpdate">Name:${list.name}</label>
</c:forEach>

                            <label for="nameUpdate">Name:</label>
                            <input type="text" class="form-control" name="nameUpdate" id="nameUpdate">


                            <label for="priceUpdate">Price:</label>
                            <input type="number" class="form-control" name="priceUpdate" id="priceUpdate">

                            <label for="amountUpdate">Amount: </label>
                            <input type="text" class="form-control" name="amountUpdate" id="amountUpdate">
                        </div>
                        <!-- Pop-Up -->
                        <div id="xmas-popup-edit" class="popup" href="#">
                            <div class="popup-content">
                                <table>
                                    <tr>You definitely want to edit the object</tr>
                                    <tr>
                                        <td>
                                            <a href="/ProductServlet" class="btn btn-primary">Close </a>
                                        </td>
                                        <td>
                                            <input type="submit" class="btn btn-primary" value="Edit" name="action">
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </form>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <a href="#xmas-popup-edit" class="btn btn-primary">Edit</a>
                    </div>
                </div>
            </div>
        </div>


        <div class="modal fade" id="myDeleteModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Update</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <form action="/ProductServlet" method="post">
                        <!-- Modal body -->
                        <div class="modal-body">

                            <label for="idDelete">id</label>
                            <input type="number" class="form-control" name="idDelete" id="idDelete">


                        </div>
                        <!-- Pop-Up -->
                        <div id="xmas-popup-delete" class="popup" href="#">
                            <div class="popup-content">
                                <table>
                                    <tr>You definitely want to edit the object</tr>
                                    <tr>
                                        <td>
                                            <a href="/ProductServlet" class="btn btn-primary">Close </a>
                                        </td>
                                        <td>
                                            <input type="submit" class="btn btn-primary" value="Delete" name="action">
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </form>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <a href="#xmas-popup-delete" class="btn btn-primary">Delete</a>
                    </div>
                </div>
            </div>
        </div>


        <div class="modal fade" id="myAddModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Add</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <form action="/ProductServlet" method="post">
                        <!-- Modal body -->
                        <div class="modal-body">

                            <label for="idAdd">id</label>
                            <input type="number" class="form-control" name="idAdd" id="idAdd">

                            <label for="nameAdd">Name:</label>
                            <input type="text" class="form-control" name="nameAdd" id="nameAdd">

                            <label for="priceAdd">Price:</label>
                            <input type="number" class="form-control" name="priceAdd" id="priceAdd">

                            <label for="amountAdd">amount:</label>
                            <input type="text" class="form-control" name="amountAdd" id="amountAdd">
                        </div>
                        <!-- Pop-Up -->
                        <div id="xmas-popup-Add" class="popup" href="#">
                            <div class="popup-content">
                                <table>
                                    <tr>You definitely want to Add the object</tr>
                                    <tr>
                                        <td>
                                            <a href="/ProductServlet" class="btn btn-primary">Close </a>
                                        </td>
                                        <td>
                                            <input type="submit" class="btn btn-primary" value="Add" name="action">
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </form>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <a href="#xmas-popup-Add" class="btn btn-primary">Add</a>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!--Modal ADD -->
    <!--Modal edit  -->


</div>
</body>
</html>


<%-- 
    Document   : newjsp
    Created on : May 10, 2021, 7:11:18 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Book Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/css.css">
        <meta name="google-signin-scope" content="profile email">
        <meta name="google-signin-client_id" content="542273842720-sjjmduo4sf62gs9h2uj565ml101sg7v5.apps.googleusercontent.com">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <c:if test="${not empty requestScope.OUT}">
            <script>
                swal("${requestScope.OUT}", "You clicked the button!", "success");
            </script>
        </c:if>
        <div class="wrapper">
            <div class="form">
                <div class="title">
                    Login To Buy a Book
                </div>
                <form method="post" action="MainController">
                    <div class="input_wrap">
                        <label for="input_text">Username</label>
                        <div class="input_field">
                            <input type="text" name="username" class="input" id="input_text">
                        </div>
                    </div>
                    <div class="input_wrap">
                        <label for="input_password">Password</label>
                        <div class="input_field">
                            <input type="password" name="password" class="input" id="input_password">
                        </div>
                    </div>
                    <c:if test="${requestScope.MESS !=null}">
                        <p>Incorrect username or password. Please try again
                        </c:if>
                    <div class="input_wrap">
                        <input type="submit" name="action" id="login_btn" class="btn disabled" value="Login" disabled="true">
                    </div>
                </form>
                <form action="MainController" method="POST" style="display: none" >
                    <input type="hidden" name="name" id="name" value="">
                    <input type="hidden" name="email" id="email" value="">
                    <input type="hidden" name="id" id="id" value="">
                    <input type="submit" name="action" id="ggButton" value="Login With Google">
                </form>
                
                
            </div>
        </div>
    </body>
    <script>
        var input_fields = document.querySelectorAll(".input");
        var login_btn = document.querySelector("#login_btn");

        input_fields.forEach(function (input_item) {
            input_item.addEventListener("input", function () {
                if (input_item.value.length > 3) {
                    login_btn.disabled = false;
                    login_btn.className = "btn enabled"
                }
            })
        });

        function nonAccentVietnamese(str) {
            str = str.toLowerCase();
            str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
            str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
            str = str.replace(/ì|í|ị|ỉ|ĩ/g, "i");
            str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
            str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
            str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
            str = str.replace(/đ/g, "d");
            // Some system encode vietnamese combining accent as individual utf-8 characters
            str = str.replace(/\u0300|\u0301|\u0303|\u0309|\u0323/g, ""); // Huyền sắc hỏi ngã nặng 
            str = str.replace(/\u02C6|\u0306|\u031B/g, ""); // Â, Ê, Ă, Ơ, Ư
            return str;
        }
    </script>


</html>


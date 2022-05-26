<%-- 
    Document   : HomePage
    Created on : May 26, 2022, 10:40:13 PM
    Author     : Thanh Duy
--%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix= "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title> IsolatedMS </title>
        <%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta name ="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- CSS File -->
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/base/reset.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/bootstrap/js/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/base/base.css">        
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/base/header.css">
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/base/header2.css">
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/base/toast.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js" integrity="sha512-yFjZbTYRCJodnuyGlsKamNE/LlEaEAxSUDe5+u61mV8zzqJVFOH7TnULE2/PP/l5vKWpUNnF4VGVkXh3MjgLsg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>       

    </head>
    <body>
        <header>
            <div class="header_one">
                <span id='header_one-name'>Hệ thống quản lý khu cách ly Covid-19</span>
                <ul class='user'>
                    <li><a href=""><i class="far fa-bell"></i>
                            <span>Thông báo</span></a>
                    </li>
                    <li><a href=""><i class="far fa-question-circle"></i>
                            <span>Trợ giúp</span></a>
                    </li>
                   
                    <li><a href="">Đăng nhập</a></li>
                    <li><a href="">Đăng ký</a></li>
                </ul>
            </div>
            <br/>
            <div class='header_two row'>
                <div class="logo col-3">
                   
                </div>
                <li><div class="user-heading">
                        <img id="avatar-login">
                        <span></span>
                        <div class="user-info">
                            <ul class="user-info__list">
                                <li class="user-info__item"><a href="">Tài khoản của tôi</a></li>
                                <li class="user-info__item"><a href="">Đơn của tôi</a></li> 
                            </ul>
                        </div>
                    </div>                   
                </li>
                </ul>
            </div>
            <br/>
            <div class='header_two row'>
                <div class="logo col-3">
                    <a href="/home"><img src="assets/img/logo.png"></a>
                </div>

                <div class='search col-7'>
                    <form action ="" method="POST">
                        <input type="text" class="search__text" placeholder="Nhập để tìm kiếm" id="key" name="key">
                        <button type="SUBMIT"><i class="fas fa-search"></i></button>
                    </form>
                </div>
            </div>
        </header>
    </body>
</html>

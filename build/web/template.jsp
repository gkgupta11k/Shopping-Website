<%-- 
    Document   : template
    Created on : Oct 23, 2019, 12:47:31 AM
    Author     : gauravkgupta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="Template.css" />
    </head>
    <body>
        <header>
            <%@include file="/Logo.html" %>
        </header>
        <nav>
            <%@include file="/Navbar.html" %>
        </nav>
      
        <article>
            <h1>  Welcome to FoodMart </h1> <img src="FrontImage.jpg"  width="700" height="400"/>
        </article>  

    </body>
</html>

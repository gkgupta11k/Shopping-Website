<%-- 
    Document   : ItemDetail
    Created on : Oct 24, 2019, 2:18:50 AM
    Author     : gauravkgupta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title> 
                <link rel="stylesheet" type="text/css" href="Template.css" />
    </head>
    <body    background="View3.jpg">
  <header>
            <%@include file="/Logo.html" %>
        </header>
        <nav>
            <%@include file="/Navbar.html" %>
        </nav>
        <article>
        <b> ${currentitem.itemcode} ${currentitem.itemnumber} ${currentitem.itemname}: ${currentitem.itemprice}</b></br>
                       
        <br/>
        <c:choose>
            <c:when   test="${itemname.Rice}">
          This is NON Organic Food. 
            </c:when>    
            <c:otherwise>
             
USDA Organic, Gluten Free, Vegan, Kosher, Non GMO Project Verified
            </c:otherwise>
        </c:choose>  
                        
        
        </article> 
    </body>
</html>

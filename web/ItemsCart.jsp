<%-- 
    Document   : ItemsCart
    Created on : Oct 24, 2019, 1:24:48 PM
    Author     : gauravkgupta
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Template.css" />
        <title>JSP Page</title>
         
    </head>
    <body  background="View3.jpg">
        <header>
            <%@include file="/Logo.html" %>
        </header>
        <nav>
            <%@include file="/Navbar.html" %>
        </nav>

        
        <table border="2">
            <c:choose>
                <c:when test="${empty itemlist or itemlist.size == 0}">
                    <h1>  No Items added yet    </h1>
                </c:when>
            <c:otherwise>
                <th> Current Items </th>      <th> Name </th> <th> Price </th>    <th> Code </th>
         
         
            <c:forEach var="item" items="${itemlist.items}">
                  <tr>
            <td>   ${item.itemnumber}  </td> <td> ${item.itemname} </td> <td>${item.itemprice} </td> <td>${item.itemcode} </td>
         
                 
            <td> 
                        <form action="DropServlet">
                            <input type="submit" value="Delete Item"/>                        
                            <input type="hidden" name="number" 
                                   value="${item.itemnumber}"/>
                            <input type="hidden" name="name" 
                                   value="${item.itemname}"/> 
                             <input type="hidden" name="price" 
                                   value="${item.itemprice}"/>
                              <input type="hidden" name="code" 
                                   value="${item.itemcode}"/>
                        </form>
            </td>
            </c:forEach>
                  <tr> <td>  Total Items: ${itemlist.number} </td> <td> Total Price:  ${itemlist.price}  </td> </tr> 
         
            </c:otherwise>
            </c:choose>
        </table>
     
 
    </body>
</html>

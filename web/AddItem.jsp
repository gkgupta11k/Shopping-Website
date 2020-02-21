<%-- 
    Document   : AddItem
    Created on : Oct 24, 2019, 1:26:54 PM
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
    <body      background="View3.jpg">  
          <header>
            <%@include file="/Logo.html" %>
        </header>
        <nav>
            <%@include file="/Navbar.html" %>
        </nav> <table border="2">
                <th>Item Number</th>   <th>Item Name</th>  <th> Item Price </th>  <th> Item Code </th>
    <c:forEach var="item"   items="${itemarray.items}"  > 
        <tr>
            <td>   ${item.itemnumber}  </td> <td> ${item.itemname} </td> <td>${item.itemprice} </td> <td> ${item.itemcode} </td>
         <td>
                        <form action="AddServlet">
                            <input type="submit" value="Add to cart"/>                        
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
        </tr>      </table>
       
    </body>
</html>

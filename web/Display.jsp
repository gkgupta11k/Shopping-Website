
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="Template.css" />
        <title>JSP Page</title>
    </head>
    <body   background="View3.jpg">
        
        <header>
            <%@include file="/Logo.html" %>
        </header>
        <nav>
            <%@include file="/Navbar.html" %>
        </nav>
        
        <h2>  <table border="2">
                <th>Item Number</th>   <th>Item Name</th>  <th> Item Price </th> <th> Item Code </th>
    <c:forEach var="item"   items="${itemarray.items}"  > 
        <tr>
            <td>   ${item.itemnumber}  </td> <td> ${item.itemname} </td> <td>${item.itemprice} </td> <td>${item.itemcode} </td>
         <td>
                        <form action="DetailServlet">
                            <input type="submit" value="Details"/>                        
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
        </tr>      </table> </h2> 
    
    </body>
</html>

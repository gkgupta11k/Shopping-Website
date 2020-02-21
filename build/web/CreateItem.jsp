


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Template.css" />
        <title>JSP Page</title>
    </head>
    
    <body  background="MainImage.jpg" >
               <header>
            <%@include file="/Logo.html" %>
        </header>
        <nav>
            <%@include file="/Navbar.html" %>
        </nav>
        
         <article>
        <form action="ValidateItemServlet" > 
        Item Code: 
        <select name="code" >
            <option value="choose">choose</option>
            <c:forEach var="code" items="${itemarray.codes}">
                <option value=${code} 
                        <c:if test="${param.code == code}">
                            selected="true"
                        </c:if>
                    >
                    ${code}
                </option>
            </c:forEach>
        </select>
        <c:if test="${errors.codemissing}">
            Must select a Code Items!
        </c:if>
            
        <br/>
        Item number: <input type="text" name="number"
                              value="${param.number}"/>  
        <c:if test="${errors.numbermissing}">
            Must give a Item number!
        </c:if>
        <c:if test="${errors.numberilleagal}">
            Item number must be 2 digits and start with 1, 2, 3, 4, 5, or 6
        </c:if>
        <br/>
        Item name: <input type="text" name="name"
                            value="${param.name}"/>
        <c:if test="${errors.namemissing}">
            Must give a Item name!
        </c:if>
        
             <br/>
        Item Price: <input type="text" name="price"
                            value="${param.price}"/>
        <c:if test="${errors.pricemissing}">
            Must give a Item price !
        </c:if>
             
            <c:if test="${errors.priceless}">
           Price can't be negative !
        </c:if>
            <c:if test="${errors.priceNotNumeric}">
         Price Invalid  !
        </c:if>
        <br/>
        
        <input type="submit" value="CREATE ITEM"/>
        </form> 
        </article> 
        
      </body>      
         
</html>

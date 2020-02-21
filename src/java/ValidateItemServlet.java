/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gauravkgupta
 */
public class ValidateItemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession();
        String nextPage = "/DetailServlet";
             // Get the name, number, and price form the request
        String number = request.getParameter("number"); 
        String name = request.getParameter("name");
       //double price = Double.parseDouble(request.getParameter("price"));
         String code = request.getParameter("code");    
       String price = request.getParameter("price");

        
         // Create a new object for all of the error messages we might need
        // to send back to the JSP
 ItemErrorList errors = new ItemErrorList();
        
        // Call each of the validaton methods, keepin track of what they return
        // so we know if anything  went wrong. Pass the CourseErrorList to each
        // so it can be modified if an error is found by that method.
        
       boolean isNumberValid = itemValidation.validateNumber(number, errors);
       boolean isNameValid = itemValidation.validateName(name, errors);
         boolean isPriceValid = itemValidation.validatePrice(price, errors); 
        boolean isCodeValid = itemValidation.validateCode(code, errors);
                
       // ItemArray allitems = (ItemArray)session.getAttribute("itemarray");
       //boolean isItemUnique = ItemValidation.validateItemUnique(allitems, number,  code);
            
  
       
         // If no errors wer found, create the course.
        // Otherwise, redirect back to the input page.
       if ( isNumberValid && isNameValid && isPriceValid && isCodeValid ) {
            ItemList items = (ItemList)session.getAttribute("itemlist");
            if (items == null) {   
                items = new ItemList();
            } 
          items.add( number, name ,price, code);  
         session.setAttribute("currentitem", items.getItem(number, code));
          session.setAttribute("itemlist", items);
            
       }
       else {            
            nextPage = "/CreateItem.jsp";
            
            //Add the validation object to the session for use by the JSP
           request.setAttribute("errors", errors);
      }
        
         getServletContext().getRequestDispatcher(nextPage).forward(request, response);
        
           
     
    }  }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }

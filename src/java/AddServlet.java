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
public class AddServlet extends HttpServlet {

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
     // Get the ItemList "cart" of item from the session
      HttpSession session = request.getSession();
      ItemList items = (ItemList)session.getAttribute("itemlist");
       // If the user has not yet added items, it will be null initially,
        // so construct a new ArrayList cart in that case. 
      if (items == null){
          items = new ItemList();
          
      }
      
      
           // Get the name, number, and price form the request
        String number = request.getParameter("number");
        String name = request.getParameter("name");
            String code  = request.getParameter("code");
        double price = Double.parseDouble(request.getParameter("price"));
        
              // Look them up in the array of all items stored in  the session 
       ItemArray allitems = (ItemArray)session.getAttribute("itemarray"); 
       Item item = allitems.getItem(number, name, price, code);
    
        // Determine the total price of the user’s books
  
     // Add the new item to the cart, and store the modified cart back in the session.
       items.add(item);
        session.setAttribute("itemlist",items);  
         getServletContext().
                getRequestDispatcher("/ItemsCart.jsp").
                        forward(request, response);
    }
 
    }
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


/* This class is for itemlist */

import java.util.ArrayList;
import java.util.*;
import java.sql.*;

public class ItemList {
    
 
    
  // Internally, a ItemList is an array list of Item objects
    
    private ArrayList <Item> items; 
 
    
    public ItemList(){
        items = new ArrayList();
    }
     // Return the list of items for iteration in a view 
    
   public ArrayList getItems(){
       return items;
   } 
   
   // Get the existing courses from the database and add them to the list
    public void loadItems() {
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Items", "app", "app");
        }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");  
        }
        
        try {
            // Create and execute query statement for all in item table,
            // storing links to matching records in ResultSet object results.
            statement = connection.createStatement();
            results = statement.executeQuery("select * from Foods");
            
            // Loop to next record in results, while there is a next record.
            while (results.next()) {
                
                // Get each field of current record (as appropriate type)
                String itemnumber = results.getString("itemnumber");
                String itemcode = results.getString("itemcode");
                String itemname = results.getString("itemname");
                Double itemprice = results.getDouble("itemprice");
              
                
   
// Construct a new item object from that data, and add to list
                Item c = new Item(itemnumber, itemname, itemcode, itemprice); 
                items.add(c);
            }
        }        
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
    }
     // Save new item to database
    public static void saveItem(String code, String number, 
            String name, String price) {
        
        
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Items", "app", "app");
            }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");
        }
        
        try {
            
            // Create a "template" for the SQL insert statement, with ?
            // in place of the values we will actually insert
            String template = "insert into Foods "
                    + "(itemcode, itemnumber, itemname, itemprice)"
                    + "values (?, ?, ?, ?)";
            
            // Pass this template to the database server via the connection
            statement = connection.prepareStatement(template);
            
            // Replace the question marks with the actual values
            statement.setString(1, code);
            statement.setString(2, number);
            statement.setString(3, name);
            statement.setDouble(4, Double.parseDouble(price));
           
         
            
            // Exectue the final SQL statement on the database.
            statement.executeUpdate();
        }      
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
        
    }
    // Construct a new Item, object directly from parameters read in from the form.
    // This requires converting price to integers and the project
   
    public void add(String code, String number, String name, String price) {
        Item c = new Item( number, name, Double.parseDouble(price), code );
        items.add(c);
    }
     
           
   public void add(Item c){
       items.add(c);

}



public double getPrice()
 {
     double total = 0.0;
     for(int i = 0; i < items.size(); i++)
     {
         total += items.get(i).getItemprice();
     }
     return total;
 }
  
   public int getNumber(){
       return items.size();
   }


   public int getSize(){
       return items.size();
   }
    // Search the list for the item withthe given number, name, price
    // and return  that Item object.  
     public Item getItem(String number, String code) {
        for (int i = 0; i < items.size(); i++) {
            Item c = items.get(i);
            if (number.equals(c.getItemnumber()) &&
                    code.equals(c.getItemcode())) {
                return c;
            }
        }
        return null;
  
     }
      // Remove item with given number, name, and price from list,
    // using search method to find it first
     public void drop(String number,  String Code){
         Item c = getItem( number,  Code);
         items.remove(c);
     }

  public final String[] CODES = new String []{"A14", "A15", "A16"};
    public String[] getCodes() {
        return CODES;
    }
  



}

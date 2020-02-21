    import java.sql.*;
    
public class AddItems {
    

    public static void main(String[] args) {
        
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
            
            // Define a simple insert SQL statement
            String insert = "insert into Foods "+
                       "( itemnumber, itemname, itemprice, itemcode)"+
                       "values ('14','Lemon', 5.0, 'A19')";
            
            // Construct a statement object from the connection
            statement = connection.createStatement();
            
            // Exceute the insert statement
            statement.executeUpdate(insert);
            
        }      
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
        
    }
    
}
    


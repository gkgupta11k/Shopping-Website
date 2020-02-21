
public class itemValidation {
    
       // Has the user selected a number from the list?
    // If the numbere has no value, or is still "choose", then they haven't
     public static boolean validateCode(String code, 
                                         ItemErrorList errors) {
        if (code == null || code.equals("choose")) {
            errors.setCodemissing(true);
            return false;
        }
       
        else {
            return true;
        }
    }
    public static boolean validatePrice(String price,  ItemErrorList errors) {
        price = price.trim();
        
        
        // We first compare the trimmed values to the empty string, and create
        // an hoursMissing error if either is empty.
        if ("".equals(price) ) {
            errors.setPricemissing(true);
            return false;
        }
        else {
            
            // Otherwise, we attempt to parse the values to integers.
            try {
                  double Tprice = Double.parseDouble(price); 
                
                // If the values are integers, first make sure they are positive
                // (can't have negative hours).
                if (Tprice < 0) {
                    errors.setPriceless(true);
                    return false;
                }
                
                // Otherwise,  make sure that the minimum hours is not greater
                // than the maximum hours.
             
            }
            
            // If a NumberFormatException error occurs, the user has put non-integer
            // values into one of the fields, so create an hoursNotNumerc error.
            catch (NumberFormatException ex) {
                errors.setPriceNotNumeric(true);
                return false;
            }
        } 
        return true;
    }
    
     
     
    
    
 // Has the user enterd a item name? 
    // We compare the trimmed value with the empty string.
    public static boolean validateName(String name, 
                                       ItemErrorList errors) {
        if ("".equals(name.trim())) {
            errors.setNamemissing(true);
            return false;
        }
    
        else {
            return true;
        }
    }
    // Has the user entered legal values for the  minimum and maximum number of
    // course hours?
   
    
 
// Did the user enter a ourse number? If so,
    // has the user entered a couse number in  legal format?
    public static boolean validateNumber(String number , ItemErrorList errors) {        
        // Check whether any name given
        if ("".equals(number.trim())) {
            errors.setNumbermissing(true);
            return false;
        }        
        // We compare the string to a regular expression which 
        // specifies the value must be 4 digits starting with 15, 26, 37, 48, 58, or 69.
        String numRegEx = "((1)|(2)|(3)|(4)|(5)|(6))\\d";
        number = number.trim();
        if (!number.matches(numRegEx)) {
            errors.setNumberilleagal(true);
            return false;  
            }
        else {
            return true;
        }      
    }
}
    
    
   

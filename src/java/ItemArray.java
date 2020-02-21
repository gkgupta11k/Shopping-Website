/* this class for array of shopping items */ 

public class ItemArray {  
    
    Item [] items;
    
    
    public ItemArray(){
        items = new Item[3];
        items[0]= new Item("1.", "Rice", 60.0,"A11");
        items[1]= new Item("2.", "Egg", 5.0,"A12"); 
        items[2]= new Item("3.", "Sprite", 2.0,"A13");

                
                }    
    public Item []  getItems(){
    return items;
}
  public final String[] CODES = new String []{"A14", "A15", "A16"};
    public String[] getCodes() {
        return CODES;
    }
    
     public Item getItem(String number,String name, double price,String code) {
        for (int i = 0; i < items.length; i++) {
            Item c = items[i];
            if (number.equals(c.getItemnumber()) &&
                    name.equals(c.getItemname()) &&
                     price == (c.getItemprice()) &&
                    code.equals(c.getItemcode()))      {
                return c;
            }
        }
        return null;
  
   
}

 

 
 
}

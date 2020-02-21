/* Method class for the shopping website  */ 

public class Item {
    
    
    private String itemnumber= " ";
    private String itemname = " ";
    private Double itemprice = 0.0;
    private String itemcode= " ";

    Item(String itemnumber, String itemname, String itemcode, Double itemprice) {
       
    }




    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }
      


 
    
     Item( String itemnumber,String itemname, Double itemprice, String itemcode) {
         this.itemnumber = itemnumber;
         this.itemname = itemname;
         this.itemprice = itemprice;
         this.itemcode = itemcode;
     
      
    }

    Item() {
    }

  


    public String getItemnumber() {
        return itemnumber;
    }

    public String getItemname() {
        return itemname;
    }

 

    public Double getItemprice() {
        return itemprice;
    }

  
    public void setItemnumber(String itemnumber) {
        this.itemnumber = itemnumber;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setItemprice(Double itemprice) {
        this.itemprice = itemprice;
    }

}

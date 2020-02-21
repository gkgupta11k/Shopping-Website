public class ItemErrorList {
    
    private boolean numbermissing= false;
    private boolean namemissing= false;
    private boolean pricemissing = false;
    private boolean numberilleagal = false;
     private boolean codeillegal = false;
     private boolean codemissing = false;    
      private boolean priceNotNumeric = false;  
      private boolean priceless = false; 
       private boolean itemAlreadyExists = false;

    public boolean isPriceless() {
        return priceless;
    }

    public void setPriceless(boolean priceless) {
        this.priceless = priceless;
    }

    public boolean isPriceNotNumeric() {
        return priceNotNumeric;
    }

    public void setPriceNotNumeric(boolean priceNotNumeric) {
        this.priceNotNumeric = priceNotNumeric;
    }

    public boolean isPriceillegal() {
        return priceillegal;
    }

    public void setPriceillegal(boolean priceillegal) {
        this.priceillegal = priceillegal;
    }
     private boolean priceillegal = false; 

    public boolean isCodemissing() {
        return codemissing;
    }

    public void setCodemissing(boolean codemissing) {
        this.codemissing = codemissing;
    }

    public boolean isNumberilleagal() {
        return numberilleagal; 
    }

    public boolean isCodeillegal() {
        return codeillegal;
    }

    public void setCodeillegal(boolean codeillegal) {
        this.codeillegal = codeillegal;
    }

    public void setNumberilleagal(boolean numberilleagal) {
        this.numberilleagal = numberilleagal;
    }
    
    
    

    public boolean isNumbermissing() {
        return numbermissing;
    }

    public void setNumbermissing(boolean numbermissing) {
        this.numbermissing = numbermissing;
    }

    public boolean isNamemissing() {
        return namemissing;
    }

    public void setNamemissing(boolean namemissing) {
        this.namemissing = namemissing;
    }

    public boolean isPricemissing() {
        return pricemissing;
    }

    public void setPricemissing(boolean pricemissing) {
        this.pricemissing = pricemissing;
    }

    public boolean isItemAlreadyExists() {
        return itemAlreadyExists;
    }

    public void setItemAlreadyExists(boolean itemAlreadyExists) {
        this.itemAlreadyExists = itemAlreadyExists;
    }



 
   
}


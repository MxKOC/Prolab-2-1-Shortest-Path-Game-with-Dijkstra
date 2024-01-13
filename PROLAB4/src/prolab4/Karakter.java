
package prolab4;

import java.util.ArrayList;



public  class Karakter {
    
    private String Karakter;
    private int ID;
    private String Türü;
    
    private int x,y;

    
    public Karakter() {
    	
    }
    
    public Karakter(String Karakter, int ID, String Türü, int x, int y) {
        this.Karakter = Karakter;
        this.ID = ID;
        this.Türü = Türü;
        this.x = x;
        this.y = y;
    }

    public String getKarakter() {
        return Karakter;
    }

    public void setKarakter(String Karakter) {
        this.Karakter = Karakter;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTürü() {
        return Türü;
    }

    public void setTürü(String Türü) {
        this.Türü = Türü;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    public void EnKısaYol(){};
    
    
    
}






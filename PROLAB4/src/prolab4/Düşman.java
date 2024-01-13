
package prolab4;

public class Düşman  extends Karakter{
    
    private int dusmanID;
    private String dusmanAdi;
    private String dusmanTür;
    private int hasar;

    public Düşman() {
    	
    }
    
    public Düşman(int dusmanID, String dusmanAdi, String dusmanTür, int x, int y) {
        super(dusmanAdi, dusmanID, dusmanTür, x, y);
        this.dusmanID = dusmanID;
        this.dusmanAdi = dusmanAdi;
        this.dusmanTür = dusmanTür;
    }

    public int getDusmanID() {
        return dusmanID;
    }

    public void setDusmanID(int dusmanID) {
        this.dusmanID = dusmanID;
    }

    public String getDusmanAdi() {
        return dusmanAdi;
    }

    public void setDusmanAdi(String dusmanAdi) {
        this.dusmanAdi = dusmanAdi;
    }

    public String getDusmanTür() {
        return dusmanTür;
    }

    public void setDusmanTür(String dusmanTür) {
        this.dusmanTür = dusmanTür;
    }

    public int getHasar() {
        return hasar;
    }

    public void setHasar(int hasar) {
        this.hasar = hasar;
    }

    
    
}

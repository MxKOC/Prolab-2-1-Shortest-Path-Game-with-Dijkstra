
package prolab4;

public abstract class Oyuncu extends Karakter{
    
    
    private int oyuncuID;
    private String oyuncuAdi;
    private String oyuncuTur;
    private int Skor=20;
    private int hiz;
    
    public Oyuncu() {
    	
    }

    public Oyuncu(String Karakter, int ID, String Türü, int x, int y) {
        super(Karakter, ID, Türü, x, y);
        oyuncuID = ID;
        oyuncuAdi = Karakter;
        oyuncuTur = Türü;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public String getOyuncuTur() {
        return oyuncuTur;
    }

    public void setOyuncuTur(String oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }

    public int getSkor() {
        return Skor;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    }
    
    public int getHiz() {
		return hiz;
	}

	public void setHiz(int hiz) {
		this.hiz = hiz;
	}

	public abstract void PuaniGoster();

    
    
    
}

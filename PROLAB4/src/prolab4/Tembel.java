
package prolab4;

public class Tembel  extends Oyuncu{
    
	private int hiz=1;
	
    public Tembel() {
    	super();
    }

    public Tembel(String Karakter,int ID,String Tür,int x,int y) {
    	super(Karakter,ID,Tür,x,y);
    }
    
    
    

	public int getHiz() {
		return hiz;
	}

	public void setHiz(int hiz) {
		this.hiz = hiz;
	}

    @Override
    public void PuaniGoster() {
                
            System.out.println("Skor= "+this.getSkor());
    }
    
    
    
}

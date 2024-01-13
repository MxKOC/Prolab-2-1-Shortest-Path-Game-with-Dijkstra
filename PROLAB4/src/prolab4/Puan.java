
package prolab4;

public class Puan  extends Oyuncu{

	public Puan(String Karakter, int ID, String Türü, int x, int y) {
		super(Karakter, ID, Türü, x, y);
		// TODO Auto-generated constructor stub
	}

    public Puan() {
    }

        
        
        
    @Override
    public void PuaniGoster() {
                
            System.out.println("Skor= "+getSkor());
    }
    
}

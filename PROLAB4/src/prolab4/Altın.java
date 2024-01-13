
package prolab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Altın extends Obje{
         private List<List<Integer>> topluliste2 = new ArrayList<>();  
    private int X;
    private int Y;
    private int sayı;
    public Altın(int değer, int süre,int sayı) {
        super(değer, süre);
        this.sayı=sayı;
    }
    
    public void ekle(int x,int y){
        for (int i = 0; i < topluliste2.size(); i++) {
            topluliste2.get(i).add(x);
            topluliste2.get(i).add(y);
        }
        
    }


    public List<List<Integer>> getTopluliste2() {
        return topluliste2;
    }

    public void setTopluliste2(List<List<Integer>> topluliste2) {
        this.topluliste2 = topluliste2;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getSayı() {
        return sayı;
    }

    public void setSayı(int sayı) {
        this.sayı = sayı;
    }
    
    
}
        


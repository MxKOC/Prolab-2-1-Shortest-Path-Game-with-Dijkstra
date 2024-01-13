
package prolab4;

import java.util.ArrayList;
import java.util.List;

public class Mantar extends Obje{

    private int X;
    private int Y;
    public Mantar(int değer, int süre) {
        super(değer, süre);
    }

    public Mantar() {
    }

    
    
    
    List<Integer> item = new ArrayList<Integer>(); 

    
    public void ekle(int x,int y){
       
            item.add(x);
            item.add(y);
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

    public List<Integer> getItem() {
        return item;
    }

    public void setItem(List<Integer> item) {
        this.item = item;
    }
    
}

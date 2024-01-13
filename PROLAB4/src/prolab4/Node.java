
package prolab4;

import java.util.ArrayList;
import java.util.List;

class Node {
    
    private int isim;
    private int x;
    private int y;
    List<Node> komşular = new ArrayList<Node>();
    private int yol=1;
    private Node öncekiNode; //sonraki veya önceki node un yerini tutuyor

    

    public Node(int isim, int x, int y) {
        this.isim = isim;
        this.x = x;
        this.y = y;
        
    }

    public int getIsim() {
        return isim;
    }

    public void setIsim(int isim) {
        this.isim = isim;
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

    public List<Node> getKomşular() {
        return komşular;
    }

    public void setKomşular(List<Node> komşular) {
        this.komşular = komşular;
    }

    public int getYol() {
        return yol;
    }

    public void setYol(int yol) {
        this.yol = yol;
    }

    public Node getÖncekiNode() {
        return öncekiNode;
    }

    public void setÖncekiNode(Node öncekiNode) {
        this.öncekiNode = öncekiNode;
    }


}




class KısaYol{

Node ilk;

Node son;
Node geçici;
List<Node> komşutut = new ArrayList<Node>();
List<Node> komşutut2 = new ArrayList<Node>();
List<Node> Dolu = new ArrayList<Node>();
    public KısaYol() {
            
    }

    public List<Node> dijkstra(int x1,int y1,int x2,int y2,char [][] matris,List<Node> liste){
        
        
        
        for (int i = 0; i < liste.size(); i++) {
            liste.get(i).setYol(9999);
            
            //System.out.println(liste.get(i).getIsim()+"--"+liste.get(i).getX()+"-"+liste.get(i).getY());   liste x y isim
        }
        Dolu(matris,liste);
        
        System.out.println("basss"+baş(x1,y1,liste).getIsim());
        System.out.println("sonnn"+son(x2, y2,liste).getIsim());
        ilk=baş(x1,y1,liste);
        son=son(x2,y2,liste);
        
        
        
        temizle(liste);


       
    ilk.setYol(0);
    ilk.setÖncekiNode(ilk);
    Node merkez=ilk;
       // System.out.println("-+-+-+-+-+-"+merkez.getIsim());
    dolaş(liste,merkez);
    
    
    
    
    temizle(liste);
       
        

                
                    
                for (int j = 0; j < merkez.getKomşular().size(); j++) {
                     if (!Dolu.contains(merkez.getKomşular().get(j))) {

                         komşutut.add(merkez.komşular.get(j));
                    }
                    }
                
                
                
                
            for(int m=0;m<9;m++){                   
                        for (Node node : komşutut) {
            
                            if (!Dolu.contains(node)) {
                                    
                            merkez=node;
                            dolaş(liste,merkez);
                            //System.out.println("11--"+node.getIsim()+"---"+merkez.getYol());
                            //temizle(liste);
                            
                    
                            komşutut2.addAll(merkez.komşular);
                            }
                        }
                        komşutut.clear();
                         
                         
                    for (Node node : komşutut2) {
                         
                        if (!Dolu.contains(node)) {
                            //System.out.println("22--"+node.getIsim()+"---"+merkez.getYol());
                        merkez=node;
                        dolaş(liste,merkez);
                        //temizle(liste);
                    
                        komşutut.addAll(merkez.komşular);
                    }
                    }   
                    komşutut2.clear();
                
            }
            
            
            
            /*
            for (int i = 0; i < liste.size(); i++) {
                System.out.println(liste.get(i).getIsim()+"->"+liste.get(i).getYol()+"+->"+liste.get(i).getÖncekiNode());
        }*/
        
        
        
        
        List atama =new ArrayList();
        Node geç=son;
        //System.out.println("geç::::"+geç.getIsim());
        atama.add(0, geç);
        for (int i = son.getYol(); i > 0; i--) {
           geç=geç.getÖncekiNode();
            //System.out.println("geç::::"+geç.getIsim());
            atama.add(0, geç);
            
        }
        
        
        return atama;
        
        
        }
 

    
    
    
    
    
    
    
    
    
    public Node dolaş(List<Node> liste,Node merkez2){
                    
        
        
        
                if(!Dolu.contains(merkez2)){
                
                for (int j = 0; j < merkez2.getKomşular().size(); j++) {
                    
                    if (!Dolu.contains(merkez2.getKomşular().get(j))) {
                        

                                
                        
                        if(merkez2.getYol()+1<merkez2.getKomşular().get(j).getYol()){
                            //System.out.println("----------"+merkez2.getKomşular().get(j).getIsim());
                            merkez2.getKomşular().get(j).setÖncekiNode(merkez2);
                            merkez2.getKomşular().get(j).setYol(merkez2.getYol()+1);
                            //System.out.println("++++++++++"+merkez2.getKomşular().get(j).getIsim());
                            
                        }
                        
                    }
                    
                    
                }
                Dolu.add(merkez2);
            }
        
        return merkez2;
    }
    
    
    
    
    
    
    
    
    
    
    
     public void temizle(List<Node> liste){
         
         for (int i = 0; i < liste.size(); i++) {
             for (int j = 0; j < liste.get(i).getKomşular().size(); j++) {
                 if(Dolu.contains(liste.get(i).getKomşular().get(j))){
                     //System.out.println("xxx="+i+"-"+j+"-"+liste.get(i).getKomşular().get(j).getIsim());
                     liste.get(i).getKomşular().remove(j);
                     j--;
                 }
                 
             }
             
         }
         
         
     }
    
    
    

     
     
     
     
     
    
    public void Dolu(char[][] matris,List<Node> liste){
        int say=0;
    for (int i = 0; i < 11; i++) {
        for (int j = 0; j < 13; j++) {
                   
            if (matris[i][j]=='0') {
                Dolu.add(liste.get(say));
                //System.out.println(liste.get(say).getIsim());
            }
            
            say++;
        }
                
    }
        //System.out.println(Dolu.size());
    }
    
    
    
    
    
    
    
    
    public Node baş(int x1,int y1,List<Node> liste){
        int x=0;
        for (int i = 0; i < liste.size(); i++) {
                if(liste.get(i).getX()==x1 && liste.get(i).getY()==y1)
                    
                    x=i;
        }
        return liste.get(x);
        
}

public Node son(int x2,int y2,List<Node> liste){
        int x=0;
        for (int i = 0; i < liste.size(); i++) {
                if(liste.get(i).getX()==x2 && liste.get(i).getY()==y2)
                    x=i;
        }
        return liste.get(x);
        
}














}
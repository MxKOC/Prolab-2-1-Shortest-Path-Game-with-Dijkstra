package prolab4;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements KeyListener,ActionListener {
	
	private Gözlüklü g;
	private Tembel tem;
	private Oyuncu o;
	
        private Gargamel gargamel2;  
        private Azman azman2;
        private List<Düşman> düşmanlar = new  ArrayList<Düşman>();
        
	private BufferedImage top;
	private BufferedImage duvar;
	private BufferedImage altın;
        private BufferedImage mantar;
        private BufferedImage yol2;
        private BufferedImage yol3;
	private BufferedImage azmanx;
        private BufferedImage gargamelx;
        private BufferedImage arka;
        private BufferedImage şirine;
        
        Timer t = new Timer(5,this);
	public List<Node>  yolliste = new ArrayList<Node>(); 
        public List<Node>  yolliste2 = new ArrayList<Node>(); 
        
        int kapıx1,kapıx2,kapıy1,kapıy2;
	private int topx;
	private int topy;

	private int hiz;
	
        private Font font =new Font("Serif", Font.BOLD, 50);
        private Font font2 =new Font("Serif", Font.BOLD, 150);
        String Yazı1;
        
	private char[][] matris = new char[11][13];
        public char[][] matrisdij = new char[11][13];
        public char[][] matris2 = new char[11][13];
        List<List<Integer>> topluliste2 = new ArrayList<>();
        List<Integer> item2 = new ArrayList<Integer>(); 
	List<Integer> itemx = new ArrayList<Integer>(); 
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Panel(int x,Gargamel gargamel,Azman azman,char[][] matris2) throws FileNotFoundException, IOException{
            if(gargamel.getID()==1){
            düşmanlar.add(gargamel);
            kapıx1=gargamel.getX();kapıy1=gargamel.getY();
            }
            
            if(azman.getID()==2){
            düşmanlar.add(azman);
            kapıx2=azman.getX();kapıy2=azman.getY();
            }
            
            this.azman2=azman;
            this.gargamel2=gargamel;
            
            
            for (int i = 0; i < 5; i++) { 
            List<Integer> item = new ArrayList<Integer>(); 
            topluliste2.add(item); 
        }
            
           
            
            itemx.add(0);
            itemx.add(1);
            
            
            mantar=ImageIO.read(new FileImageInputStream(new File("mantar.png")));
            altın=ImageIO.read(new FileImageInputStream(new File("altın.png")));
            yol2=ImageIO.read(new FileImageInputStream(new File("yol.png")));
            yol3=ImageIO.read(new FileImageInputStream(new File("yol2.png"))); 
            azmanx=ImageIO.read(new FileImageInputStream(new File("azman.png")));
            gargamelx=ImageIO.read(new FileImageInputStream(new File("gargamel.png"))); 
            arka=ImageIO.read(new FileImageInputStream(new File("arka.jpg"))); 
            duvar = ImageIO.read(new FileImageInputStream(new File("duvar.jpg")));
            şirine = ImageIO.read(new FileImageInputStream(new File("şirine.png")));
            
            
            tem = new Tembel("Osman",1,"Gözlüklü",6,5);
            g = new Gözlüklü("Osman",2,"Gözlüklü",6,5);
		
		
		
		if(x == 1) {
			top = ImageIO.read(new FileImageInputStream(new File("gozluklukucuk.png")));
			o = g;
		}
		
		if(x==2) {
			top = ImageIO.read(new FileImageInputStream(new File("tembelkucuk.png")));
                        o = tem;
                }
		

		topx = o.getX();
		topy = o.getY();
		hiz = o.getHiz();
		System.out.println(hiz);
		this.setBackground(Color.white);
                
                matrisdij=matris2;
                
                
                
                if(düşmanlar.size()==1){
                                for (Düşman düşman : düşmanlar) {
                                    if(düşman.getID()==2){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());

                                    }
                                    
                                    if(düşman.getID()==1){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());

                                    }
                                    }}
                                
                                else{
                                yoltık(düşmanlar.get(0).getX(),düşmanlar.get(0).getY(), o.getX(),o.getY());
                                yoltık2(düşmanlar.get(1).getX(),düşmanlar.get(1).getY(), o.getX(),o.getY());

                                }
                
                
		t.start();
		
		
		
	}

    

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
                    g.setFont(font);
                    g.setColor(Color.red);
                    g.drawString(String.valueOf(o.getSkor()),1550,350);
                    int boyut =95;
                
                 
            
                
            
            for (int j = 0; j < yolliste2.size(); j++) {
                g.drawImage(yol3 , yolliste2.get(j).getY()*boyut,yolliste2.get(j).getX()*boyut, boyut,boyut,this);
                
            }
                
              for (int j = 0; j < yolliste.size(); j++) {
                g.drawImage(yol2 , yolliste.get(j).getY()*boyut,yolliste.get(j).getX()*boyut, boyut,boyut,this);
                
            }  
            
            for (int i = 0; i < 5; i++) {
                    g.drawImage(altın, topluliste2.get(i).get(1)*boyut,topluliste2.get(i).get(0)*boyut, boyut,boyut,this);
                    if (topluliste2.get(i).get(1)==o.getX() && topluliste2.get(i).get(0)==o.getY()){
                        //System.out.println(topluliste2.get(i).get(1)+"-"+o.getX()+"-"+topluliste2.get(i).get(0)+"-"+o.getY()+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                       
                    topluliste2.set(i, itemx);
                    this.setTopluliste2(topluliste2);
                    
                    o.setSkor(o.getSkor()+5);
                    
                    
                    }
            }
                
               g.drawImage(mantar, item2.get(1)*boyut,item2.get(0)*boyut, boyut,boyut,this);
                
                 if(o.getX()==item2.get(1) && o.getY()==item2.get(0)){
                   //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                this.setItem2(itemx);
                 o.setSkor(o.getSkor()+50);
                 }
                
                 
                 for (int i=0;i<11;i++) {
			for(int j=0;j<13;j++) {
				if(matris[i][j] == '0') {
					g.drawImage(duvar, j*boyut, i*boyut,boyut,boyut,this);
				}
				
				if(matris[i][j] == 'p') {
					g.drawImage(top, j*boyut,i*boyut, boyut,boyut,this);
				}
				
			}
		}
                 
            if(azman2.getID()==2)
            g.drawImage(azmanx, azman2.getY()*boyut,azman2.getX()*boyut, boyut,boyut,this);
            if(azman2.getY()==o.getX() && azman2.getX()==o.getY()){
                o.setSkor(o.getSkor()-5);
                azman2.setX(kapıx2); azman2.setY(kapıy2);
                yolliste.remove(yolliste.size()-1);
            }
                
                
            if(gargamel2.getID()==1)
            g.drawImage(gargamelx, gargamel2.getY()*boyut,gargamel2.getX()*boyut, boyut,boyut,this);
            if(gargamel2.getY()==o.getX() && gargamel2.getX()==o.getY()){
                o.setSkor(o.getSkor()-15);
                 gargamel2.setX(kapıx1); gargamel2.setY(kapıy1);
                 yolliste.remove(yolliste.size()-1);
            }
        
            g.drawImage(şirine, 12*boyut,7*boyut, boyut,boyut,this);
            
            if (o.getSkor()<=0 || (o.getY()==7 && o.getX()==12) || (o.getY()==0 && o.getX()==0)) {
                int skor=o.getSkor();
                g.setFont(font2);
                g.drawImage(arka, 0,0, 3999,3999,this);
                g.drawString(String.valueOf(skor),900,500);
                
                o.setX(0);o.setY(0);
                
                

            }
            
            
            
            
        
        }
        
        
        
        public void yoltık(int x1,int y1,int y2,int x2){
            System.out.println("<<<<"+x2+"-----"+y2+">>>>>");
            
		List<Node> kliste = new ArrayList<Node>(); 

            int ad=0;
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 13; j++) {
                   
                    kliste.add(new Node(ad,i,j));
                    ad++;
                }
                
            }
        
            ad=0;
           for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 13; j++) {
                   
                    if(kliste.get(ad).getY()-1>=0)
                        kliste.get(ad).komşular.add(kliste.get(ad-1));
                    
                    if(kliste.get(ad).getY()+1<=12)
                        kliste.get(ad).komşular.add(kliste.get(ad+1));
                    
                    if(kliste.get(ad).getX()-1>=0)
                        kliste.get(ad).komşular.add(kliste.get(ad-13));
                    
                    if(kliste.get(ad).getX()+1<=10)    
                        kliste.get(ad).komşular.add(kliste.get(ad+13));
                        
                    
                    
                    ad++;
                }
                
            }
            
            KısaYol yol = new KısaYol();
       
            yolliste=yol.dijkstra(x1, y1, x2, y2, matrisdij,kliste);
            
            /*for (int i = 0; i < yolliste.size(); i++) {
                System.out.println (yolliste.get(i).getIsim());
            }*/
            
            
        }
        
        public void yoltık2(int x1,int y1,int y2,int x2){
            System.out.println("<<<<"+x2+"-----"+y2+">>>>>");
            
		List<Node> kliste = new ArrayList<Node>(); 

            int ad=0;
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 13; j++) {
                   
                    kliste.add(new Node(ad,i,j));
                    ad++;
                }
                
            }
        
            ad=0;
           for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 13; j++) {
                   
                    if(kliste.get(ad).getY()-1>=0)
                        kliste.get(ad).komşular.add(kliste.get(ad-1));
                    
                    if(kliste.get(ad).getY()+1<=12)
                        kliste.get(ad).komşular.add(kliste.get(ad+1));
                    
                    if(kliste.get(ad).getX()-1>=0)
                        kliste.get(ad).komşular.add(kliste.get(ad-13));
                    
                    if(kliste.get(ad).getX()+1<=10)    
                        kliste.get(ad).komşular.add(kliste.get(ad+13));
                        
                    
                    
                    ad++;
                }
                
            }
            
            KısaYol yol = new KısaYol();
       
            yolliste2=yol.dijkstra(x1, y1, x2, y2, matrisdij,kliste);
            
            
            
            
        }
        
        
        
        
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		
		
		if(c == KeyEvent.VK_LEFT) {
			
			if(matris[topy][topx-hiz] != '0' && matris[topy][topx-1] != '0') {
				
				char c2 = matris[topy][topx];
				matris[topy][topx] =  matris[topy][topx-hiz];
				matris[topy][topx-hiz] = c2;
				
				o.setX(o.getX()-hiz);
				topx = o.getX();
                                
                                if(düşmanlar.size()==1){
                                for (Düşman düşman : düşmanlar) {   
                                    if(düşman.getID()==2){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());
                                düşman.setX(yolliste.get(1).getX()); düşman.setY(yolliste.get(1).getY());
                                yolliste.remove(0);
                                    }
                                    
                                    if(düşman.getID()==1){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());
                                düşman.setX(yolliste.get(2).getX()); düşman.setY(yolliste.get(2).getY());
                                yolliste.remove(0);yolliste.remove(0);
                                    }
                                    }}
                                
                                
                                else{
                                yoltık(düşmanlar.get(0).getX(),düşmanlar.get(0).getY(), o.getX(),o.getY());
                                düşmanlar.get(0).setX(yolliste.get(2).getX()); düşmanlar.get(0).setY(yolliste.get(2).getY());
                                yolliste.remove(0);yolliste.remove(0);
                                yoltık2(düşmanlar.get(1).getX(),düşmanlar.get(1).getY(), o.getX(),o.getY());
                                düşmanlar.get(1).setX(yolliste2.get(1).getX()); düşmanlar.get(1).setY(yolliste2.get(1).getY());
                                yolliste2.remove(0);//System.out.println("<<<"+yolliste2.size());if(yolliste2.size()==1)yolliste2.clear();
                                }
                                System.out.println("----"+düşmanlar.get(0).getX()+"-"+düşmanlar.get(0).getY());
                                System.out.println("++++"+o.getX()+"-"+o.getY());
                        }
			
		}
		
		if(c == KeyEvent.VK_RIGHT) {
			
 			if(matris[topy][topx+hiz] != '0' && matris[topy][topx+1] != '0') {
				
				char c2 = matris[topy][topx];
				matris[topy][topx] =  matris[topy][topx+hiz];
				matris[topy][topx+hiz] = c2;
				
				o.setX(o.getX()+hiz);
				topx = o.getX();
                                if(düşmanlar.size()==1){
                                for (Düşman düşman : düşmanlar) {
                                    if(düşman.getID()==2){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());
                                düşman.setX(yolliste.get(1).getX()); düşman.setY(yolliste.get(1).getY());
                                yolliste.remove(0);
                                    }
                                    
                                    if(düşman.getID()==1){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());
                                düşman.setX(yolliste.get(2).getX()); düşman.setY(yolliste.get(2).getY());
                                yolliste.remove(0);yolliste.remove(0);
                                    }
                                    }}
                                
                                else{
                                yoltık(düşmanlar.get(0).getX(),düşmanlar.get(0).getY(), o.getX(),o.getY());
                                düşmanlar.get(0).setX(yolliste.get(2).getX()); düşmanlar.get(0).setY(yolliste.get(2).getY());
                                yolliste.remove(0);yolliste.remove(0);
                                yoltık2(düşmanlar.get(1).getX(),düşmanlar.get(1).getY(), o.getX(),o.getY());
                                düşmanlar.get(1).setX(yolliste2.get(1).getX()); düşmanlar.get(1).setY(yolliste2.get(1).getY());
                                yolliste2.remove(0);//System.out.println("<<<"+yolliste2.size());if(yolliste2.size()==1)yolliste2.clear();
                                }
                                System.out.println("----"+düşmanlar.get(0).getX()+"-"+düşmanlar.get(0).getY());
                                System.out.println("++++"+o.getX()+"-"+o.getY());
			}	

		}
		
		if(c == KeyEvent.VK_UP) {
			
			if(matris[topy-hiz][topx] != '0' && matris[topy-1][topx] != '0') {
				
				char c2 = matris[topy][topx];
				matris[topy][topx] =  matris[topy-hiz][topx];
				matris[topy-hiz][topx] = c2;
				
				o.setY(o.getY()-hiz);
				topy = o.getY();
                                if(düşmanlar.size()==1){
                                for (Düşman düşman : düşmanlar) {
                                    if(düşman.getID()==2){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());
                                düşman.setX(yolliste.get(1).getX()); düşman.setY(yolliste.get(1).getY());
                                yolliste.remove(0);
                                    }
                                    
                                    if(düşman.getID()==1){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());
                                düşman.setX(yolliste.get(2).getX()); düşman.setY(yolliste.get(2).getY());
                                yolliste.remove(0);yolliste.remove(0);
                                    }
                                    }}
                                
                                else{
                                yoltık(düşmanlar.get(0).getX(),düşmanlar.get(0).getY(), o.getX(),o.getY());
                                düşmanlar.get(0).setX(yolliste.get(2).getX()); düşmanlar.get(0).setY(yolliste.get(2).getY());
                                yolliste.remove(0);yolliste.remove(0);
                                yoltık2(düşmanlar.get(1).getX(),düşmanlar.get(1).getY(), o.getX(),o.getY());
                                düşmanlar.get(1).setX(yolliste2.get(1).getX()); düşmanlar.get(1).setY(yolliste2.get(1).getY());
                                yolliste2.remove(0);//System.out.println("<<<"+yolliste2.size());if(yolliste2.size()==1)yolliste2.clear();
                                }
                                System.out.println("----"+düşmanlar.get(0).getX()+"-"+düşmanlar.get(0).getY());
                                System.out.println("++++"+o.getX()+"-"+o.getY());
			}
		}
		
		if(c == KeyEvent.VK_DOWN) {
			
			if(matris[topy+hiz][topx] != '0' && matris[topy+1][topx] != '0') {
				
				char c2 = matris[topy][topx];
				matris[topy][topx] =  matris[topy+hiz][topx];
				matris[topy+hiz][topx] = c2;
				
				o.setY(o.getY()+hiz);
				topy = o.getY();
                                
                                if(düşmanlar.size()==1){
                                for (Düşman düşman : düşmanlar) {
                                    if(düşman.getID()==2){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());
                                düşman.setX(yolliste.get(1).getX()); düşman.setY(yolliste.get(1).getY());
                                yolliste.remove(0);
                                    }
                                    
                                    if(düşman.getID()==1){
                                yoltık(düşman.getX(),düşman.getY(), o.getX(),o.getY());
                                düşman.setX(yolliste.get(2).getX()); düşman.setY(yolliste.get(2).getY());
                                yolliste.remove(0);yolliste.remove(0);
                                    }
                                    }}
                                
                                else{
                                yoltık(düşmanlar.get(0).getX(),düşmanlar.get(0).getY(), o.getX(),o.getY());
                                düşmanlar.get(0).setX(yolliste.get(2).getX()); düşmanlar.get(0).setY(yolliste.get(2).getY());
                                yolliste.remove(0);yolliste.remove(0);
                                yoltık2(düşmanlar.get(1).getX(),düşmanlar.get(1).getY(), o.getX(),o.getY());
                                düşmanlar.get(1).setX(yolliste2.get(1).getX()); düşmanlar.get(1).setY(yolliste2.get(1).getY());
                                yolliste2.remove(0);//System.out.println("<<<"+yolliste2.size());if(yolliste2.size()==1)yolliste2.clear();
                                }
                                System.out.println("----"+düşmanlar.get(0).getX()+"-"+düşmanlar.get(0).getY());
                                System.out.println("++++"+o.getX()+"-"+o.getY());
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public BufferedImage getTop() {
		return top;
	}

	public void setTop(BufferedImage top) {
		this.top = top;
	}

	public BufferedImage getDuvar() {
		return duvar;
	}

	public void setDuvar(BufferedImage duvar) {
		this.duvar = duvar;
	}

	public Timer getT() {
		return t;
	}

	public void setT(Timer t) {
		this.t = t;
	}

	public int getTopx() {
		return topx;
	}

	public void setTopx(int topx) {
		this.topx = topx;
	}

	public int getTopy() {
		return topy;
	}

	public void setTopy(int topy) {
		this.topy = topy;
	}

	public int getHiz() {
		return hiz;
	}

	public void setHiz(int hiz) {
		this.hiz = hiz;
	}

	public char[][] getMatris() {
		return matris;
	}

	public void setMatris(char[][] matris) {
		this.matris = matris;
	}


        public List<List<Integer>> getTopluliste2() {
                return topluliste2;
        }

        public void setTopluliste2(List<List<Integer>> topluliste2) {
            this.topluliste2 = topluliste2;
        }

        public List<Integer> getItem2() {
            return item2;
        }

        public void setItem2(List<Integer> item2) {
            this.item2 = item2;
        }

    public List<Node> getYolliste() {
        return yolliste;
    }

    public void setYolliste(List<Node> yolliste) {
        this.yolliste = yolliste;
    }


	
	

}

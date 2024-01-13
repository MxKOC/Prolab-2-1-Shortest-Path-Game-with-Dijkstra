package prolab4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;

public class Test extends JFrame {

    public Test() throws HeadlessException {
        super();
        // TODO Auto-generated constructor stub

    }

    public Test(GraphicsConfiguration gc) {
        super(gc);
        // TODO Auto-generated constructor stub
    }

    public Test(String title, GraphicsConfiguration gc) {
        super(title, gc);
        // TODO Auto-generated constructor stub
    }

    public Test(String title) throws HeadlessException {
        super(title);
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        JFrame jf2 = new JFrame();
        jf2.setSize(1921, 1080);

        jf2.setResizable(false);
        jf2.setFocusable(false);

        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp2 = new JPanel();

        jf2.add(jp2);
        //jp2.setBackground(Color.white);
        jp2.setVisible(true);

        jf2.setVisible(true);

        JButton seçim = new JButton();
        JButton seçim2 = new JButton();

        jp2.add(seçim);
        jp2.add(seçim2);

        seçim.setBackground(Color.BLACK);
        seçim2.setBackground(Color.BLACK);
        seçim.setPreferredSize(new Dimension(800, 1000));
        seçim2.setPreferredSize(new Dimension(800, 1000));

        ImageIcon icon = new ImageIcon("gozluklu.jpg");
        ImageIcon icon2 = new ImageIcon("tembel.jpg");

        seçim.setIcon(icon);
        seçim2.setIcon(icon2);

//**********************************************************************************************************************//  --->     Seçimler        
        seçim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("GÖZLÜKLÜ ÇALIŞ...");
                try {
                    yyy1();
                } catch (IOException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
                jf2.setVisible(false);
            }
        });
        seçim2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tembel ÇALIŞ...");
                try {
                    yyy2();
                } catch (IOException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
                jf2.setVisible(false);
            }
        });

        /*       
System.exit(0); // stop program
frame.dispose(); // close window
         */
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////              thread fonksiyon
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public static List<Integer> threadfonk(List<List<Integer>> topluliste) {

        List<Integer> item = new ArrayList<Integer>();
        Random r = new Random();
        int z = r.nextInt(70);
        System.out.print(topluliste.size());
        item.add(topluliste.get(z).get(0));
        item.add(topluliste.get(z).get(1));
        //System.out.println(item+"+"+z);

        return item;

    }

    ;
        
        
        
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
//**********************************************************************************************************************//  ---> Tembel Şirin Fonksiyon 
        
        public static void yyy1() throws IOException {

        Test jf = new Test("Şirinler Oyunu");
        jf.setSize(1920, 1080);

        jf.setResizable(false);
        jf.setFocusable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Azman azman = new Azman();
        Gargamel gargamel = new Gargamel();

        File f = new File("Sadece harita.txt");
        int x = 0;
        char[][] matris = new char[11][13];

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> line = new ArrayList();
        String l;

        while ((l = br.readLine()) != null) {
            line.add(l);
        }

        int bas = 0;
        String x1, x2;
        x1 = line.get(0);
        System.out.println(x1);
        int başlangıcX = 1, başlangıcY = 1;
        if (x1.charAt(0) == 'K') {

            bas++;

            int find = x1.indexOf("Gargamel");
            char find2 = x1.charAt(x1.length() - 1);

            System.out.println("kapı==" + find2);
            if (find2 == 'A') {
                System.out.println("aaa");
                başlangıcX = 0;
                başlangıcY = 3;
            }
            if (find2 == 'B') {
                System.out.println("bbb");
                başlangıcX = 0;
                başlangıcY = 10;
            }
            if (find2 == 'C') {
                System.out.println("ccc");
                başlangıcX = 5;
                başlangıcY = 0;
            }
            if (find2 == 'D') {
                System.out.println("ddd");
                başlangıcX = 10;
                başlangıcY = 3;
            }
            if (find == - 1) {
                System.out.println("azman var 1.satır");   //// azman var 1.satır

                azman = new Azman(2, "Azman", "1", başlangıcX, başlangıcY);
            } else {
                System.out.println("gargamel var 1.satır");  ////gargamel var 1.satır

                gargamel = new Gargamel(1, "Gargamel", "2", başlangıcX, başlangıcY);
            }

        }

        x2 = line.get(1);
        //System.out.println(x2); 

        if (x2.charAt(0) == 'K') {

            bas++;

            int find = x2.indexOf("Gargamel");

            char find2 = x2.charAt(x2.length() - 1);
            System.out.println("kapı==" + find2);
            if (find2 == 'A') {
                System.out.println("aaa");
                başlangıcX = 0;
                başlangıcY = 3;
            }
            if (find2 == 'B') {
                System.out.println("bbb");
                başlangıcX = 0;
                başlangıcY = 10;
            }
            if (find2 == 'C') {
                System.out.println("ccc");
                başlangıcX = 5;
                başlangıcY = 0;
            }
            if (find2 == 'D') {
                System.out.println("ddd");
                başlangıcX = 10;
                başlangıcY = 3;
            }
            if (find == - 1) {
                System.out.println("azman var 2.satır"); //// azman var 2.satır

                azman = new Azman(2, "Azman", "1", başlangıcX, başlangıcY);
            } else {
                System.out.println("gargamel var 2.satır"); ////gargamel var 2.satır

                gargamel = new Gargamel(1, "Gargamel", "2", başlangıcX, başlangıcY);
            }

        }

        int s = 0;
        for (int i = bas; i < 11 + bas; i++) {

            l = line.get(i);
            x = 0;
            for (int j = 0; j < line.get(4).length(); j++) {
                char c = line.get(i).charAt(j);

                if (c != ' ' && c != '\t') {
                    System.out.print(c);
                    matris[s][x] = c;
                    x += 1;
                }

            }
            System.out.println("");
            s++;
        }

        Panel jp = new Panel(1, gargamel, azman, matris);
        jf.add(jp);
        jp.setBackground(Color.BLACK);
        jp.setVisible(true);
        jp.requestFocus();
        jp.addKeyListener(jp);
        jp.setFocusable(true);
        jp.setFocusTraversalKeysEnabled(false);

        jf.setVisible(true);

//**********************************************************************************************************************//  ---> dijkstra
//**********************************************************************************************************************//  --->  ilk fonk. Thread ler başlangıç
        int a = 0;
        List<List<Integer>> topluliste = new ArrayList<>();
        List<List<Integer>> topluliste2 = new ArrayList<>();

        for (int i = 0; i < 78; i++) {
            List<Integer> item = new ArrayList<Integer>();
            topluliste.add(item);
        }

        List<Integer> item2 = new ArrayList<Integer>();
        List<Integer> item3 = new ArrayList<Integer>();
        item3.add(3);
        item3.add(0);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {

                if (matris[i][j] == '1') {

                    topluliste.get(a).add(i);
                    topluliste.get(a).add(j);
                    a++;
                }

            }
        }
        System.out.println(topluliste);

//**********************************************************************************************************************//  --->     1. thead
        Altın altın = new Altın(5, 5, 5);
        Mantar mantar = new Mantar(50, 7);
        Thread printer1;
        printer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Çalışıyor...");
                for (int i = 1; i <= 1000; i++) {

                    if (i != 1) {
                        for (int j = 0; j < altın.getSayı(); j++) {

                            topluliste2.add(item3);

                        }

                        jp.setTopluliste2(topluliste2);

                        Random r = new Random();
                        int z = r.nextInt(5) + 6;
                        try {
                            Thread.sleep(z * 1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        topluliste2.clear();

                    }

                    for (int j = 0; j < altın.getSayı(); j++) {

                        Random r = new Random();
                        int z = r.nextInt(72);

                        topluliste2.add(topluliste.get(z));
                        //System.out.println(topluliste.get(z)+"+"+z);
                        jp.setTopluliste2(topluliste2);
                        topluliste.remove(z);

                    }
                    topluliste.add(topluliste2.get(0));
                    topluliste.add(topluliste2.get(1));
                    topluliste.add(topluliste2.get(2));
                    topluliste.add(topluliste2.get(3));
                    topluliste.add(topluliste2.get(4));

                    try {
                        Thread.sleep(altın.getSüre() * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    topluliste2.clear();

                }

            }
        });

        printer1.start();

//**********************************************************************************************************************//  --->     2.thread            
        Thread printer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Çalışıyor...");
                for (int i = 1; i <= 1000; i++) {

                    if (i != 1) {

                        jp.setItem2(item3);

                        Random r = new Random();
                        int z = r.nextInt(10) + 10;
                        try {
                            Thread.sleep(z * 1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    }

                    item2.addAll(threadfonk(topluliste));

                    //System.out.println(item2);
                    jp.setItem2(item2);

                    try {
                        Thread.sleep(mantar.getSüre() * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    item2.clear();
                }

            }
        });

        printer2.start();

        jp.matrisdij = matris;

        matris[5][6] = 'p';
        jp.setMatris(matris);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
//**********************************************************************************************************************//  ---> Gözlüklü Şirin fonksiyon
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void yyy2() throws IOException {

        Test jf = new Test("Şirinler Oyunu");
        jf.setSize(1920, 1080);

        jf.setResizable(false);
        jf.setFocusable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Azman azman = new Azman();
        Gargamel gargamel = new Gargamel();

        File f = new File("Sadece harita.txt");
        int x = 0;
        char[][] matris = new char[11][13];

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> line = new ArrayList();
        String l;

        while ((l = br.readLine()) != null) {
            line.add(l);
        }

        int bas = 0;
        String x1, x2;
        x1 = line.get(0);
        System.out.println(x1);
        int başlangıcX = 1, başlangıcY = 1;
        if (x1.charAt(0) == 'K') {

            bas++;

            int find = x1.indexOf("Gargamel");
            char find2 = x1.charAt(x1.length() - 1);

            System.out.println("kapı==" + find2);
            if (find2 == 'A') {
                System.out.println("aaa");
                başlangıcX = 0;
                başlangıcY = 3;
            }
            if (find2 == 'B') {
                System.out.println("bbb");
                başlangıcX = 0;
                başlangıcY = 10;
            }
            if (find2 == 'C') {
                System.out.println("ccc");
                başlangıcX = 5;
                başlangıcY = 0;
            }
            if (find2 == 'D') {
                System.out.println("ddd");
                başlangıcX = 10;
                başlangıcY = 3;
            }
            if (find == - 1) {
                System.out.println("azman var 1.satır");   //// azman var 1.satır

                azman = new Azman(2, "Azman", "1", başlangıcX, başlangıcY);
            } else {
                System.out.println("gargamel var 1.satır");  ////gargamel var 1.satır

                gargamel = new Gargamel(1, "Gargamel", "2", başlangıcX, başlangıcY);
            }

        }

        x2 = line.get(1);
        //System.out.println(x2); 

        if (x2.charAt(0) == 'K') {

            bas++;

            int find = x2.indexOf("Gargamel");

            char find2 = x2.charAt(x2.length() - 1);
            System.out.println("kapı==" + find2);
            if (find2 == 'A') {
                System.out.println("aaa");
                başlangıcX = 0;
                başlangıcY = 3;
            }
            if (find2 == 'B') {
                System.out.println("bbb");
                başlangıcX = 0;
                başlangıcY = 10;
            }
            if (find2 == 'C') {
                System.out.println("ccc");
                başlangıcX = 5;
                başlangıcY = 0;
            }
            if (find2 == 'D') {
                System.out.println("ddd");
                başlangıcX = 10;
                başlangıcY = 3;
            }
            if (find == - 1) {
                System.out.println("azman var 2.satır"); //// azman var 2.satır

                azman = new Azman(2, "Azman", "1", başlangıcX, başlangıcY);
            } else {
                System.out.println("gargamel var 2.satır"); ////gargamel var 2.satır

                gargamel = new Gargamel(1, "Gargamel", "2", başlangıcX, başlangıcY);
            }

        }

        int s = 0;
        for (int i = bas; i < 11 + bas; i++) {

            l = line.get(i);
            x = 0;
            for (int j = 0; j < line.get(4).length(); j++) {
                char c = line.get(i).charAt(j);

                if (c != ' ' && c != '\t') {
                    System.out.print(c);
                    matris[s][x] = c;
                    x += 1;
                }

            }
            System.out.println("");
            s++;
        }

        Panel jp = new Panel(2, gargamel, azman, matris);
        jf.add(jp);
        jp.setBackground(Color.BLACK);
        jp.setVisible(true);
        jp.requestFocus();
        jp.addKeyListener(jp);
        jp.setFocusable(true);
        jp.setFocusTraversalKeysEnabled(false);

        jf.setVisible(true);

        int a = 0;
        List<List<Integer>> topluliste = new ArrayList<>();
        List<List<Integer>> topluliste2 = new ArrayList<>();

        for (int i = 0; i < 78; i++) {
            List<Integer> item = new ArrayList<Integer>();
            topluliste.add(item);
        }

        List<Integer> item2 = new ArrayList<Integer>();
        List<Integer> item3 = new ArrayList<Integer>();
        item3.add(3);
        item3.add(0);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {

                if (matris[i][j] == '1') {

                    topluliste.get(a).add(i);
                    topluliste.get(a).add(j);
                    a++;
                }

            }
        }
        //System.out.println(topluliste);

//**********************************************************************************************************************//  --->    1. Thread
        Altın altın = new Altın(5, 5, 5);
        Mantar mantar = new Mantar(50, 7);

        Thread printer1;
        printer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //System.out.println("Thread Çalışıyor...");
                for (int i = 1; i <= 1000; i++) {

                    if (i != 1) {
                        for (int j = 0; j < altın.getSayı(); j++) {

                            topluliste2.add(item3);

                        }

                        jp.setTopluliste2(topluliste2);

                        Random r = new Random();
                        int z = r.nextInt(5) + 6;
                        try {
                            Thread.sleep(z * 1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        topluliste2.clear();

                    }

                    for (int j = 0; j < altın.getSayı(); j++) {

                        Random r = new Random();
                        int z = r.nextInt(72);

                        topluliste2.add(topluliste.get(z));
                        //System.out.println(topluliste.get(z)+"+"+z);
                        jp.setTopluliste2(topluliste2);
                        topluliste.remove(z);

                    }
                    topluliste.add(topluliste2.get(0));
                    topluliste.add(topluliste2.get(1));
                    topluliste.add(topluliste2.get(2));
                    topluliste.add(topluliste2.get(3));
                    topluliste.add(topluliste2.get(4));

                    try {
                        Thread.sleep(altın.getSüre() * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    topluliste2.clear();

                }

            }
        });

        printer1.start();

//**********************************************************************************************************************//  --->      2.Thread            
        Thread printer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //System.out.println("Thread Çalışıyor...");
                for (int i = 1; i <= 1000; i++) {

                    if (i != 1) {

                        jp.setItem2(item3);

                        Random r = new Random();
                        int z = r.nextInt(10) + 10;
                        try {
                            Thread.sleep(z * 1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    }

                    item2.addAll(threadfonk(topluliste));

                    //System.out.println(item2);
                    jp.setItem2(item2);

                    try {
                        Thread.sleep(mantar.getSüre() * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    item2.clear();
                }

            }
        });

        printer2.start();

        jp.matrisdij = matris;

        matris[5][6] = 'p';
        jp.setMatris(matris);

    }

}

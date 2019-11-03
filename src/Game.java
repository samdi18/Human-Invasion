//import java.awt.*;

//import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
 
public class Game extends JPanel implements ActionListener, Runnable {
        public BadHuman player;
        public Image background;
        Timer time;
        public static int v = 300;
        Thread animation;
		public static ArrayList<Alien> aliens;
		int points = 0;
		
 
		 public boolean lost = false;
 
   
         public boolean controlJump = false;
       
         public  static Font font = new Font("SanSerif", Font.BOLD, 24);
         public  static Font font1 = new Font("SanSerif", Font.BOLD, 54);
         public Game() {
                player = new BadHuman();
                addKeyListener(new KeyManager());
                setFocusable(true);
                ImageIcon i = new ImageIcon("background.png");
                background = i.getImage();
                time = new Timer(5, this);
                time.start();
                aliens = new ArrayList<Alien>();
                displayAlien();
        }
 
        public void actionPerformed(ActionEvent e) {
                checkCollisions();
                ArrayList<FireBullet> bullets = BadHuman.getBullets();
               
                for (int j = 0; j < bullets.size(); j++)
                {
                        FireBullet m = (FireBullet) bullets.get(j);
                        if (m.getVisible() == true)
                        m.move();
                        else
                                bullets.remove(j);
                }
                // To generate aliens
                for (int i = 0; i < aliens.size(); i++)
                {
                        Alien alie =aliens.get(i);
                        if (alie.Alive() == true)
                        alie.move();
                        else
                                aliens.remove(i);
                }
               
                player.move();
               

                repaint();
        }
        
        
     
        
        public void displayAlien(){

        	aliens.add(new Alien((int )(Math. random() * 3000 + 2000), (int )(Math. random() * 200 + 100)));
            aliens.add(new Alien((int )(Math. random() * 3000 + 2000), (int )(Math. random() * 200 + 100)));
            aliens.add(new Alien((int )(Math. random() * 1500 + 1000), (int )(Math. random() * 200 + 100)));
            aliens.add(new Alien((int )(Math. random() * 1500 + 1000), (int )(Math. random() * 200 + 100)));
            aliens.add(new Alien((int )(Math. random() * 1000 + 700),  (int )(Math. random() * 200 + 100)));
            aliens.add(new Alien((int )(Math. random() * 1000 + 700),  (int )(Math. random() * 200 + 100)));
            aliens.add(new Alien((int )(Math. random() * 4000 + 3500), (int )(Math. random() * 200 + 100)));
            aliens.add(new Alien((int )(Math. random() * 4000 + 3500), (int )(Math. random() * 200 + 100)));
            aliens.add(new Alien((int )(Math. random() * 5000 + 4500), (int )(Math. random() * 200 + 100)));
            aliens.add(new Alien((int )(Math. random() * 5000 + 4500), (int )(Math. random() * 200 + 100)));
              
        }
       
 
public void checkCollisions()
{
	Rectangle r;
	for(int i =0;i<aliens.size();i++){
       r = aliens.get(i).getBounds();
	
        ArrayList<FireBullet> bullets = BadHuman.getBullets();
        
        for (int j = 0; j < bullets.size(); j++)
        {
                FireBullet m = (FireBullet) bullets.get(j);
                Rectangle m1 = m.getBounds();
                if (r.intersects(m1) && aliens.get(i).Alive())
                {
               	points++;
             
                	aliens.get(i).isAlive = false;
                        m.visible = false;
                        
                }

        }
        
	
        Rectangle rect = player.getBounds();
        if (rect.intersects(aliens.get(i).getBounds()))
         
               lost = true;
	}
       
}
 
        public void paint(Graphics g) {
        	
        	
     if (lost){

       System.out.println("You LOST");
       
     	}
 
 
        if (player.dy == 1 && controlJump == false) {
                        controlJump = true;
                        animation = new Thread(this);
                        animation.start();
                }
 
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
                
            // For scrolling background
                if ((player.getX() - 495) % 2000 == 0)
                        player.startImg = 0;
                if ((player.getX() - 1280) % 2000 == 0)
                        player.nx2 = 0;
                g2d.drawImage(background, 785 - player.getnX2(), 0, null);
                
              
                System.out.println(player.getX());
                
                if (player.getX() >= 495) {
                        g2d.drawImage(background, 785 - player.getnX(), 0, null);
                     
                       
                }
                
                
                //Draw Player
                g2d.drawImage(player.getImage(), player.initial, v, null);
 

               
                ArrayList<FireBullet> bullets = BadHuman.getBullets();
                for (int j = 0; j < bullets.size(); j++)
                {
                        FireBullet m = (FireBullet) bullets.get(j);
                        if (m.getVisible())
                        g2d.drawImage(m.getImage(),m.getX(), m.getY(), null);
                }
                
                if(points == 10){
                	g2d.setFont(font1);
                    g2d.setColor(Color.CYAN);
                	g2d.drawString("INVASION COMPLETE",100, 200);
                }
                else{
                g2d.setFont(font);
                g2d.setColor(Color.MAGENTA);
                g2d.drawString("Points: " + points, 500, 20);
                }
                //Draw Aliens
                for (int i = 0; i < aliens.size(); i++)
                {
                        Alien alien = aliens.get(i);
                        if (alien.Alive())
                        	for(int k =0;k<aliens.size();k++)
                        g2d.drawImage(alien.getImage(),aliens.get(k).getX(), aliens.get(k).getY(), null);
                }
                

        }
        
       
 
        private class KeyManager extends KeyAdapter {
                public void keyReleased(KeyEvent e) {
                        player.keyReleased(e);
                }
 
                public void keyPressed(KeyEvent e) {
                        player.keyPressed(e);
                }
        }
 
        boolean maxHeight = false;
        boolean doneJumping = false;
 
        public void jump() {
 
                if (maxHeight == false)
                        v--;
                if (v == 125)
                        maxHeight = true;
                if (maxHeight == true && v <= 300) {
                        v++;
                        if (v == 300) {
                                doneJumping = true;
                        }
                }
        }
 
        public void run() {
 
                long beforeTime, timeDiff, sleep;
 
                beforeTime = System.currentTimeMillis();
 
                while (doneJumping == false) {
 
                        jump();
 
                        timeDiff = System.currentTimeMillis() - beforeTime;
                        sleep = 10 - timeDiff;
 
                        if (sleep < 0)
                                sleep = 2;
                        try {
                                Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                        }
 
                        beforeTime = System.currentTimeMillis();
                }
                doneJumping = false;
                maxHeight = false;
                controlJump = false;
        }
 
}
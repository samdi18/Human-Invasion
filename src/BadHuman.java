 
//import java.awt.* ;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
 
public class BadHuman extends Creatures{
        int x, dx, y,dy,startImg,nx2,initial;
        Image still;
       
 
       
        ImageIcon s = new ImageIcon("still.png");
        ImageIcon j= new ImageIcon("jump.png");
        ImageIcon l = new ImageIcon("left.png");
        ImageIcon r = new ImageIcon("right.png");
       
        static ArrayList<FireBullet> bullets;
       
        public BadHuman() {
                x = 0;
                initial = 150;
                startImg = 0;
                nx2= 785;
                y = 0;
                still = s.getImage();
                bullets = new ArrayList<FireBullet>();
       
        }
       
        public Rectangle getBounds()
        {
                return new Rectangle(initial,y, 99, 152);
        }  
       
        public static ArrayList<FireBullet> getBullets()
        {
                return bullets;
        }
       
        public void shoot()
        {
        	//For creating bullets from where the character is
                FireBullet z = new FireBullet((initial + 60), (Game.v + 154/2));
                bullets.add(z);
       
        }
        public void move() {
                if (dx == 1){
                        if (initial + dx <= 150) //if we want to return from the end of the frame
                               initial+=dx;
                        else{
                x = x + dx;
                nx2= nx2+dx;
                startImg = startImg + dx;
        }
                        }
                else
        {
                if (initial+dx >0)    //controls the frame not to get out of it
                initial = initial + dx;
        }
                }
 
        public int getX() {
                return x;
        }
       
        public int getLeft(){
                return initial;
        }
 
        public int getnX() {
                return startImg;
        }
       
        public int getnX2() {
                return nx2;
        }
 
        public int getdx() {
                return dx;
        }
       
        public Image getImage() {
                return still;
        }
 
        public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT)
                {               dx = -1;
                
                still = l.getImage();           }
               
                if (key == KeyEvent.VK_RIGHT)
                        {dx = 1;
                still = r.getImage();  
                        }
               
                if (key == KeyEvent.VK_SPACE)
                {
                        shoot();
                }
               
                if (key == KeyEvent.VK_UP)
                        {dy = 1;
                        still = j.getImage();
                        }                       }
 
        public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
 
                if (key == KeyEvent.VK_LEFT)
                        dx = 0;
 
                if (key == KeyEvent.VK_RIGHT){
                        dx = 0;
                        still = s.getImage();
                }
               
                if (key == KeyEvent.VK_UP)
                        {dy = 0;
                        still = s.getImage();}
                        }
        }
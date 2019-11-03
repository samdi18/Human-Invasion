//import java.awt.*;

 
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
 
public class FireBullet {
 
        int x,y;
        Image fireImg;
        boolean visible;
       
        public FireBullet(int startX, int startY)
        {
                x = startX;
                y = startY;
                ImageIcon newBullet = new ImageIcon("bullet.png");
                fireImg = newBullet.getImage(); 
                visible = true;
        }
       
        public Rectangle getBounds()
        {
                return new Rectangle(x,y, 22, 10);
        }
        public int getX()
        {
                return x;
        }
        public int getY()
        {
                return y;
        }
        public boolean getVisible()
        {
                return visible;
        }
        public Image getImage()
        {
                return fireImg;
        }
       
        public void move()
        {
                x = x + 2;
                if ( x > 700)
                        visible = false;
        }
       
        public void setVisible(boolean isVisible)
        {
                visible = isVisible;
        }
       
 
}
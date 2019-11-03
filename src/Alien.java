import java.awt.*;
 
import javax.swing.ImageIcon;
 
public class Alien extends Creatures{
 
        Image alienImg;
        int x, y;
        boolean isAlive = true;
       
        public Alien(int startX, int startY)
        {
        	
                x = startX;
                y = startY;
                ImageIcon l = new ImageIcon("alien.png");
                alienImg = l.getImage();
        }
       
        public int getX()
        {
                return x;
        }
        public int getY()
        {
                return y;
        }
        public boolean Alive()
        {
                return isAlive;
        }
        public Image getImage()
        {
                return alienImg;
        }
       
        public void move()
        {

        	x--;
        }
 
        public Rectangle getBounds()
        {
                return new Rectangle(x,y, 99, 152);
        }

		

	
       
}
import javax.swing.JFrame;

 
public class Frame {
 
        public Frame(){
                JFrame frame = new JFrame();
                frame.add(new Game());
                frame.setTitle("HUMAN INVASION");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800,500);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
        }
        public static void main(String[] args){
                new Frame();
        }
}
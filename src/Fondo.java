import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {
    public void paint(Graphics g){
        Image nivel= new ImageIcon(getClass().getResource("Ciudad.png")).getImage();
        g.drawImage(nivel, 0, 0,getWidth(),getHeight(),(ImageObserver) this);
        setOpaque(false);
        super.paint(g);
    }
}

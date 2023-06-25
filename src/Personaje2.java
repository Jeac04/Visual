import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;


public class Personaje2 {
     static final int ANCHO = 100;
    static final int ALTO = 100;
    int x= 500;
    int y= 250;

    int y1 = 0;
    Juego2 jueguito;
    Image img;
    boolean saltando = false;
    boolean sube = false;
    boolean baja = false;

    public Personaje2 (Juego2 juego2){
        this.jueguito = juego2;
        ImageIcon icon = new ImageIcon(getClass().getResource("personaje.png"));
        img = icon.getImage();
    }

    public void mover(){
        if (saltando){
            if(y==250){
                sube= true;
                y1= -5;
                baja= false;
            }
            if (y==50){
                baja = true;
                y1= 5;
                sube= false;
            }
             if (sube){
                y+=y1;
             }
             if(baja){
                y += y1;
                if(y==250){
                    saltando= false;
                }
             }
        }
    }

    public void paint (Graphics2D g){
        g.drawImage(img, x, y, ANCHO, ALTO, null);
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            saltando = true;
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, ANCHO, ALTO);
    }
}

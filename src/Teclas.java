import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Teclas{
   static final int ANCHO = 100;
    static final int ALTO = 100;
    int x = 500;
    int y = 250;
    int y1 = 0;
    int x1 = 0;
    Juego jueguito;
    Image img;
    boolean saltando = false;
    boolean sube = false;
    boolean baja = false;
    boolean izq = false;
    boolean der = false;

    public Teclas(Juego juego) {
        this.jueguito = juego;
        ImageIcon icon = new ImageIcon(getClass().getResource("personaje.png"));
        img = icon.getImage();
    }

    public void mover() {
        if (sube) {
            if (y > 0) {
                y -= 70;
            }
        } else {
            if (baja) {
                if (y < 300) {
                    y += 30;
                }
            } else {
                if (izq) {
                    if (x > 0) {
                        x -= 30;
                    }
                } else {
                    if (der) {
                        if (x < 1100) {
                            x += 30;
                        }
                    }
                }
            }
        }
        baja = false;
        sube = false;
        izq = false;
        der = false;

    }

    public void paint(Graphics2D g) {
        g.drawImage(img, x, y, ANCHO, ALTO, null);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                izq = true;
                break;
            case 38:
                sube = true;
                break;
            case 39:
                der = true;
                break;
            case 40:
                baja = true;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, ANCHO, ALTO);
    } 
}

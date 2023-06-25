import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Teclas extends Thread{
   static final int ANCHO = 100;
    static final int ALTO = 100;
    int x = 50;
    int y = 250;
    int y1 = 0;
    int x1 = 0;
    Juego jueguito;
    boolean saltando = false;
    boolean sube = false;
    boolean baja = false;
    boolean izq = false;
    boolean der = false;

    public Teclas(Juego jueguito) {
        this.jueguito = jueguito;
    }

    public void run() {
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
        g.fillRect(x, y, ANCHO, ALTO);
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

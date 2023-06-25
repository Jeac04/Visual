import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Obstaculo3 {
     static final int ANCHO= 50;
    static final int ALTO = 100;
    static int inc_x = +5;
    static int x= -10;
    int y = 250;

    Juego2 jueguito;
    Image img;
    public Obstaculo3 (Juego2 juego2){
        this.jueguito = juego2;
        ImageIcon icon = new ImageIcon(getClass().getResource("PerroR.png"));
        img = icon.getImage();

    }

    public void mover(){
        if(x>=1200){
            jueguito.puntos++;
            x= 0;
            if(jueguito.puntos ==3 || jueguito.puntos == 6 || jueguito.puntos ==9 || jueguito.puntos ==12){
                inc_x +=+2;
                jueguito.nivel ++;
                
            }


        }else{
            if(colision()){
                if(jueguito.vidas ==0){
                    jueguito.finJuego();
                }else{
                    jueguito.pierdeVida();
                }
            }
            x +=inc_x;

        }

    }

    public boolean colision(){
        return jueguito.personaje2.getBounds().intersects(getBounds());
    }
    
    public void paint( Graphics2D g){
        g.drawImage(img, x, y, ANCHO, ALTO, null);
    }

    public Rectangle getBounds(){
        return new Rectangle(x+5 , y, ANCHO, ALTO);
    }

}

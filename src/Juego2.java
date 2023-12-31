import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Juego2 extends JPanel {
    Teclas personaje2= new Teclas(null);
    Obstaculo3 obstaculo3 = new Obstaculo3(this);
    Fondo fondo1 = new Fondo();
    public boolean juegoFinalizado = false;
    public boolean pierdeVida = false;
    public int puntos = 0;
    public int vidas = 6;
    public int nivel = 1;

    public Juego2(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){

            }
            @Override
            public void keyPressed(KeyEvent e){
                personaje2.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e){

            }
        });
        setFocusable(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(Color.white);
        dibujar(g2);
        dibujarPuntaje( g2);
    }

    public void dibujar (Graphics2D g){
        switch (nivel) {
            case 1: Image img1 = new ImageIcon(getClass().getResource("Ciudad.png")).getImage();
                    g.drawImage(img1, 0, 0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    fondo1.paint(g);
                break;
            case 2: Image img2 = new ImageIcon(getClass().getResource("Ciudad1.png")).getImage();
                    g.drawImage(img2, 0, 0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    fondo1.paint(g);
                break;
            case 3: Image img3 = new ImageIcon(getClass().getResource("Ciudad2.png")).getImage();
                    g.drawImage(img3, 0, 0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    fondo1.paint(g);
                break;
            case 4: Image img4 = new ImageIcon(getClass().getResource("Ciudad3.png")).getImage();
                    g.drawImage(img4, 0, 0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    fondo1.paint(g);
                break;
            case 5: Image img5 = new ImageIcon(getClass().getResource("Ciudad4.png")).getImage();
                    g.drawImage(img5, 0, 0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    fondo1.paint(g);
                break;
            case 6: Image img6 = new ImageIcon(getClass().getResource("Ciudad5.png")).getImage();
                    g.drawImage(img6, 0, 0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    fondo1.paint(g);
                break;
            
        }
        g.setColor(Color.BLACK);
        personaje2.paint(g);
        g.setColor(Color.red);
        obstaculo3.paint(g);
        obstaculo3.mover();
        personaje2.mover();

    }

    public void dibujarPuntaje(Graphics2D g){
        Graphics2D g1= g, g2 = g;
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);
        g.setColor(Color.BLACK);

        g1.drawString("Vidas: " + vidas, 20, 30);
        g1.drawString("Puntaje: " + puntos, 1000, 30);
        g1.drawString("Nivel: " + nivel, 500, 30);

        if(juegoFinalizado){
            g2.setColor(Color.red);
            g1.drawString("!!Has Perdido!!" ,((float)getBounds().getCenterX()/2)+170, 70);
        }
    }

    public void finJuego(){
        juegoFinalizado =true;

    }

    public void pierdeVida(){
        pierdeVida= true;
    }
}

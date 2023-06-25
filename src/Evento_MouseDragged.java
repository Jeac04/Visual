import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Evento_MouseDragged extends JPanel {
    ImageIcon imagen;
    Point puntoInicial = new Point(0, 0);

    public Evento_MouseDragged() {
        imagen = new ImageIcon(getClass().getResource("imagen11.png"));
        MouseAdapter ma = new MouseAdapter() {
            int distanciax, distanciay;
            boolean movimiento = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Rectangle rectangle = new Rectangle(puntoInicial.x, puntoInicial.y, 32, 32);
                if(rectangle.contains(e.getX(), e.getY())){
                distanciax = (int) e.getX() - puntoInicial.x;
                distanciay = (int) e.getY() - puntoInicial.y;
                movimiento = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                distanciax = 0;
                distanciay = 0;
                movimiento = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (movimiento) {
                    puntoInicial.x = e.getX() - distanciax;
                    puntoInicial.y = e.getY() - distanciay;
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }

        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawImage(imagen.getImage(), puntoInicial.x, puntoInicial.y, this);
    }

    public static void main(String[] a) {
        JFrame f = new JFrame("Ejemplo Mouse Dragged");
        f.getContentPane().add(new Evento_MouseDragged());
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(500, 500);
    }
}

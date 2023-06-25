import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Principal2 extends Thread {

    public static int reiniciaJuego = -1;
    public void run()            {
        //JOptionPane.showMessageDialog(null, "Iniciando Juego");
        JFrame ventana = new JFrame("Juego Grafico");
        Juego2 jueguito2 = new Juego2();
        ventana.add(jueguito2);
        ventana.setSize(1200, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
            if(jueguito2.juegoFinalizado){
                reiniciaJuego = JOptionPane.showConfirmDialog(ventana, jueguito2, null, reiniciaJuego);
                if(reiniciaJuego == 0){
                    jueguito2.juegoFinalizado= false;
                    Obstaculo.inc_x = -5;
                    Obstaculo.x = 1200;;
                    jueguito2.puntos= 0;
                    jueguito2.nivel= 1;
                    jueguito2.vidas = 3;
                    reiniciaJuego =-1;
            
                }else if (reiniciaJuego ==1){
                    System.exit(0);
                }

            }else{
                    jueguito2.repaint();
                try{
                    Thread.sleep((10));
                }catch(InterruptedException ex){

                }
                if (jueguito2.pierdeVida){
                    JOptionPane.showMessageDialog(null, "Cuidado!!, Perderas Vida");
                    jueguito2.pierdeVida=false;
                    jueguito2.vidas --;
                    Obstaculo.x = 1200;
                }
            }
        }
    }
}

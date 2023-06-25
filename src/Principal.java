import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Principal extends Thread {

    public static int reiniciaJuego = -1;
    public void run()            {
        //JOptionPane.showMessageDialog(null, "Iniciando Juego");
        JFrame ventana = new JFrame("Juego Grafico");
        Juego jueguito = new Juego();
        ventana.add(jueguito);
        ventana.setSize(1200, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
            if(jueguito.juegoFinalizado){
                reiniciaJuego = JOptionPane.showConfirmDialog(ventana, jueguito, null, reiniciaJuego);
                if(reiniciaJuego == 0){
                    jueguito.juegoFinalizado= false;
                    Obstaculo.inc_x = -5;
                    Obstaculo.x = 1200;
                    jueguito.puntos= 0;
                    jueguito.nivel= 1;
                    jueguito.vidas = 3;
                    reiniciaJuego =-1;
            
                }else if (reiniciaJuego ==1){
                    System.exit(0);
                }

            }else{
                    jueguito.repaint();
                try{
                    Thread.sleep((10));
                }catch(InterruptedException ex){

                }
                if (jueguito.pierdeVida){
                    JOptionPane.showMessageDialog(null, "Cuidado!!, Perderas Vida");
                    jueguito.pierdeVida=false;
                    jueguito.vidas --;
                    Obstaculo.x = 1200;
                }
            }
        }
    }
}

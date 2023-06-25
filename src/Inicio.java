import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Inicio extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    public Inicio() {
        this.setContentPane(fondo);
        this.setResizable(false);
        
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inicioJuego = new javax.swing.JButton();
        opcionesJuego = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inicioJuego.setText("Iniciar");
        inicioJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioJuegoActionPerformed(evt);
            }
        });

        opcionesJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iniciar con Espacio", "Iniciar con Teclas", "Iniciar con Mouse dragged", "Iniciar con Mouse Moved" }));
        opcionesJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesJuegoActionPerformed(evt);
            }
        });

        jLabel1.setText("Opciones de inicio del juego");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(inicioJuego)
                        .addGap(57, 57, 57)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(opcionesJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(opcionesJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(inicioJuego)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }

    private void inicioJuegoActionPerformed(java.awt.event.ActionEvent evt) {
        String opcionText =  opcionesJuego.getSelectedItem().toString();
        int opcionInt =  opcionesJuego.getSelectedIndex();
        System.out.println(opcionText);
        System.out.println(opcionInt);
        this.dispose();
        if (opcionInt == 0) {
            JFrame ventana = new  JFrame("Juego Grafico");
            Principal principal= new Principal();
            principal.start();
            ventana.setSize(1200,400);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (opcionInt == 1) {
           ///////////
            JFrame ventana1= new JFrame("Juego de Teclas");
            Principal2 principal2= new Principal2();
            principal2.start();
            ventana1.setSize(1200,400);
            ventana1.setLocationRelativeTo(null);
            ventana1.setVisible(true);                    
            ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (opcionInt == 2) {
            JFrame ventana2= new JFrame("MouseDragged");
            Evento_MouseDragged evento= new Evento_MouseDragged();
            ventana2.setSize(400,400);
            ventana2.setLocationRelativeTo(null);
            ventana2.setVisible(true);
            ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana2.add(evento);
        } else if (opcionInt == 3) {
            JFrame ventana3= new JFrame("Mouse");
            Mouse_Moved mouse= new Mouse_Moved();
            ventana3.setSize(400,400);
            ventana3.setLocationRelativeTo(null);
            ventana3.setVisible(true);
            ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana3.add(mouse);
         
        }
    }

    private void opcionesJuegoActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
                
            }
        });
    }
    class FondoPanel extends JPanel{
        private Image imagen;
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("imagen2.jpg")).getImage();
            g.drawImage(imagen,0,0 ,getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
    
    private javax.swing.JButton inicioJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> opcionesJuego;
   
}

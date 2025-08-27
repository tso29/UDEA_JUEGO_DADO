import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;

public class FrmJuego extends JFrame {

    //variables globales
    private Dado dado1, dado2;
    private Random r;
    private JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas;
    private int lanzamientos, cenas;
    
    // metodo constructor
    public FrmJuego() {
        setTitle("Juego de Dados");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblDado1 = new JLabel();
        String archivoImagen="imagenes/3.jpg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(archivoImagen));
        lblDado1.setIcon(imgDado);
        lblDado1.setBounds(10, 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        getContentPane().add(lblDado1);

        lblDado2 = new JLabel();
        lblDado2.setIcon(imgDado);
        lblDado2.setBounds(20 + imgDado.getIconWidth(), 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        getContentPane().add(lblDado2);

        JLabel lblTituloLanzamientos = new JLabel("Lanzamientos:");
        lblTituloLanzamientos.setBounds(30 + 2 * imgDado.getIconWidth(), 10, 100, 25);
        getContentPane().add(lblTituloLanzamientos);

        JLabel lblTituloCenas = new JLabel("Cenas:");
        lblTituloCenas.setBounds(140 + 2 * imgDado.getIconWidth(), 10, 100, 25);
        getContentPane().add(lblTituloCenas);

        lblLanzamientos = new JLabel("0");
        lblLanzamientos.setBounds(30 + 2 * imgDado.getIconWidth(), 40, 100, 100);
        lblLanzamientos.setFont(new Font("Tahoma", 1, 72));
        lblLanzamientos.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLanzamientos.setBackground(new Color(0, 0, 0));
        lblLanzamientos.setForeground(new Color(60, 255, 0));
        lblLanzamientos.setOpaque(true);
        getContentPane().add(lblLanzamientos);

        lblCenas = new JLabel("0");
        lblCenas.setBounds(140+2*imgDado.getIconWidth(), 40, 100, 100);
        lblCenas.setFont(new Font("Tahoma", 1, 72));
        lblCenas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCenas.setBackground(new Color(0, 0, 0));
        lblCenas.setForeground(new Color(60, 255, 0));
        lblCenas.setOpaque(true);
        getContentPane().add(lblCenas);

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(10, 10 + imgDado.getIconWidth(), 100, 25);
        getContentPane().add(btnIniciar);

        JButton btnLanzar = new JButton("Lanzar");
        btnLanzar.setBounds(10, 40 + imgDado.getIconWidth(), 100, 25);
        getContentPane().add(btnLanzar);

        btnIniciar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarLanzamienots();
            }
        });

        btnLanzar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                lanzar();
            }
        });

        // crear las nstancias de los dados y el generadpr de numeros aleatorios
        dado1 = new Dado();
        dado2 = new Dado();
        r = new Random();


    }

    private void iniciarLanzamienots() {
        lanzamientos = 0;
        cenas=0;
        lblLanzamientos.setText(String.valueOf(lanzamientos));
        lblCenas.setText(String.valueOf(cenas));
    }

    private void lanzar() {

        // lanzar dados
        dado1.lanzar(r);
        dado2.lanzar(r);

        // mostrar dados
        dado1.mostrar(lblDado1);
        dado2.mostrar(lblDado2);

        // actualizar los contadores
        lanzamientos++;
        lblLanzamientos.setText(String.valueOf(lanzamientos));
        
        if(dado1.getCara() + dado2.getCara() >= 11) {
            cenas++;
            lblCenas.setText(String.valueOf(cenas));
        }

    }
}
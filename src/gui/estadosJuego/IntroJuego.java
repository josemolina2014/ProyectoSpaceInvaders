package gui.estadosJuego;

import gui.SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class IntroJuego implements EstadoJuego {
    private JPanel panelImagenInicial;
    private SpaceInvaders framePrincipal;



    public IntroJuego(SpaceInvaders framePrincipal) {
        System.out.println("IntroJuego " );
        this.framePrincipal=framePrincipal;

        panelImagenInicial = new JPanel();
        // Contenedor gráfico
        panelImagenInicial.setLayout(new BorderLayout());

        // Imagen de fondo
        ImageIcon icono = new ImageIcon("./data/imagenes/menuInicio.gif");
        JLabel labImagen = new JLabel(icono);
        Color fondo = new Color(21, 22, 25);
        panelImagenInicial.setBackground(fondo);

        // Título del juego: "SPACE INVADERS"
        JPanel titulo = new JPanel(new FlowLayout());
        JLabel space = new JLabel("Space ");
        space.setFont(new Font("ArcadeClassic", Font.PLAIN, 82));
        space.setForeground(Color.WHITE);
        JLabel invaders = new JLabel("Invaders");
        invaders.setFont(new Font("ArcadeClassic", Font.PLAIN, 82));
        invaders.setForeground(Color.WHITE);
        titulo.setBackground(fondo);
        titulo.add(space);
        titulo.add(invaders);

        // Texto instructivo: "PRESIONE LA TECLA ESPACIO"
        JPanel flow = new JPanel(new FlowLayout());
        JLabel presione = new JLabel("PRESIONE ");
        presione.setForeground(Color.BLUE);
        JLabel la = new JLabel("LA ");
        la.setForeground(Color.RED);
        JLabel tecla = new JLabel("TECLA ");
        tecla.setForeground(Color.GREEN);
        JLabel espacio = new JLabel("ENTER ");
        espacio.setForeground(Color.YELLOW);
        presione.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        la.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        tecla.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        espacio.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        flow.setBackground(fondo);
        flow.add(presione);
        flow.add(la);
        flow.add(tecla);
        flow.add(espacio);

        // Agrega los tres elementos al panel: imagen de fondo, título del juego
        // y la intstrucción.
        panelImagenInicial.add(labImagen, BorderLayout.CENTER);
        panelImagenInicial.add(titulo, BorderLayout.NORTH);
        panelImagenInicial.add(flow, BorderLayout.SOUTH);

    }

    public JPanel getMainPanel(){
        return panelImagenInicial;
    }

    public void cambiarEstadoInicial() {
        framePrincipal.setCurrentState(new MenuPrincipal(framePrincipal));
    }

    @Override
    public KeyListener getKeyListener() {
        return new IntroJuegoKeyListener();
    }

    public class IntroJuegoKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("IntroJuegoKeyListener.keyTyped");
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
                cambiarEstadoInicial();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
                cambiarEstadoInicial();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }
}

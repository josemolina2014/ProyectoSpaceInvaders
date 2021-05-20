package gui.estadosJuego;

import gui.SpaceInvaders;
import util.Constantes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class PerdidaPartida extends JPanel implements EstadoJuego {


    private JButton botonNo;
    private JButton botonSI;
    private JLabel labelGanaste;
    private JLabel labelVolverAJugar;

    private SpaceInvaders framePrincipal;

    public PerdidaPartida(SpaceInvaders framePrincipal)
    {
        this.framePrincipal = framePrincipal;

        setPreferredSize(Constantes.TAMANO_PANTALLA);
        setLayout(null);
        setOpaque(false);

        labelGanaste = new JLabel();
        labelGanaste.setText("Perdiste");
        labelGanaste.setForeground(Color.WHITE);
        labelGanaste.setFont(new Font("ArcadeClassic", Font.PLAIN, 74));
        labelGanaste.setBounds(150, 150, 400, 60);
        add(labelGanaste);


        labelVolverAJugar = new JLabel();
        labelVolverAJugar.setText("¿Desea Volver a Jugar?");
        labelVolverAJugar.setForeground(Color.WHITE);
        labelVolverAJugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // labelVolverAJugar.setFont(new Font("ArcadeClassic", Font.PLAIN, 25));
        labelVolverAJugar.setBounds(120, 300, 350, 30);
        add(labelVolverAJugar);



        botonSI = new JButton();
        botonSI.setText("SI");
        botonSI.setBorderPainted(false);
        botonSI.setBounds(140, 350, 100, 23);
        botonSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSIActionPerformed(evt);
            }
        });
        add(botonSI);

        botonNo = new JButton();
        botonNo.setText("No");
        botonNo.setBounds(320, 350, 100, 23);
        botonNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNoActionPerformed(evt);
            }
        });
        add(botonNo);
    }

    private void botonSIActionPerformed(java.awt.event.ActionEvent evt) {
        cambiarEstadoJuego();
    }

    private void botonNoActionPerformed(java.awt.event.ActionEvent evt) {
        cambiarEstadoInicial();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Pinta la imagen de fondo
        ImageIcon fondo = new ImageIcon("./data/imagenes/menu2.png");
        g2.drawImage(fondo.getImage(), 0, 0, getSize().width, getSize().height, null);

    }

    public void cambiarEstadoInicial() {
        framePrincipal.setCurrentState(new MenuPrincipal(framePrincipal));
    }

    public void cambiarEstadoJuego() {
        framePrincipal.getPartidaSeleccionada().volverAJugar();
        framePrincipal.setCurrentState(new Juego(framePrincipal));
    }

    @Override
    public JPanel getMainPanel() {
        return this;
    }

    @Override
    public KeyListener getKeyListener() {
        return null;
    }
}

package gui.estadosJuego;

import gui.SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Menu extends JPanel implements EstadoJuego {
    private SpaceInvaders framePrincipal;

    public Menu(SpaceInvaders framePrincipal) {
        this.framePrincipal = framePrincipal;
        // Establece el tamaño, la contenedora de tamaño y le quita el fondo que
        // trae por defecto.
        setPreferredSize(new Dimension(640, 480));
        setLayout(null);
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // Pinta la imagen de fondo
        ImageIcon fondo = new ImageIcon("./data/imagenes/menu2.png");
        g2.drawImage(fondo.getImage(), 0, 0, getSize().width, getSize().height, null);

        // Dibuja el nickname, nombre y monedas del jugador actual del juego.
        g2.setColor(Color.GREEN);
        g2.setFont(new Font("ArcadeClassic", Font.PLAIN, 24));
        g2.drawString("NICKNAME", 30, 40);
        g2.drawString("JUGADOR", 170, 40);

        g2.setColor(Color.RED);
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

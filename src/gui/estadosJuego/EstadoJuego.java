package gui.estadosJuego;

import javax.swing.*;
import java.awt.event.KeyListener;

public interface EstadoJuego {

    public JPanel getMainPanel();
    public KeyListener getKeyListener();
}

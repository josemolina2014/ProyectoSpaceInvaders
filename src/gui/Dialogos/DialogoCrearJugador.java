package gui.Dialogos;

import controlador.ControladorJugador;
import excepciones.NicknameYaExisteException;
import gui.SpaceInvaders;
import modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DialogoCrearJugador extends JDialog implements ActionListener {


    /***
     *
     */
    private final static String ACEPTAR = "Aceptar";

    /**
     *
     */
    private final static String CANCELAR = "Cancelar";

    private JPanel auxiliar;
    /**
     *
     */
    private JLabel labNombre;

    /**
     *
     */
    private JLabel labNickname;

    /**
     *
     */
    private JTextField txtNombre;

    /**
     *
     */
    private JTextField txtNickame;

    /**
     *
     */
    private JButton butBotonAceptar;

    /**
     *
     */
    private JButton butBotonCancelar;

    private SpaceInvaders menuPrincipal;
    private ControladorJugador controladorJugador;

    public DialogoCrearJugador(SpaceInvaders menuPrincipal) {

        this.menuPrincipal = menuPrincipal;
        controladorJugador = new ControladorJugador();
        setLayout(null);

        auxiliar = new JPanel();
        auxiliar.setLayout(null);

        labNombre = new JLabel("NOMBRE DEL JUGADOR");
        labNombre.setForeground(Color.RED);
        labNombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 33));
        labNombre.setBounds(10, 60, 350, 20);

        txtNombre = new JTextField();
        txtNombre.setBackground(Color.orange);
        txtNombre.setBounds(10, 85, 205, 25);
        txtNombre.setForeground(Color.BLUE);
        txtNombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 25));

        labNickname = new JLabel("NICKNAME");
        labNickname.setForeground(Color.red);
        labNickname.setFont(new Font("ArcadeClassic", Font.PLAIN, 33));
        labNickname.setBounds(10, 150, 260, 20);

        txtNickame = new JTextField();
        txtNickame.setBackground(Color.orange);
        txtNickame.setBounds(10, 180, 150, 25);
        txtNickame.setForeground(Color.BLUE);
        txtNickame.setFont(new Font("ArcadeClassic", Font.PLAIN, 25));

        JLabel imagen = new JLabel();
        ImageIcon icono = new ImageIcon("./data/imagenes/fondAgJ.jpg");
        imagen.setIcon(icono);
        imagen.setBounds(0, 0, icono.getIconWidth(), icono.getIconHeight());

        butBotonAceptar = new JButton(ACEPTAR);
        butBotonAceptar.setActionCommand(ACEPTAR);
        butBotonAceptar.addActionListener(this);
        butBotonAceptar.setBounds(10, 210, 130, 25);
        butBotonAceptar.setBackground(Color.BLACK);
        butBotonAceptar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
        butBotonAceptar.setForeground(Color.YELLOW);

        butBotonCancelar = new JButton(CANCELAR);
        butBotonCancelar.setActionCommand(CANCELAR);
        butBotonCancelar.addActionListener(this);
        butBotonCancelar.setBounds(10, 350, 130, 25);
        butBotonCancelar.setBackground(Color.BLACK);
        butBotonCancelar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
        butBotonCancelar.setForeground(Color.green);

        auxiliar.setSize(icono.getIconWidth(), icono.getIconHeight());
        auxiliar.add(labNombre);
        auxiliar.add(txtNombre);
        auxiliar.add(labNickname);
        auxiliar.add(txtNickame);
        auxiliar.add(butBotonAceptar);
        auxiliar.add(butBotonCancelar);
        auxiliar.add(imagen);

        setTitle("Crear Jugador");
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        if (comando.equals(CANCELAR)) {
            this.dispose();
        } else if (comando.equals(ACEPTAR)) {
            if (txtNombre.getText() == null || txtNombre.getText().equals("") || txtNickame.getText() == null
                    || txtNickame.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre y un nickname válido",
                        "Error al crear el jugador", JOptionPane.ERROR_MESSAGE);

            else if (txtNickame.getText().length() >= 5) {
                JOptionPane.showMessageDialog(this, "El nickname debe contener máximo 5 caracteres",
                        "Error al asignar el nickname", JOptionPane.ERROR_MESSAGE);
            } else {
                reqAgregarJugador(txtNombre.getText(), txtNickame.getText());
                this.dispose();
            }
        }

    }

    public void reqAgregarJugador(String nombre, String nickname) {
        try {

            Jugador jugador = controladorJugador.agregarJugador(nombre, nickname);
            menuPrincipal.getCurrentState().getMainPanel().updateUI();
            menuPrincipal.getCurrentState().getMainPanel().repaint();
            menuPrincipal.setJugadorSeleccionado(jugador);

        } catch (NicknameYaExisteException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al agregar el jugador",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     *
     */
    public void mostrar() {
        setSize(400, 400);
        add(auxiliar);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

}

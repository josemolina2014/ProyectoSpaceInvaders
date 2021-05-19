package gui.Dialogos;

import controlador.ControladorPartida;
import gui.SpaceInvaders;
import gui.estadosJuego.Juego;
import modelo.Partida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoCrearPartida extends JDialog implements ActionListener {

	// -----------------------------------------------------------------
	// ---------------------------Constantes----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public final static String ACEPTAR = "Aceptar";

	/**
	 * 
	 */
	public final static String CANCELAR = "Cancelar";

	// -----------------------------------------------------------------
	// --------------------------Asociaciones---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private SpaceInvaders menuPrincipal;
	private ControladorPartida controladorPartida;

	/**
	 * 
	 */
	JPanel auxiliar;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	JLabel nombre;

	/**
	 * 
	 */
	JLabel nombre1;

	/**
	 * 
	 */
	JTextField txtNombre;

	/**
	 * 
	 */
	JButton butBotonAceptar;

	/**
	 * 
	 */
	JButton butBotonCancelar;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param interfaz
	 */
	public DialogoCrearPartida(SpaceInvaders interfaz) {

		this.menuPrincipal = interfaz;
		controladorPartida= new ControladorPartida();

		setLayout(null);

		auxiliar = new JPanel();
		auxiliar.setLayout(null);

		nombre = new JLabel("Ingrese el nombre    de");
		nombre.setForeground(Color.YELLOW);
		nombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 33));
		nombre.setBounds(10, 30, 350, 20);

		nombre1 = new JLabel("la    partida");
		nombre1.setForeground(Color.YELLOW);
		nombre1.setFont(new Font("ArcadeClassic", Font.PLAIN, 33));
		nombre1.setBounds(10, 55, 240, 20);

		txtNombre = new JTextField();
		txtNombre.setBackground(Color.orange);
		txtNombre.setBounds(10, 150, 210, 25);
		txtNombre.setForeground(Color.BLUE);
		txtNombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 25));

		JLabel imagen = new JLabel();
		ImageIcon icono = new ImageIcon("./data/imagenes/fondoAP.jpg");
		imagen.setIcon(icono);
		imagen.setBounds(0, 0, icono.getIconWidth(), icono.getIconHeight());

		butBotonAceptar = new JButton(ACEPTAR);
		butBotonAceptar.setActionCommand(ACEPTAR);
		butBotonAceptar.addActionListener(this);
		butBotonAceptar.setBounds(10, 200, 130, 25);
		butBotonAceptar.setBackground(Color.BLACK);
		butBotonAceptar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonAceptar.setForeground(Color.YELLOW);

		butBotonCancelar = new JButton(CANCELAR);
		butBotonCancelar.setActionCommand(CANCELAR);
		butBotonCancelar.addActionListener(this);
		butBotonCancelar.setBounds(200, 200, 130, 25);
		butBotonCancelar.setBackground(Color.BLACK);
		butBotonCancelar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonCancelar.setForeground(Color.green);

		auxiliar.setSize(icono.getIconWidth(), icono.getIconHeight());
		auxiliar.add(nombre);
		auxiliar.add(nombre1);
		auxiliar.add(txtNombre);
		auxiliar.add(butBotonAceptar);
		auxiliar.add(butBotonCancelar);
		auxiliar.add(imagen);

		setTitle("Crear Partida");
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	// -----------------------------------------------------------------
	// ----------------------Manejador de eventos-----------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		if (comando.equals(CANCELAR))
			this.dispose();
		else if (comando.equals(ACEPTAR)) {
			if (txtNombre.getText().equals(null) || txtNombre.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre v�lido", "Error al crear el jugador",
						JOptionPane.ERROR_MESSAGE);
			else {

				Partida partida =controladorPartida.inicializarPartida(menuPrincipal.getJugadorSeleccionado(),txtNombre.getText());
				menuPrincipal.setPartidaSeleccionada(partida);
				menuPrincipal.setCurrentState(new Juego(menuPrincipal));

				this.dispose();
			}
		}

	}

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	public void mostrar() {
		setSize(400, 225);
		add(auxiliar);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * 
	 * @return
	 */
	public String darNombre() {
		return txtNombre.getText();
	}
}

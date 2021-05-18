package gui.estadosJuego;

import gui.Dialogos.*;
import gui.SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Component.RIGHT_ALIGNMENT;

public class MenuPrincipal  implements EstadoJuego, ActionListener {

    public static final Font ARCADE_FONT_40 = new Font("ArcadeClassic", Font.PLAIN, 40);
    public static final Font ARCADE_FONT_74 = new Font("ArcadeClassic", Font.PLAIN, 74);


    private JPanel panelMenuPrincipal;
    private SpaceInvaders framePrincipal;


    private final static String CREAR_JUGADOR = "CREAR JUGADOR";
    private final static String SELECCIONAR_JUGADOR = "SELECCIONAR JUGADOR";
    private final static String CREAR_PARTIDA = "CREAR PARTIDA";
    private final static String SELECCIONAR_PARTIDA = "SELECCIONAR PARTIDA";
    private final static String INTRUCCIONES = "INSTRUCCIONES";

    /**
     *
     */
    DialogoCrearJugador dialogoCrearJugador;

    /**
     *
     */
    DialogoSeleccionarJugador dialogoSeleccionarJugador;

    /**
     *
     */
    DialogoCrearPartida dialogoCrearPartida;

    /**
     *
     */
    DialogoSeleccionarPartida dialogoSeleccionarPartida;

    /**
     *
     */
    DialogoInstrucciones dialogoInstrucciones;

    /**
     *
     */
    DialogoMejoresPuntajes dialogoMejoresPuntajes;

    /**
     *
     */
    JPopupMenu popMenuJugar;

    /**
     *
     */
    JMenuItem menuCrearPartida;

    /**
     *
     */
    JMenuItem menuCargarPartida;

    /**
     *
     */
    JPopupMenu popMenuJugador;

    /**
     *
     */
    JMenuItem menuNuevoJugador;

    /**
     *
     */
    JMenuItem menuSeleccionarJugador;

    /**
     *
     */
    JLabel labOpenMenuJugar;

    /**
     *
     */
    JLabel labOpenMenuJugador;


    JLabel labLoginRapido;

    /**
     *
     */
    JLabel labMejoresPuntajes;

    /**
     *
     */
    JLabel labInstrucciones;

    JLabel labSalir;



    public MenuPrincipal(SpaceInvaders framePrincipal) {

        this.framePrincipal = framePrincipal;

        inicializarPanelMenuPrincipal();


        // Título del juego: "SPACE INVADERS"
        JLabel space = new JLabel("SPACE INVADERS");
        space.setForeground(Color.WHITE);
        space.setFont(ARCADE_FONT_74);
        space.setBounds(5, 75, 560, 80);
        panelMenuPrincipal.add(space);

        // Inicializa los 4 diálogos que se puede ver en el menú
        dialogoCrearJugador = new DialogoCrearJugador(framePrincipal);
        dialogoCrearPartida = new DialogoCrearPartida(framePrincipal);
        dialogoSeleccionarJugador = new DialogoSeleccionarJugador(framePrincipal);
        dialogoSeleccionarPartida = new DialogoSeleccionarPartida(framePrincipal);
        dialogoInstrucciones = new DialogoInstrucciones(framePrincipal);
        dialogoMejoresPuntajes = new DialogoMejoresPuntajes(framePrincipal);

        // Popup Menu Jugar
        initOpcionesMenuJugar();
        // Agregar al Menu Jugar los Item's
        popMenuJugar.add(menuCrearPartida);
        popMenuJugar.add(menuCargarPartida);

        // Popup Menu Jugador
        popMenuJugador = new JPopupMenu();

        // Item1 de Menu Jugador
        menuNuevoJugador = new JMenuItem("NUEVO JUGADOR");
        menuNuevoJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

        // Item2 de Menu Jugador
        menuSeleccionarJugador = new JMenuItem("SELECCIONAR JUGADOR");
        menuSeleccionarJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

        // Añadir los action listener a los Item's de Menu Jugador
        menuNuevoJugador.addActionListener(this);
        menuNuevoJugador.setActionCommand(CREAR_JUGADOR);
        menuSeleccionarJugador.addActionListener(this);
        menuSeleccionarJugador.setActionCommand(SELECCIONAR_JUGADOR);

        // Agregar al Menu Jugar los Item's
        popMenuJugador.add(menuNuevoJugador);
        popMenuJugador.add(menuSeleccionarJugador);




        // Boton Open Menu Jugar
        labOpenMenuJugar = new JLabel("JUGAR");
        labOpenMenuJugar.setBounds(10, 240, 110, 23);
        labOpenMenuJugar.setFont(ARCADE_FONT_40);
        labOpenMenuJugar.setForeground(Color.WHITE);
        labOpenMenuJugar.setAlignmentX(RIGHT_ALIGNMENT);
        labOpenMenuJugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popMenuJugar.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        panelMenuPrincipal.add(labOpenMenuJugar);

        // Boton Open Menu Jugador
        labOpenMenuJugador = new JLabel("JUGADOR");
        labOpenMenuJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 40));
        labOpenMenuJugador.setBounds(10, 270, 190, 23);
        labOpenMenuJugador.setForeground(Color.WHITE);
        labOpenMenuJugador.setAlignmentX(RIGHT_ALIGNMENT);
        labOpenMenuJugador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popMenuJugador.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        panelMenuPrincipal.add(labOpenMenuJugador);

        // JLabel de los mejores puntajes
        labMejoresPuntajes = new JLabel("MEJORES PUNTAJES");
        labMejoresPuntajes.setForeground(Color.WHITE);
        labMejoresPuntajes.setFont(ARCADE_FONT_40);
        labMejoresPuntajes.setBounds(10, 300, 340, 23);
        panelMenuPrincipal.add(labMejoresPuntajes);
        labMejoresPuntajes.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dialogoMejoresPuntajes.mostrar();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });





        // JLabel con las intrucciones
        labInstrucciones = new JLabel("INSTRUCCIONES");
        labInstrucciones.setForeground(Color.WHITE);
        labInstrucciones.setFont(ARCADE_FONT_40);
        labInstrucciones.setBounds(10, 330, 300, 23);
        labInstrucciones.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                dialogoInstrucciones.mostrar();
            }
        });
        panelMenuPrincipal.add(labInstrucciones);


        // JLabel de SALIR
        labSalir = new JLabel("SALIR");
        labSalir.setForeground(Color.WHITE);
        labSalir.setFont(ARCADE_FONT_40);
        labSalir.setBounds(10, 360, 300, 23);
        labSalir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?", "Cerrar?", JOptionPane.YES_NO_OPTION);
                if ( res == 0 ) {
                   // framePrincipal.getjFrame().setVisible(false);
                    framePrincipal.getjFrame().dispose();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        panelMenuPrincipal.add(labSalir);
    }

    private void inicializarPanelMenuPrincipal() {
        panelMenuPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                graficar(g);
            }
        };
        // Establece el tamaño, la contenedora de tamaño y le quita el fondo que
        // trae por defecto.
        panelMenuPrincipal.setPreferredSize(new Dimension(SpaceInvaders.ANCHO, SpaceInvaders.ALTO));
        panelMenuPrincipal.setLayout(null);
        panelMenuPrincipal.setOpaque(false);
    }

    private void initOpcionesMenuJugar() {
        popMenuJugar = new JPopupMenu();
        // Item1 de Menu Jugar
        menuCrearPartida = new JMenuItem("CREAR PARTIDA");
        menuCrearPartida.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

        // Item2 de Menu Jugar
        menuCargarPartida = new JMenuItem("CARGAR PARTIDA");
        menuCargarPartida.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

        // Añadir los action listener a los item's de Menu Jugar
        menuCrearPartida.addActionListener(this);
        menuCrearPartida.setActionCommand(CREAR_PARTIDA);
        menuCargarPartida.addActionListener(this);
        menuCargarPartida.setActionCommand(SELECCIONAR_PARTIDA);
    }


    public void graficar(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        // Pinta la imagen de fondo
        ImageIcon fondo = new ImageIcon("./data/imagenes/menu2.png");
        g2.drawImage(fondo.getImage(), 0, 0, SpaceInvaders.ANCHO, SpaceInvaders.ALTO, null);

        // Dibuja el nickname, nombre y monedas del jugador actual del juego.
        g2.setColor(Color.GREEN);
        g2.setFont(new Font("ArcadeClassic", Font.PLAIN, 24));
        g2.drawString("NICKNAME", 30, 40);
        g2.drawString("JUGADOR", 170, 40);

        g2.setColor(Color.RED);

        if(framePrincipal.getJugadorSeleccionado()!=null){
            g2.drawString(framePrincipal.getJugadorSeleccionado().getNickname(), 30, 60);

            if (framePrincipal.getJugadorSeleccionado().getNombre().length() <= 13)
                g2.drawString(framePrincipal.getJugadorSeleccionado().getNombre(), 170, 60);
            else
                g2.drawString(framePrincipal.getJugadorSeleccionado().getNombre().substring(0, 13), 170, 60);

        }

    }

    private void cambiarEstado(EstadoJuego estado)
    {
        this.framePrincipal.setCurrentState(estado);
    }

    @Override
    public JPanel getMainPanel() {
        return panelMenuPrincipal;
    }



    @Override
    public KeyListener getKeyListener() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        switch (comando) {
            case CREAR_JUGADOR:
                dialogoCrearJugador.mostrar();
                break;
            case SELECCIONAR_JUGADOR:
                dialogoSeleccionarJugador.mostrar();
                break;
            case CREAR_PARTIDA:
                if (framePrincipal.getJugadorSeleccionado() != null)
                    dialogoCrearPartida.mostrar();
                else
                    JOptionPane.showMessageDialog(null, "Por favor crear o seleccionar un jugador",
                            "Error al iniciar partida", JOptionPane.ERROR_MESSAGE);
                break;
            case SELECCIONAR_PARTIDA:
                if (framePrincipal.getPartidaSeleccionada() != null) {
                    dialogoSeleccionarPartida.mostrar();
                } else
                    JOptionPane.showMessageDialog(null, "Por favor crear o seleccionar un jugador",
                            "Error al seleccionar la partida", JOptionPane.ERROR_MESSAGE);

                break;
        }

    }
}

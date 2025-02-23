package sistema.estudiante;


import java.awt.event.ActionListener;
import javax.swing.*;



public class menu {

	public static void menuonline() {
        // Crear la ventana principal
        JFrame frame = new JFrame("Sistema de Gestión Académica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        JLabel label = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        frame.getContentPane().add(label);

        frame.setVisible(true);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Salida del menú "Salir"
        JMenu menuFile = new JMenu("Menu");
        JMenuItem exitMenuItem = new JMenuItem("Salir");
        exitMenuItem.addActionListener(e -> frame.dispose()); // Cerrar la ventana
        menuFile.add(exitMenuItem);
        menuBar.add(menuFile);

        // Crear y añadir los menús principales
        String[] menuNames = {"Profesores", "Estudiante", "Matrícula", "Materias", "Evaluaciones"};
        for (String name : menuNames) {
            menuBar.add(createMenu(name, frame));
        }

        // Configurar la barra de menú en el frame
        frame.setJMenuBar(menuBar);

        // Mostrar la ventana
        frame.setVisible(true);
    }

    // Método para crear cada menú con submenús
    private static JMenu createMenu(String title, JFrame parentFrame) {
        JMenu menu = new JMenu(title);
        JMenuItem menuItemAlta = new JMenuItem("Alta");
        JMenuItem menuItemModificacion = new JMenuItem("Modificación");
        JMenuItem menuItemBaja = new JMenuItem("Baja");

        // Añadir acciones específicas según el título del menú
        switch (title) {
            case "Profesores":
                menuItemAlta.addActionListener(e -> new AltaProfesor());
                menuItemModificacion.addActionListener(e -> new ModificarProfesor());
                menuItemBaja.addActionListener(e -> new BajaProfesor());
                break;
            case "Estudiante":
                menuItemAlta.addActionListener(e -> new Estudiante());
                menuItemModificacion.addActionListener(e -> new ModificarEstudiante());
                menuItemBaja.addActionListener(e -> new BajaEstudiante());
                break;
            case "Matrícula":
                menuItemAlta.addActionListener(e -> new AltaMatricula());
                menuItemModificacion.addActionListener(e -> new ModificarMatricula());
                menuItemBaja.addActionListener(e -> new BajaMatricula());
                break;
            case "Materias":
                menuItemAlta.addActionListener(e -> new AltaMateria());
                menuItemModificacion.addActionListener(e -> new ModificarMateria());
                menuItemBaja.addActionListener(e -> new BajaMateria());
                break;
            case "Evaluaciones":
                menuItemAlta.addActionListener(e -> new AltaEvaluacion());
                menuItemModificacion.addActionListener(e -> new ModificarEvaluacion());
                menuItemBaja.addActionListener(e -> new BajaEvaluacion());
                break;
            default:
                // Añadir acción de ejemplo al hacer clic en los ítems
                ActionListener actionListener = e -> JOptionPane.showMessageDialog(null, "Acción seleccionada: " + e.getActionCommand() + " en " + title);
                menuItemAlta.addActionListener(actionListener);
                menuItemModificacion.addActionListener(actionListener);
                menuItemBaja.addActionListener(actionListener);
                break;
        }

        menu.add(menuItemAlta);
        menu.add(menuItemModificacion);
        menu.add(menuItemBaja);

        return menu;
    }

	
	
}

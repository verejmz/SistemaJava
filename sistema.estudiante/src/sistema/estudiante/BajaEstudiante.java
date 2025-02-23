package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajaEstudiante {
    private JFrame frame;
    private JTextField buscarIdEstudianteField;
    private JButton buscarButton, eliminarButton, cancelButton;

    public BajaEstudiante() {
        // Crear la ventana
        frame = new JFrame("Baja de Estudiante");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para buscar por ID de Estudiante
        frame.add(new JLabel("Buscar por ID de Estudiante:"));
        buscarIdEstudianteField = new JTextField(20);
        frame.add(buscarIdEstudianteField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEstudiante();
            }
        });
        frame.add(buscarButton);
        frame.add(new JLabel()); // Placeholder para alinear el botón correctamente

        // Botón de eliminar estudiante
        eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarEstudiante();
            }
        });
        eliminarButton.setEnabled(false); // Se habilitará tras encontrar un estudiante
        frame.add(eliminarButton);

        // Botón de cancelar
        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar la ventana
            }
        });
        frame.add(cancelButton);

        // Mostrar la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }

    private void buscarEstudiante() {
        String idEstudiante = buscarIdEstudianteField.getText().trim();
        if (idEstudiante.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "El campo ID no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Aquí se agrega la lógica para guardar los datos en la base de datos
        boolean estudianteExiste = buscarEstudianteEnBD(idEstudiante); // Simulación
        if (estudianteExiste) {
            JOptionPane.showMessageDialog(frame, "Estudiante encontrado: " + idEstudiante, "Información", JOptionPane.INFORMATION_MESSAGE);
            eliminarButton.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Estudiante no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            eliminarButton.setEnabled(false);
        }
    }

    private void eliminarEstudiante() {
        String idEstudiante = buscarIdEstudianteField.getText();
        // Aquí puedes añadir la lógica para eliminar los datos en la base de datos
        System.out.println("Eliminando el estudiante con ID: " + idEstudiante);
        JOptionPane.showMessageDialog(frame, "Estudiante eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose(); // Cerrar la ventana después de eliminar
    }

    // Simulación de búsqueda en base de datos
    private boolean buscarEstudianteEnBD(String idEstudiante) {
        // Simulación: Asumir que todos los IDs no están vacíos y simular que existe
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BajaEstudiante();
            }
        });
    }
}

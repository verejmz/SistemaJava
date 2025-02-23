package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BajaMatricula {
    private JFrame frame;
    private JTextField buscarIdMatriculaField;
    private JButton buscarButton, eliminarButton, cancelButton;

    public BajaMatricula() {
        // Crear la ventana
        frame = new JFrame("Baja de Matrícula");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para buscar por ID de Matrícula
        frame.add(new JLabel("Buscar por ID de Matrícula:"));
        buscarIdMatriculaField = new JTextField(20);
        frame.add(buscarIdMatriculaField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarMatricula();
            }
        });
        frame.add(buscarButton);
        frame.add(new JLabel()); // Placeholder para alinear el botón correctamente

        // Botón de eliminar matrícula
        eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarMatricula();
            }
        });
        eliminarButton.setEnabled(false); // Se habilitará tras encontrar una matrícula
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

    private void buscarMatricula() {
        // Simula la búsqueda de una matrícula en la base de datos
        String idMatricula = buscarIdMatriculaField.getText();
        System.out.println("Buscando la matrícula con ID: " + idMatricula);
        // Aquí deberías implementar la lógica para buscar la matrícula en tu base de datos

        // Simulación de encontrar una matrícula
        if (!idMatricula.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Matrícula encontrada: " + idMatricula, "Información", JOptionPane.INFORMATION_MESSAGE);
            eliminarButton.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(frame, "No se encontró la matrícula", "Error", JOptionPane.ERROR_MESSAGE);
            eliminarButton.setEnabled(false);
        }
    }

    private void eliminarMatricula() {
        // Aquí falta añadir la lógica para eliminar los datos en la base de datos
        String idMatricula = buscarIdMatriculaField.getText();
        System.out.println("Eliminando la matrícula con ID: " + idMatricula);
        JOptionPane.showMessageDialog(frame, "Matrícula eliminada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose(); // Cerrar la ventana después de eliminar
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BajaMatricula();
            }
        });
    }
}

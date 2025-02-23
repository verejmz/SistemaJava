package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajaEvaluacion {
    private JFrame frame;
    private JTextField buscarIdEvaluacionField;
    private JButton buscarButton, eliminarButton, cancelButton;

    public BajaEvaluacion() {
        // Crear la ventana
        frame = new JFrame("Baja de Evaluación");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para buscar por ID de Evaluación
        frame.add(new JLabel("Buscar por ID de Evaluación:"));
        buscarIdEvaluacionField = new JTextField(20);
        frame.add(buscarIdEvaluacionField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEvaluacion();
            }
        });
        frame.add(buscarButton);
        frame.add(new JLabel()); // Placeholder para alinear el botón correctamente

        // Botón de eliminar evaluación
        eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarEvaluacion();
            }
        });
        eliminarButton.setEnabled(false); // Se habilitará tras encontrar una evaluación
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

    private void buscarEvaluacion() {
        // Simulacion la búsqueda de una evaluación en la base de datos
        String idEvaluacion = buscarIdEvaluacionField.getText();
        System.out.println("Buscando la evaluación con ID: " + idEvaluacion);
        // Aquí falta implementar  implementar la lógica para buscar la evaluación en tu base de datos

        // Simulación de encontrar una evaluación
        if (!idEvaluacion.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Evaluación encontrada: " + idEvaluacion, "Información", JOptionPane.INFORMATION_MESSAGE);
            eliminarButton.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Evaluación no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            eliminarButton.setEnabled(false);
        }
    }

    private void eliminarEvaluacion() {
        // Aquí falta añadir la lógica para eliminar los datos en la base de datos
        String idEvaluacion = buscarIdEvaluacionField.getText();
        System.out.println("Eliminando la evaluación con ID: " + idEvaluacion);
        JOptionPane.showMessageDialog(frame, "Evaluación eliminada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose(); // Cerrar la ventana después de eliminar
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BajaEvaluacion();
            }
        });
    }
}

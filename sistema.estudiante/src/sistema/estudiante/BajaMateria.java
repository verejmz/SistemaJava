package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajaMateria {
    private JFrame frame;
    private JTextField buscarIdMateriaField;
    private JButton buscarButton, eliminarButton, cancelButton;

    public BajaMateria() {
        // Crear la ventana
        frame = new JFrame("Baja de Materia");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para buscar por ID de Materia
        frame.add(new JLabel("Buscar por ID de Materia:"));
        buscarIdMateriaField = new JTextField(20);
        frame.add(buscarIdMateriaField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarMateria();
            }
        });
        frame.add(buscarButton);
        frame.add(new JLabel()); // Placeholder para alinear el botón correctamente

        // Botón de eliminar materia
        eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarMateria();
            }
        });
        eliminarButton.setEnabled(false); // Se habilitará tras encontrar una materia
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

    private void buscarMateria() {
        // Simula la búsqueda de una materia en la base de datos
        String idMateria = buscarIdMateriaField.getText();
        System.out.println("Buscando la materia con ID: " + idMateria);
        // Aquí deberías implementar la lógica para buscar la materia en tu base de datos

        // Simulacion de encontrar una materia
        if (!idMateria.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Materia encontrada: " + idMateria, "Información", JOptionPane.INFORMATION_MESSAGE);
            eliminarButton.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Materia no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            eliminarButton.setEnabled(false);
        }
    }

    private void eliminarMateria() {
        // Aquí falta añadir la lógica para eliminar los datos en la base de datos
        String idMateria = buscarIdMateriaField.getText();
        System.out.println("Eliminando la materia con ID: " + idMateria);
        JOptionPane.showMessageDialog(frame, "Materia eliminada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose(); // Cerrar la ventana después de eliminar
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BajaMateria();
            }
        });
    }
}

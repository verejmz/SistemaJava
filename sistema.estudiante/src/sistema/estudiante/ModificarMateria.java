package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarMateria {
    private JFrame frame;
    private JTextField idMateriaField, nombreMateriaField, numeroCreditosField;
    private JTextArea descripcionMateriaArea;
    private JButton buscarButton, modificarButton, cancelButton;

    public ModificarMateria() {
        // Crear la ventana
        frame = new JFrame("Modificar Materia");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para buscar por ID de Materia
        frame.add(new JLabel("ID de Materia:"));
        idMateriaField = new JTextField(20);
        frame.add(idMateriaField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarMateria();
            }
        });
        frame.add(buscarButton);
        frame.add(new JLabel()); // Placeholder para alinear el botón correctamente

        // Campos para editar información de la materia
        frame.add(new JLabel("Nombre de Materia:"));
        nombreMateriaField = new JTextField(20);
        frame.add(nombreMateriaField);

        frame.add(new JLabel("Descripción:"));
        descripcionMateriaArea = new JTextArea(5, 20);
        descripcionMateriaArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(descripcionMateriaArea);
        frame.add(scrollPane);

        frame.add(new JLabel("Número de Créditos:"));
        numeroCreditosField = new JTextField(20);
        frame.add(numeroCreditosField);

        // Botones de modificar y cancelar
        modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarMateria();
            }
        });
        frame.add(modificarButton);

        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar la ventana
            }
        });
        frame.add(cancelButton);

        // Configuración inicial de la ventana
        nombreMateriaField.setEditable(false);
        descripcionMateriaArea.setEditable(false);
        numeroCreditosField.setEditable(false);
        modificarButton.setEnabled(false);

        // Mostrar la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }

    private void buscarMateria() {
        // Simular la búsqueda de una materia
        String idMateria = idMateriaField.getText();
        System.out.println("Buscando la materia con ID: " + idMateria);
        // Aquí deberías implementar la lógica para buscar la materia en tu base de datos

        // Simulación de encontrar una materia
        if (!idMateria.isEmpty()) {
            nombreMateriaField.setText("Ejemplo Materia");
            descripcionMateriaArea.setText("Descripción de la materia aquí.");
            numeroCreditosField.setText("3");
            nombreMateriaField.setEditable(true);
            descripcionMateriaArea.setEditable(true);
            numeroCreditosField.setEditable(true);
            modificarButton.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Materia no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarMateria() {
        // Aquí falta añadir la lógica para actualizar los datos en la base de datos
        String nombreMateria = nombreMateriaField.getText();
        String descripcion = descripcionMateriaArea.getText();
        String numeroCreditos = numeroCreditosField.getText();

        System.out.println("Modificando datos de la materia: " + nombreMateria + ", " + descripcion + ", Créditos: " + numeroCreditos);
        JOptionPane.showMessageDialog(frame, "Materia modificada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose(); // Cerrar la ventana después de modificar
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ModificarMateria();
            }
        });
    }
}

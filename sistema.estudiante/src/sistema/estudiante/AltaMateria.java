package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaMateria {
    private JFrame frame;
    private JTextField idMateriaField, nombreMateriaField, numeroCreditosField;
    private JTextArea descripcionMateriaArea;
    private JButton ingresarButton, cancelButton;

    public AltaMateria() {
        // Crear la ventana
        frame = new JFrame("Alta de Materia");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para ID de Materia
        frame.add(new JLabel("ID de Materia:"));
        idMateriaField = new JTextField(20);
        frame.add(idMateriaField);

        // Campo para Nombre de Materia
        frame.add(new JLabel("Nombre de Materia:"));
        nombreMateriaField = new JTextField(20);
        frame.add(nombreMateriaField);

        // Campo para Descripción de Materia
        frame.add(new JLabel("Descripción:"));
        descripcionMateriaArea = new JTextArea(5, 20);
        descripcionMateriaArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(descripcionMateriaArea);
        frame.add(scrollPane);

        // Campo para Número de Créditos
        frame.add(new JLabel("Número de Créditos:"));
        numeroCreditosField = new JTextField(20);
        frame.add(numeroCreditosField);

        // Botones de ingresar y cancelar
        ingresarButton = new JButton("Ingresar");
        ingresarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingresarMateria();
            }
        });
        frame.add(ingresarButton);

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

    private void ingresarMateria() {
        // Aquí se agrega la lógica para guardar los datos en la base de datos
        String idMateria = idMateriaField.getText();
        String nombreMateria = nombreMateriaField.getText();
        String descripcion = descripcionMateriaArea.getText();
        String numeroCreditos = numeroCreditosField.getText();

        // Simular la inserción de datos
        System.out.println("Datos de la materia: ID: " + idMateria + ", Nombre: " + nombreMateria + ", Descripción: " + descripcion + ", Créditos: " + numeroCreditos);
        JOptionPane.showMessageDialog(frame, "Materia ingresada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AltaMateria();
            }
        });
    }
}

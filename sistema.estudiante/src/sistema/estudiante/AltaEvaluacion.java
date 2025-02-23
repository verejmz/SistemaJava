package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class AltaEvaluacion {
    private JFrame frame;
    private JTextField idEvaluacionField, idMateriaField, tipoEvaluacionField, puntuacionMaximaField;
    private JFormattedTextField fechaEvaluacionField;
    private JButton ingresarButton, cancelButton;

    public AltaEvaluacion() {
        // Crear la ventana
        frame = new JFrame("Alta de Evaluación");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para ID de Evaluación
        frame.add(new JLabel("ID de Evaluación:"));
        idEvaluacionField = new JTextField(20);
        frame.add(idEvaluacionField);

        // Campo para ID de Materia
        frame.add(new JLabel("ID de Materia:"));
        idMateriaField = new JTextField(20);
        frame.add(idMateriaField);

        // Campo para Tipo de Evaluación
        frame.add(new JLabel("Tipo de Evaluación:"));
        tipoEvaluacionField = new JTextField(20);
        frame.add(tipoEvaluacionField);

        // Campo para Fecha de Evaluación
        frame.add(new JLabel("Fecha de Evaluación (dd/mm/yyyy):"));
        fechaEvaluacionField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        fechaEvaluacionField.setColumns(10);
        frame.add(fechaEvaluacionField);

        // Campo para Puntuación Máxima
        frame.add(new JLabel("Puntuación Máxima:"));
        puntuacionMaximaField = new JTextField(20);
        frame.add(puntuacionMaximaField);

        // Botones de ingresar y cancelar
        ingresarButton = new JButton("Ingresar");
        ingresarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingresarEvaluacion();
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

    private void ingresarEvaluacion() {
        // Aquí se agrega la lógica para guardar los datos en la base de datos
        String idEvaluacion = idEvaluacionField.getText();
        String idMateria = idMateriaField.getText();
        String tipoEvaluacion = tipoEvaluacionField.getText();
        String fechaEvaluacion = fechaEvaluacionField.getText();
        String puntuacionMaxima = puntuacionMaximaField.getText();

        // Simular la inserción de datos
        System.out.println("Datos de la evaluación: ID: " + idEvaluacion + ", ID Materia: " + idMateria + ", Tipo: " + tipoEvaluacion + ", Fecha: " + fechaEvaluacion + ", Puntuación: " + puntuacionMaxima);
        JOptionPane.showMessageDialog(frame, "Evaluación ingresada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AltaEvaluacion();
            }
        });
    }
}

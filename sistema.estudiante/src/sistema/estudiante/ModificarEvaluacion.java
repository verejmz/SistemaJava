package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class ModificarEvaluacion {
    private JFrame frame;
    private JTextField idEvaluacionField, idMateriaField, tipoEvaluacionField, puntuacionMaximaField;
    private JFormattedTextField fechaEvaluacionField;
    private JButton buscarButton, modificarButton, cancelButton;

    public ModificarEvaluacion() {
        // Crear la ventana
        frame = new JFrame("Modificar Evaluación");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para buscar por ID de Evaluación
        frame.add(new JLabel("ID de Evaluación:"));
        idEvaluacionField = new JTextField(20);
        frame.add(idEvaluacionField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEvaluacion();
            }
        });
        frame.add(buscarButton);
        frame.add(new JLabel()); // Placeholder para alinear el botón correctamente

        // Campos para editar información de la evaluación
        frame.add(new JLabel("ID de Materia:"));
        idMateriaField = new JTextField(20);
        frame.add(idMateriaField);

        frame.add(new JLabel("Tipo de Evaluación:"));
        tipoEvaluacionField = new JTextField(20);
        frame.add(tipoEvaluacionField);

        frame.add(new JLabel("Fecha de Evaluación (dd/mm/yyyy):"));
        fechaEvaluacionField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        fechaEvaluacionField.setColumns(10);
        frame.add(fechaEvaluacionField);

        frame.add(new JLabel("Puntuación Máxima:"));
        puntuacionMaximaField = new JTextField(20);
        frame.add(puntuacionMaximaField);

        // Botones de modificar y cancelar
        modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarEvaluacion();
            }
        });
        modificarButton.setEnabled(false); // Se habilitará tras encontrar una evaluación
        frame.add(modificarButton);

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
        // Simular la búsqueda de una evaluación
        String idEvaluacion = idEvaluacionField.getText();
        System.out.println("Buscando la evaluación con ID: " + idEvaluacion);
        // Aquí deberías implementar la lógica para buscar la evaluación en tu base de datos

        // Simulación de encontrar una evaluación
        if (!idEvaluacion.isEmpty()) {
            idMateriaField.setText("Ejemplo Materia");
            tipoEvaluacionField.setText("Examen Final");
            fechaEvaluacionField.setText("01/12/2021");
            puntuacionMaximaField.setText("100");
            idMateriaField.setEditable(true);
            tipoEvaluacionField.setEditable(true);
            fechaEvaluacionField.setEditable(true);
            puntuacionMaximaField.setEditable(true);
            modificarButton.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Evaluación no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            modificarButton.setEnabled(false);
        }
    }

    private void modificarEvaluacion() {
        // Aquí falta añadir la lógica para actualizar los datos en la base de datos
        String idEvaluacion = idEvaluacionField.getText();
        String idMateria = idMateriaField.getText();
        String tipoEvaluacion = tipoEvaluacionField.getText();
        String fechaEvaluacion = fechaEvaluacionField.getText();
        String puntuacionMaxima = puntuacionMaximaField.getText();

        System.out.println("Modificando datos de la evaluación: " + idEvaluacion + ", Materia: " + idMateria + ", Tipo: " + tipoEvaluacion + ", Fecha: " + fechaEvaluacion + ", Puntuación: " + puntuacionMaxima);
        JOptionPane.showMessageDialog(frame, "Evaluación modificada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose(); // Cerrar la ventana después de modificar
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ModificarEvaluacion();
            }
        });
    }
}

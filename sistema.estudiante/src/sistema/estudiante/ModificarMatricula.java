package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class ModificarMatricula {
    private JFrame frame;
    private JTextField buscarIdMatriculaField, idEstudianteField, idCursoField;
    private JFormattedTextField fechaInicioField, fechaFinField;
    private JButton buscarButton, modificarButton, cancelButton;

    public ModificarMatricula() {
        // Crear la ventana
        frame = new JFrame("Modificar Matrícula");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
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

        // Crear y añadir los campos y etiquetas para la información de la matrícula
        frame.add(new JLabel("ID de Estudiante:"));
        idEstudianteField = new JTextField(20);
        idEstudianteField.setEditable(false);
        frame.add(idEstudianteField);

        frame.add(new JLabel("ID de Curso:"));
        idCursoField = new JTextField(20);
        idCursoField.setEditable(false);
        frame.add(idCursoField);

        frame.add(new JLabel("Fecha de Inicio (dd/mm/yyyy):"));
        fechaInicioField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        fechaInicioField.setColumns(10);
        fechaInicioField.setEditable(false);
        frame.add(fechaInicioField);

        frame.add(new JLabel("Fecha de Fin (dd/mm/yyyy):"));
        fechaFinField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        fechaFinField.setColumns(10);
        fechaFinField.setEditable(false);
        frame.add(fechaFinField);

        // Botones de modificar y cancelar
        modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarMatricula();
            }
        });
        modificarButton.setEnabled(false); // Se habilitará tras encontrar una matrícula
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

    private void buscarMatricula() {
        // Simula la búsqueda de una matrícula en la base de datos
        String idMatricula = buscarIdMatriculaField.getText();
        System.out.println("Buscando la matrícula con ID: " + idMatricula);
        // Aquí deberías implementar la lógica para buscar la matrícula en tu base de datos

        // Simulación de encontrar una matrícula
        idEstudianteField.setText("12345");
        idCursoField.setText("67890");
        fechaInicioField.setText("01/01/2021");
        fechaFinField.setText("01/01/2022");

        // Habilitar campos y botón de modificar
        idEstudianteField.setEditable(true);
        idCursoField.setEditable(true);
        fechaInicioField.setEditable(true);
        fechaFinField.setEditable(true);
        modificarButton.setEnabled(true);
    }

    private void modificarMatricula() {
        // Aquí falta añadir la lógica para actualizar los datos en la base de datos
        String idEstudiante = idEstudianteField.getText();
        String idCurso = idCursoField.getText();
        String fechaInicio = fechaInicioField.getText();
        String fechaFin = fechaFinField.getText();
        System.out.println("Modificando datos de la matrícula: " + idEstudiante + ", " + idCurso + ", " + fechaInicio + ", " + fechaFin);
        JOptionPane.showMessageDialog(frame, "Matrícula modificada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ModificarMatricula();
            }
        });
    }
}

package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class AltaMatricula {
    private JFrame frame;
    private JTextField idMatriculaField, idEstudianteField, idCursoField;
    private JFormattedTextField fechaInicioField, fechaFinField;
    private JButton ingresarButton, cancelButton;

    public AltaMatricula() {
        // Crear la ventana
        frame = new JFrame("Alta de Matrícula");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Crear y añadir los campos y etiquetas
        frame.add(new JLabel("ID de Matrícula:"));
        idMatriculaField = new JTextField(20);
        frame.add(idMatriculaField);

        frame.add(new JLabel("ID de Estudiante:"));
        idEstudianteField = new JTextField(20);
        frame.add(idEstudianteField);

        frame.add(new JLabel("ID de Curso:"));
        idCursoField = new JTextField(20);
        frame.add(idCursoField);

        frame.add(new JLabel("Fecha de Inicio (dd/mm/yyyy):"));
        fechaInicioField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        fechaInicioField.setColumns(10);
        frame.add(fechaInicioField);

        frame.add(new JLabel("Fecha de Fin (dd/mm/yyyy):"));
        fechaFinField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        fechaFinField.setColumns(10);
        frame.add(fechaFinField);

        // Botones de ingresar y cancelar
        ingresarButton = new JButton("Ingresar");
        ingresarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingresarMatricula();
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

    private void ingresarMatricula() {
        // Aquí se agrega la lógica para guardar los datos en la base de datos
        String idMatricula = idMatriculaField.getText();
        String idEstudiante = idEstudianteField.getText();
        String idCurso = idCursoField.getText();
        String fechaInicio = fechaInicioField.getText();
        String fechaFin = fechaFinField.getText();

        // Simular la inserción de datos
        System.out.println("Datos de la matrícula: " + idMatricula + ", " + idEstudiante + ", " + idCurso + ", " + fechaInicio + ", " + fechaFin);
        JOptionPane.showMessageDialog(frame, "Matrícula ingresada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AltaMatricula();
            }
        });
    }
}

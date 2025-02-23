package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AltaProfesor {
    private JFrame frame;
    private JTextField nombreField, apellidoField, especialidadField, correoField, telefonoField;
    private JButton ingresarButton, cancelButton;

    public AltaProfesor() {
        // Crear la ventana
        frame = new JFrame("Alta de Profesores");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Crear y añadir los campos y etiquetas
        frame.add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        frame.add(nombreField);

        frame.add(new JLabel("Apellido:"));
        apellidoField = new JTextField(20);
        frame.add(apellidoField);

        frame.add(new JLabel("Especialidad:"));
        especialidadField = new JTextField(20);
        frame.add(especialidadField);

        frame.add(new JLabel("Correo:"));
        correoField = new JTextField(20);
        frame.add(correoField);

        frame.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField(10);
        frame.add(telefonoField);

        // Botones de ingresar y cancelar
        ingresarButton = new JButton("Ingresar");
        ingresarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingresarProfesor();
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

    private void ingresarProfesor() {
        // Aquí se agrega la lógica para guardar los datos en la base de datos
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String especialidad = especialidadField.getText();
        String correo = correoField.getText();
        String telefono = telefonoField.getText();

        // Simular la inserción de datos
        System.out.println("Datos del profesor: " + nombre + " " + apellido + " " + especialidad + " " + correo + " " + telefono);
        JOptionPane.showMessageDialog(frame, "Profesor ingresado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AltaProfesor();
            }
        });
    }
}

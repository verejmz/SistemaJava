package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModificarProfesor {
    private JFrame frame;
    private JTextField buscarNombreField, nombreField, apellidoField, especialidadField, correoField, telefonoField;
    private JButton buscarButton, modificarButton, cancelButton;

    public ModificarProfesor() {
        // Crear la ventana
        frame = new JFrame("Modificar Profesor");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para buscar por nombre del profesor
        frame.add(new JLabel("Buscar por Nombre:"));
        buscarNombreField = new JTextField(20);
        frame.add(buscarNombreField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarProfesor();
            }
        });
        frame.add(buscarButton);
        frame.add(new JLabel()); // Placeholder para alinear el botón correctamente

        // Crear y añadir los campos y etiquetas para la información del profesor
        frame.add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        nombreField.setEditable(false);
        frame.add(nombreField);

        frame.add(new JLabel("Apellido:"));
        apellidoField = new JTextField(20);
        apellidoField.setEditable(false);
        frame.add(apellidoField);

        frame.add(new JLabel("Especialidad:"));
        especialidadField = new JTextField(20);
        especialidadField.setEditable(false);
        frame.add(especialidadField);

        frame.add(new JLabel("Correo:"));
        correoField = new JTextField(20);
        correoField.setEditable(false);
        frame.add(correoField);

        frame.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField(10);
        telefonoField.setEditable(false);
        frame.add(telefonoField);

        // Botones de modificar y cancelar
        modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarProfesor();
            }
        });
        modificarButton.setEnabled(false); // Se habilitará tras encontrar un profesor
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

    private void buscarProfesor() {
        // Simula la búsqueda de un profesor en la base de datos
        String nombreBuscado = buscarNombreField.getText();
        System.out.println("Buscando al profesor con nombre: " + nombreBuscado);
        // Aquí deberías implementar la lógica para buscar al profesor en tu base de datos

        // Simulación de encontrar un profesor
        nombreField.setText("Nombre Simulado");
        apellidoField.setText("Apellido Simulado");
        especialidadField.setText("Especialidad Simulada");
        correoField.setText("email@ejemplo.com");
        telefonoField.setText("1234567890");

        // Habilitar campos y botón de modificar
        nombreField.setEditable(true);
        apellidoField.setEditable(true);
        especialidadField.setEditable(true);
        correoField.setEditable(true);
        telefonoField.setEditable(true);
        modificarButton.setEnabled(true);
    }

    private void modificarProfesor() {
        // Aquí falta añadir la lógica para actualizar los datos en la base de datos
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String especialidad = especialidadField.getText();
        String correo = correoField.getText();
        String telefono = telefonoField.getText();
        System.out.println("Modificando datos del profesor: " + nombre + " " + apellido + " " + especialidad + " " + correo + " " + telefono);
        JOptionPane.showMessageDialog(frame, "Profesor modificado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ModificarProfesor();
            }
        });
    }
}

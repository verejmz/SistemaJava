/**
 * 
 */

package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class ModificarEstudiante {
    private JFrame frame;
    private JTextField matriculaField, nombreField, apellidoField, correoField, telefonoField;
    private JFormattedTextField fechaNacimientoField;
    private JButton buscarButton, modificarButton, cancelButton;

    public ModificarEstudiante() {
        // Crear la ventana
        frame = new JFrame("Modificar Estudiante");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(0, 2, 10, 10)); // Layout con 2 columnas

        // Campo para ingresar la matrícula
        frame.add(new JLabel("Matrícula:"));
        matriculaField = new JTextField(20);
        frame.add(matriculaField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEstudiante();
            }
        });
        frame.add(buscarButton);
        frame.add(new JLabel()); // Placeholder para alinear el botón correctamente

        // Crear y añadir los campos y etiquetas
        frame.add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        nombreField.setEditable(false);
        frame.add(nombreField);

        frame.add(new JLabel("Apellido:"));
        apellidoField = new JTextField(20);
        apellidoField.setEditable(false);
        frame.add(apellidoField);

        frame.add(new JLabel("Fecha de Nacimiento (dd/mm/yyyy):"));
        fechaNacimientoField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        fechaNacimientoField.setColumns(10);
        fechaNacimientoField.setEditable(false);
        frame.add(fechaNacimientoField);

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
                modificarEstudiante();
            }
        });
        modificarButton.setEnabled(false); // Se habilitará tras encontrar un estudiante
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

    private void buscarEstudiante() {
        // Simula la búsqueda de un estudiante en la base de datos
        String matricula = matriculaField.getText();
        System.out.println("Buscando al estudiante con matrícula: " + matricula);
        // Aquí deberías implementar la lógica para buscar al estudiante en tu base de datos

        // Simulación de encontrar un estudiante
        nombreField.setText("Nombre Simulado");
        apellidoField.setText("Apellido Simulado");
        fechaNacimientoField.setText("01/01/2000");
        correoField.setText("email@ejemplo.com");
        telefonoField.setText("1234567890");

        // Habilitar campos y botón de modificar
        nombreField.setEditable(true);
        apellidoField.setEditable(true);
        fechaNacimientoField.setEditable(true);
        correoField.setEditable(true);
        telefonoField.setEditable(true);
        modificarButton.setEnabled(true);
    }

    private void modificarEstudiante() {
        // Aquí falta añadir la lógica para actualizar los datos en la base de datos
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String fechaNacimiento = fechaNacimientoField.getText();
        String correo = correoField.getText();
        String telefono = telefonoField.getText();
        System.out.println("Modificando datos del estudiante: " + nombre + " " + apellido + " " + fechaNacimiento + " " + correo + " " + telefono);
        JOptionPane.showMessageDialog(frame, "Estudiante modificado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ModificarEstudiante();
            }
        });
    }
}

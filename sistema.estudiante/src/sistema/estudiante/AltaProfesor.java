package sistema.estudiante;

import javax.swing.*;

public class AltaProfesor extends FormularioBase {
    private JTextField nombreField, apellidoField, especialidadField, correoField, telefonoField;

    public AltaProfesor() {
        super("Alta de Profesor"); // Llama al constructor de la clase base

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

        frame.add(ingresarButton);
        frame.add(cancelButton);

        mostrarFormulario();
    }

    @Override
    protected void ingresarDatos() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
     //  String especialidad = especialidadField.getText();
     //  String correo = correoField.getText();
     //  String telefono = telefonoField.getText();

        System.out.println("Profesor ingresado: " + nombre + " " + apellido);
        JOptionPane.showMessageDialog(frame, "Profesor ingresado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}

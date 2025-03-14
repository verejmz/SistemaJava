package sistema.estudiante;

import javax.swing.*;

public class AltaMatricula extends FormularioBase {
    private JTextField idMatriculaField, idEstudianteField, idCursoField;
    private JFormattedTextField fechaInicioField, fechaFinField;

    public AltaMatricula() {
        super("Alta de Matrícula");

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
        fechaInicioField = new JFormattedTextField();
        frame.add(fechaInicioField);

        frame.add(new JLabel("Fecha de Fin (dd/mm/yyyy):"));
        fechaFinField = new JFormattedTextField();
        frame.add(fechaFinField);

        frame.add(ingresarButton);
        frame.add(cancelButton);

        mostrarFormulario();
    }

    @Override
    protected void ingresarDatos() {
        String idMatricula = idMatriculaField.getText();
      //  String idEstudiante = idEstudianteField.getText();
      //  String idCurso = idCursoField.getText();
       // String fechaInicio = fechaInicioField.getText();
      //  String fechaFin = fechaFinField.getText();

        System.out.println("Matrícula ingresada: " + idMatricula);
        JOptionPane.showMessageDialog(frame, "Matrícula ingresada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}

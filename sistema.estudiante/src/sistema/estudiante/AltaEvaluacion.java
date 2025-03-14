package sistema.estudiante;

import javax.swing.*;

public class AltaEvaluacion extends FormularioBase {
    private JTextField idEvaluacionField, idMateriaField, tipoEvaluacionField, puntuacionMaximaField;
    private JFormattedTextField fechaEvaluacionField;

    public AltaEvaluacion() {
        super("Alta de Evaluación");

        frame.add(new JLabel("ID de Evaluación:"));
        idEvaluacionField = new JTextField(20);
        frame.add(idEvaluacionField);

        frame.add(new JLabel("ID de Materia:"));
        idMateriaField = new JTextField(20);
        frame.add(idMateriaField);

        frame.add(new JLabel("Tipo de Evaluación:"));
        tipoEvaluacionField = new JTextField(20);
        frame.add(tipoEvaluacionField);

        frame.add(new JLabel("Fecha de Evaluación (dd/mm/yyyy):"));
        fechaEvaluacionField = new JFormattedTextField();
        frame.add(fechaEvaluacionField);

        frame.add(new JLabel("Puntuación Máxima:"));
        puntuacionMaximaField = new JTextField(20);
        frame.add(puntuacionMaximaField);

        frame.add(ingresarButton);
        frame.add(cancelButton);

        mostrarFormulario();
    }

    @Override
    protected void ingresarDatos() {
        String idEvaluacion = idEvaluacionField.getText();
        //String idMateria = idMateriaField.getText();
        //String tipoEvaluacion = tipoEvaluacionField.getText();
        //String fechaEvaluacion = fechaEvaluacionField.getText();
        //String puntuacionMaxima = puntuacionMaximaField.getText();

        System.out.println("Evaluación ingresada: " + idEvaluacion);
        JOptionPane.showMessageDialog(frame, "Evaluación ingresada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}

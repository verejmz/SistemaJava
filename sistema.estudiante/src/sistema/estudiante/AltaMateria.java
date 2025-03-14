package sistema.estudiante;

import javax.swing.*;

public class AltaMateria extends FormularioBase {
    private JTextField idMateriaField, nombreMateriaField, numeroCreditosField;
    private JTextArea descripcionMateriaArea;

    public AltaMateria() {
        super("Alta de Materia");

        frame.add(new JLabel("ID de Materia:"));
        idMateriaField = new JTextField(20);
        frame.add(idMateriaField);

        frame.add(new JLabel("Nombre de Materia:"));
        nombreMateriaField = new JTextField(20);
        frame.add(nombreMateriaField);

        frame.add(new JLabel("Descripción:"));
        descripcionMateriaArea = new JTextArea(5, 20);
        frame.add(new JScrollPane(descripcionMateriaArea));

        frame.add(new JLabel("Número de Créditos:"));
        numeroCreditosField = new JTextField(20);
        frame.add(numeroCreditosField);

        frame.add(ingresarButton);
        frame.add(cancelButton);

        mostrarFormulario();
    }

    @Override
    protected void ingresarDatos() {
       // String idMateria = idMateriaField.getText();
        String nombreMateria = nombreMateriaField.getText();
       // String descripcion = descripcionMateriaArea.getText();
       // String numeroCreditos = numeroCreditosField.getText();

        System.out.println("Materia ingresada: " + nombreMateria);
        JOptionPane.showMessageDialog(frame, "Materia ingresada correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}

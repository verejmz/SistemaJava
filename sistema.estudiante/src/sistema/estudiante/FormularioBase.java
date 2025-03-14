package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class FormularioBase {
    protected JFrame frame;
    protected JButton ingresarButton, cancelButton;

    public FormularioBase(String titulo) {
        frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2, 10, 10));

        // Botones de acción
        ingresarButton = new JButton("Ingresar");
        ingresarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingresarDatos();
            }
        });

        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setLocationRelativeTo(null);
    }

    protected abstract void ingresarDatos(); // Método abstracto para personalizar en cada subclase

    public void mostrarFormulario() {
        frame.setVisible(true);
    }
}

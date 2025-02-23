package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class recuperacion {

    private static final Logger logger = Logger.getLogger(recuperacion.class.getName());

    public static void ventanarecuperacion() {
        setupLogger();

        JFrame frame = new JFrame("Recuperación de Contraseña");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel, BorderLayout.CENTER);

        JLabel correoLabel = new JLabel("Correo Electrónico:");
        JTextField correoField = new JTextField(20);
        panel.add(correoLabel);
        panel.add(correoField);

        JButton recoverButton = new JButton("Recuperar Contraseña");
        recoverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String correo = correoField.getText();
                logger.info("Attempting to recover password for: " + correo);
                if (correo.equals("vere@ejemplo.com")) { // Simula la verificación del correo
                    logger.info("Recovery email sent to: " + correo);
                    JOptionPane.showMessageDialog(frame, "Correo de recuperación enviado exitosamente.", "Recuperación Enviada", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    logger.severe("Email not found");
                    JOptionPane.showMessageDialog(frame, "Correo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(recoverButton);

        frame.setVisible(true);
        logger.info("Recovery screen online at " + getCurrentTimeStamp());
    }

    private static void setupLogger() {
        try {
            LogManager.getLogManager().reset();
            logger.setLevel(Level.ALL);
            FileHandler fh = new FileHandler("C:/Users/Ocyriz/Documents/Proyecto_sistema_java_vere/logs/recovery.log", true);
            fh.setFormatter(new SimpleFormatter() {
                @Override
                public synchronized String format(LogRecord lr) {
                    return String.format("%1$tF %1$tT - [%2$s] %3$s %n",
                                         new Date(lr.getMillis()), lr.getLevel().getLocalizedName(), lr.getMessage());
                }
            });
            logger.addHandler(fh);
        } catch (IOException e) {
            System.err.println("Failed to setup logger: " + e.toString());
        }
    }

    private static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return sdfDate.format(now);
    }
}

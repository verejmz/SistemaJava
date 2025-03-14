package sistema.estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class LoginSinConexionbd {

    private static final Logger logger = Logger.getLogger(LoginSinConexionbd.class.getName());

    public static void main(String[] args) {
        setupLogger();

        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel, BorderLayout.CENTER);

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\Ocyriz\\Pictures\\osiris_icono.png");
        Image image = originalIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);
        JLabel logoLabel = new JLabel(icon, SwingConstants.CENTER);
        panel.add(logoLabel);

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField(20);
        panel.add(userLabel);
        panel.add(userField);

        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField(20);
        panel.add(passLabel);
        panel.add(passField);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                logger.info("Invoking log in for user: " + username);
                if (username.equals("vere") && password.equals("vere")) {
                    logger.info("Login success: " + username);
                    frame.dispose(); // Cierra la ventana de inicio de sesión
                    menu.menuonline();  // avertura de ventana menu
                } else {
                    logger.severe("Password incorrect");
                    JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);

        JButton recoverButton = new JButton("Recuperar Contraseña");
        recoverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana de inicio de sesión
                // Aquí deberías llamar a la función que abre la ventana de recuperación
                recuperacion.ventanarecuperacion(); // Asegúrate de que esta función esté implementada correctamente
            }
        });
        panel.add(recoverButton);

        frame.setVisible(true);
        logger.info("Screen online at " + getCurrentTimeStamp());
    }

    private static void setupLogger() {
        try {
            LogManager.getLogManager().reset();
            logger.setLevel(Level.ALL);
            FileHandler fh = new FileHandler("C:/Users/Ocyriz/Documents/Proyecto_sistema_java_vere/logs/history.log", true);
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

package sistema.estudiante;

public class test_connection {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("El driver JDBC para SQL Server está instalado y disponible.");
        } catch (ClassNotFoundException e) {
            System.out.println("El driver JDBC para SQL Server no está disponible: " + e.getMessage());
        }
    }
}

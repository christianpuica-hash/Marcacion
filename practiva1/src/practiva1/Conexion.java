package practiva1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        String user = "system";
        String pass = "12345678";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(url, user, pass);

            System.out.println("¡Conexión establecida con éxito!");

            // 1. Creamos el Statement
            Statement st = con.createStatement();

            // 2. Consulta a tu tabla 'Terceros'
            String sql = "SELECT * FROM Terceros";
            ResultSet rs = st.executeQuery(sql);

            System.out.println("--- LISTADO DE TERCEROS ---");
            
            // 3. Recorremos las columnas que vi en tu imagen
            // ... después de ResultSet rs = st.executeQuery(sql); ...

// ... después de ResultSet rs = st.executeQuery(sql); ...
    
   // ... después de ResultSet rs = st.executeQuery(sql); ...

System.out.println("--- LISTADO COMPLETO DE TERCEROS ---");
System.out.println("--------------------------------------------------");

while (rs.next()) {
    // Extraemos cada columna por su nombre exacto en la base de datos
    int id = rs.getInt("ID");
    String nom = rs.getString("NOMBRE");
    String ape = rs.getString("APELLIDO");
    String documento = rs.getString("DNI");

    // Lo imprimimos todo en una sola línea formateada
    System.out.println("ID: " + id + " | Nombre: " + nom + " " + ape + " | DNI: " + documento);
}

System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
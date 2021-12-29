package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SelectApp {

    private Connection connect() {
        String url = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("Nombre") + "\t" +
                    rs.getString("Apellido") + "\t" +
                    rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
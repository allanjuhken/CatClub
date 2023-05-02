package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public Connection createConnection() {
        try {
            Connection conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/cat_club", "root", "Mysqlipassword123456");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

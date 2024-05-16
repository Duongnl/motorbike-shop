package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectToSQL {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLXM;"
            + "encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "123456$";

    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            try {
                conn = DriverManager.getConnection(URL, USER, PASS);
                // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                // conn =
                // DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=empty;user=sa;password=123456$");
            } catch (SQLException ex) {

            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Không Thể Kết Nối Tới Cơ Sở Dữ Liệu");
            return null;
        }
        System.out.println(conn);
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectToSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

package treningsdagbok;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect{
	
	public Connection getConnection(){
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
        	System.out.println(ex);
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/treningsdagbok?" +
                                           "user=root&password=root");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;	
	}
}
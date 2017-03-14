package treningsdagbok;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	
	private void sendStatement(Connection con, String que)
			    throws SQLException {

			    Statement stmt = null;
			    String query = que;
			    try {
			        stmt = con.createStatement();
			        stmt.executeUpdate(query);
			    
			    } catch (SQLException e ) {
			        System.out.println(e);
			    } finally {
			        if (stmt != null) { 
			        	stmt.close();
			        }
			    }
			    
			}
	
	public static void main(String[] args) throws SQLException {
		Connect connection = new Connect();
		Connection conn = connection.getConnection();
		Main main = new Main();
		main.sendStatement(conn);
		
	}

}

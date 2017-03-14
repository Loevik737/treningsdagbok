package treningsdagbok;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class SendQuery {
	public void send(Connection con, String query) throws SQLException {
		Statement stmt = null;
		try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(query);
	    	System.out.println("Statement was successfully executed");
	    
	    } catch (SQLException e ) {
	        System.out.println(e);
	    	System.out.println("Statement was not executed");
	    } finally {
	        if (stmt != null) { 
	        	stmt.close();
	        
	        }
	    } 
		
	}
}

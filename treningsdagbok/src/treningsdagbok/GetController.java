package treningsdagbok;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetQuery {
	public void send(Connection con, String query) throws SQLException{
		Statement stmt = null;
		try {
			stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
				int prestasjon = rs.getInt("Prestasjon");
				System.out.print(prestasjon);
	        }
		}
		catch (SQLException e ) {
	        System.out.println(e);
	    	System.out.println("Statement was not executed");
	    } 
		finally {
	        stmt.close();
	        }
		
		
	}
}

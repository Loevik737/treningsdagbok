package treningsdagbok;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GetController {
	public List<Integer> send(Connection con, String query) throws SQLException{
		Statement stmt = null;
		List<Integer> output = new ArrayList<>();
		try {
			stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);

			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					output.add(rs.getInt("Max(Prestasjon)"));
					
				}
	        }
		}
		catch (SQLException e ) {
	        System.out.println(e);
	    	System.out.println("Statement was not executed");
	    } 
		finally {
	        stmt.close();
	        }

		return output;
	}
}

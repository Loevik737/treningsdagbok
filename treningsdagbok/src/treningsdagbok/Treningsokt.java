package treningsdagbok;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Treningsokt {
	

	public void newTreningsokt(Connection con,String start, String end,String note, String name,Integer form, Integer mal){
		String query = "INSERT INTO treningsokt (Start, Slutt, Notat, Navn, Form, Mal)" +
		    			   "VALUES (" + "'"+ start +"'"+ ", "+ "'"+ end + "'"+ ", "+ "'"+ note+ "'"+ ", "+ "'"+name+ "'"+ ", "+ "'"+form.toString()+ "'"+ ", "+ "'"+mal+ "'"+")";
		SendController c = new SendController();
		
		try {
			c.send(con, query);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
	}
	
}

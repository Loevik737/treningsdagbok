package treningsdagbok;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Treningsokt {
	

	public void newTreningsokt(Connection con,String start, String end,String note, String name,String form, String mal){
		String query = "INSERT INTO treningsokt (Start, Slutt, Notat, Navn, Form, Mal)" +
		    			   "VALUES (" + "'"+ start +"'"+ ", "+ "'"+ end + "'"+ ", "+ "'"+ note+ "'"+ ", "+ "'"+name+ "'"+ ", "+ "'"+form.toString()+ "'"+ ", "+ "'"+mal+ "'"+")";
		SendController c = new SendController();
		
		try {
			c.send(con, query);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
	}

	public void newResult(Connection con, String achievement, String description, String workoutName){
		String query = "INSERT INTO resultat (Prestasjon, Beskrivelse, treningsoktID)" + "VALUES (" + "'"+achievement+"'" +", "+  "'"+description+ "'"+", "+ "'"+"(select treningsokt.ID from treningsokt where treningsokt.Navn = "+ workoutName +"'"+")";
		SendController r = new SendController();

		try {
			r.send(con, query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void newIndoorCondition(Connection con, String air, String crowd, String workoutName){
		String query = "INSERT INTO innendorsforhold (Luft, Tilskuere, treningsoktID)" + "VALUES (" + "'"+air+"'" +", "+  "'"+crowd+ "'"+", "+"(select ID from treningsokt where Navn ="+"'"+workoutName+"'"+"))";
		SendController i = new SendController();
		try {
			i.send(con, query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void newOutoorCondition(Connection con, String weather, String temperature, String workoutName){
		String query = "INSERT INTO utendorsforhold (Vaer, Temp, treningsoktID)" + "VALUES (" + "'"+weather+"'" +", "+  "'"+temperature+ "'"+", "+"(select ID from treningsokt where Navn ="+"'"+workoutName+"'"+"))";
		SendController o = new SendController();

		try {
			o.send(con, query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

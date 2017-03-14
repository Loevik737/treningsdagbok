package treningsdagbok;

import java.sql.Connection;

import java.time.LocalDateTime;
public class Treningsokt {
	
	public void newTreningsokt(Connection con,LocalDateTime start, LocalDateTime end,String note, String name,Integer form, Boolean mal){
		//rewrite this to take in the parameters above
		String query = "INSERT INTO trening (Luft,Tilskuere)" +
		    			   "VALUES (200, 123)";
		}
}

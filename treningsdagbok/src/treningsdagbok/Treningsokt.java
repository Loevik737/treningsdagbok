package treningsdagbok;

import java.sql.Connection;

import java.time.LocalDateTime;
public class Treningsokt {
	
	public void newTreningsokt(Connection con,LocalDateTime start, LocalDateTime end,String note, String name,Integer form, Boolean mal){
		//skriv dette om til å ta in parameterene over    
		String query = "INSERT INTO trenign (Luft,Tilskuere)" +
		    			   "VALUES (200, 123)";
		}
}

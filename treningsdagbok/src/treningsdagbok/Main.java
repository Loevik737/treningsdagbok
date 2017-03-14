package treningsdagbok;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class Main {
	
	
	public static void main(String[] args) throws SQLException {
		Connect connection = new Connect();
		Connection conn = connection.getConnection();
		Treningsokt trening = new Treningsokt();
		trening.newTreningsokt(conn,LocalDateTime.now(),LocalDateTime.now(), "Notat","Name",7,false);
		
	}

}

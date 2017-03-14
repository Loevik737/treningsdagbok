package treningsdagbok;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class Main {
	
	public static void main(String[] args) throws SQLException {
		Connect connection = new Connect();
		Connection conn = connection.getConnection();
		Treningsokt trening = new Treningsokt();
		trening.newTreningsokt(conn,"2017-03-14 15:00:00","2017-03-14 15:00:00", "Notat","Name",7,1);
		
	}

}

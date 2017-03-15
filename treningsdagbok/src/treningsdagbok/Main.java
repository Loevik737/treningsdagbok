package treningsdagbok;
import java.sql.Connection;
import java.sql.SQLException;



public class Main {
	
	public static void main(String[] args) throws SQLException {
		Connect connection = new Connect();
		Connection conn = connection.getConnection();
		Resultat res  = new Resultat();
		GetController get = new GetController();
		get.send(conn, res.ResultatQuery());
		userfullOperations action = new userfullOperations();
		action.utilityCall();
		
	}

}

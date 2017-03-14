package treningsdagbok;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class userfullOperations {

    public void utilityCall() throws SQLException {
        Connect connection = new Connect();
        Connection conn = connection.getConnection();
        boolean cont = true;
        Scanner regWorkOut = new Scanner(System.in);
        while (cont) {
            System.out.println("Enter your action");
            String action = regWorkOut.nextLine();
            if (action.equals("ny")) {
                System.out.println("Enter your workout using this format: Date(YYYY.MM.DD); Startime(hh:mm:ss); Stoptime(hh:mm:ss); General notes; Name; Form; Template(0 , 1)");
                String result = regWorkOut.nextLine();
                String[] data = result.split(";");
                String starttime = data[0] + " " + data[1];
                String stoptime = data[0] + " " + data[2];
                String notes =  data[3];
                String name = data[4];
                String form = data[5];
                String template = data[6];
                Treningsokt trening = new Treningsokt();
                trening.newTreningsokt(conn, starttime, stoptime, notes, name, form, template);
            }
            else if (action.equals("stop")) {
                cont = false;
                regWorkOut.close();
            }
        }
    }
}

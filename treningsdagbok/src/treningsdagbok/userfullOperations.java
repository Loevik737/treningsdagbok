package treningsdagbok;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class userfullOperations {

    public void utilityCall() throws SQLException {
        String allActions = "List of all possible commands:" + '\n' + "new: Adds a new workout " + '\n' + "stop: Stops the program " +
                '\n' + "results: returns your results " + '\n' + "best: returns your best result";
        Connect connection = new Connect();
        Connection conn = connection.getConnection();
        boolean cont = true;
        Scanner regWorkOut = new Scanner(System.in);
        while (cont) {
            System.out.println("Enter your action");
            String action = regWorkOut.nextLine();
            if (action.equals("new")) {
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
            else if (action.equals("help")) {
                System.out.println(allActions);
            }
            else if (action.equals("best")) {
                GetController result = new GetController();
                result.send(conn, "SELECT MAX('Prestasjon') FROM treningsokt");
                for (String i: result.send(conn, "SELECT MAX('Prestasjon') FROM treningsokt")) {
                    System.out.println(i);
                }
            }
            else {
                System.out.println("Please enter a valid input, if you need help, type -help");
            }
        }
    }
}

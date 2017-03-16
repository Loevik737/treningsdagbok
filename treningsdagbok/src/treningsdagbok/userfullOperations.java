package treningsdagbok;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class userfullOperations {

    public void utilityCall() throws SQLException {
        String allActions = "List of all possible commands:" + '\n' + "new workout: Adds a new workout " + '\n' + "new result: Adds a new result "
                + '\n' + "stop: Stops the program " + '\n' + "results: returns your results " + '\n' + "best: returns your best result";
        Connect connection = new Connect();
        Connection conn = connection.getConnection();
        boolean cont = true;
        Treningsokt trening = new Treningsokt();
        Scanner regWorkOut = new Scanner(System.in);
        while (cont) {
            System.out.println("Enter your action");
            String action = regWorkOut.nextLine();
            if (action.equals("new workout")) {
                System.out.println("Enter your workout using this format: Date(YYYY.MM.DD); Startime(hh:mm); Stoptime(hh:mm); General notes; Name; Form; Template(0 , 1)  ");
                String result = regWorkOut.nextLine();
                String[] data = result.split(";");
                String starttime = data[0] + " " + data[1];
                String stoptime = data[0] + " " + data[2];
                String notes =  data[3];
                String name = data[4];
                String form = data[5];
                String template = data[6];
                trening.newTreningsokt(conn, starttime, stoptime, notes, name, form, template);
                System.out.println("Enter Where you workout found place: (indoor/outdoor);"  + "If you selected indoor, then enter airquality; and crowd size;, if you selected outdoor, enter 'weather'; and 'temperature'; ");
                String info = regWorkOut.nextLine();
                String[] followup = info.split(";");
                String condition1 = followup[1];
                String condition2 = followup[2];
                if (followup[0].equals("outdoor")) {  
                    trening.newOutoorCondition(conn, condition1, condition2, name);
                }
                else {
                    trening.newIndoorCondition(conn, condition1, condition2, name);
                }
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
                for (Integer i: result.send(conn, "SELECT MAX(Prestasjon) FROM resultat")) {
                    System.out.println(i + " out of maximum 99.");
                }
            }
            else {
                System.out.println("Please enter a valid input, if you need help, type -help");
            }
        }
    }
}

package treningsdagbok;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Resultat {
	
	public String ResultatQuery(String command) {
		if (command.equals("styrkeprestasjon")){
			String HentBestResultat = "SELECT Max(Prestasjon) FROM resultat";
			return HentBestResultat;
		}
		else if (command.equals("�kter siste m�ned")){
			String HentAntall�kter = "SELECT COUNT(ID) FROM TRENINGSOKT WHERE Start BETWEEN NOW() - interval 30 day and now()";
			return HentAntall�kter;
		}
		else if (command.equals("timer siste m�ned")){
			//String sumStart = "SELECT SUM(Start) FROM TRENINGSOKT WHERE Start BETWEEN NOW() - interval 30 day and now()";
			//String sumSlutt = "SELECT SUM(Slutt) FROM TRENINGSOKT WHERE Start BETWEEN NOW() - interval 30 day and now()";
			//GetController get = new GetController();
			//get.send()
			String HentAntallTimer = "SELECT sum(timestampdiff(hour, start, slutt)) FROM TRENINGSOKT WHERE Start BETWEEN NOW() - interval 30 day and now()";
			return HentAntallTimer;
		}
		else {
			String error = "No such command";
			return error;
		}
		
	}
}
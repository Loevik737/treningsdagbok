package treningsdagbok;

public class Resultat {
	
	public String ResultatQuery() {
		String HentBestResultat = "SELECT Max(Prestasjon) FROM resultat";
		return HentBestResultat;
	}
}
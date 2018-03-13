import edu.unice.polytech.kis.semwiktionary.model.Word;

public class SynonymsTest {
	
	public static void main(String[] args)
	{

		Word mot = new Word();
		mot = Word.find("voiture");	// database lookup

        if (mot.getSynonyms() != null) 
        {
            for (Word synonymes : mot.getSynonyms()) {
                	// all variants of â€œmot world!â€�â€¦
                //String monchamp =  synonymes.getSynonyms();
                System.out.println(synonymes);

                //System.out.println("Most usually used in the context of: "); // â€¦with the domain (usage context, e.g. â€œsociologyâ€�)â€¦
                //System.out.println(mot.getDefinitions().get(0).getDomains()); // â€¦of their most common meaning
            }
        }


	}
	
	
}



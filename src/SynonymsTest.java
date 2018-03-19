import edu.unice.polytech.kis.semwiktionary.model.Definition;
import edu.unice.polytech.kis.semwiktionary.model.LexicalCategory;
import edu.unice.polytech.kis.semwiktionary.model.Word;

import java.util.ArrayList;

public class SynonymsTest {
	
	public static void main(String[] args)
	{

		Word mot = new Word();
		mot = Word.find(args[0]);	// database lookup

        ArrayList<String> listeMotAffiches = new ArrayList<String>();


        if (mot != null && mot.getSynonyms() != null)
        {

            for (Word synonymes : mot.getSynonyms())
            {
                if (1 == 1)
                {
                    if (!listeMotAffiches.contains(synonymes.getTitle()))
                    {
                        listeMotAffiches.add(synonymes.getTitle());

                        // all variants of â€œmot world!â€�â€¦
                        //String monchamp =  synonymes.getSynonyms();
                        System.out.println(synonymes);

                        //System.out.println("Most usually used in the context of: "); // â€¦with the domain (usage context, e.g. â€œsociologyâ€�)â€¦
                        //System.out.println(mot.getDefinitions().get(0).getDomains()); // â€¦of their most common meaning
                    }
                }

            }
        }else
        {
            System.out.println("Mot inconnu");
        }


	}
	
	
}



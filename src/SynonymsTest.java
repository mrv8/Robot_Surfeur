import edu.unice.polytech.kis.semwiktionary.model.Definition;
import edu.unice.polytech.kis.semwiktionary.model.LexicalCategory;
import edu.unice.polytech.kis.semwiktionary.model.Word;

public class SynonymsTest {
	
	public static void main(String[] args)
	{

		Word mot = new Word();
		mot = Word.find("chienne");	// database lookup


        if (mot != null && mot.getSynonyms() != null)
        {

            for (Word synonymes : mot.getSynonyms())
            {
                if (1 == 1)
                {
                    //Toutes les variantes de synonymes
                    //String monchamp =  synonymes.getSynonyms();
                    System.out.println("---------------------- \n" + "Mot : " + synonymes);

                    //System.out.println("Most usually used in the context of: "); // â€¦with the domain (usage context, e.g. â€œsociologyâ€�)â€¦
                    System.out.println("Domaine d'utilisation : " + synonymes.getDefinitions()); // â€¦of their most common meaning

                    for (Definition uneDef:synonymes.getDefinitions()
                         )
                    {
                        System.out.println("-- \n" + uneDef.toString());
                    }

//                    System.out.println("Position : " + synonymes.getDefinitions().get(0).getPosition());
                }

            }
        }else
        {
            System.out.println("Mot inconnu");
        }


	}
	
	
}



package scoring;

import java.util.ArrayList;
//import Application.Lien;
import java.util.List;

import extraction.Lien;

public class Scoring implements Ponderation{
	
    //private static ArrayList<Integer> positions;
    //private static List<WebElement> AllLinks;
    //private static ArrayList<String> MotCle;
    //private int pos;

    /**
     *
     * @param str
     * @param chaine
     * @return int
     */
    public int compte(String str, String chaine) {
        chaine = chaine+"i";
        String[] tab = chaine.split(str);
        return (tab.length-1);
    }

    /**
     * Récupère le meilleur lien
     * @param list
     * @param motcle
     * @return Lien
     */
    public Lien points(List<Lien> list, List<String> motcle){

        ArrayList<Integer> Points = new ArrayList<Integer>();
        double[] tabPourcentage = new double[list.size()];
        
        ArrayList<Lien> AllLinksWithKeyWord = new ArrayList<Lien>();
        
        
        //ArrayList<Integer> positionsDeChaqueMotCle = new ArrayList<Integer>();
        //ArrayList<Integer> positions = new ArrayList<Integer>();

        for(int i =0; i<list.size();i++)
        {
            Lien LinkChoice = list.get(i);
            String Texte = LinkChoice.getTexte();

            Points.add(i,0);
            	
            //int max = href.length(); // position max du premier mot cle du href
            //positions.add(i,0);
            //positionsDeChaqueMotCle.add(i,0);

            for(int j=0;j<motcle.size();j++)
            {
                Points.set(i, Points.get(i)+compte(motcle.get(j),Texte));

                //positionsDeChaqueMotCle.set(i,href.indexOf(motcle.get(j)));
                //if(positionsDeChaqueMotCle.get(j) < max)
                //   max = positionsDeChaqueMotCle.get(j);
            }
            
            tabPourcentage[i]=pourcentage(nombreMots(Texte),Points.get(i));
			AllLinksWithKeyWord.add(LinkChoice);
		}
		
		return meilleur_lien(tabPourcentage, AllLinksWithKeyWord);
    }

    /**
     * Récupère un indice pour le lien
     * @param tabPourcentage
     * @param AllLinksWithKeyWord
     * @return Lien
     */
	public Lien meilleur_lien(double [] tabPourcentage, ArrayList<Lien> AllLinksWithKeyWord )
	{
		double max = 0.0;
		int indice = 0;
		for(int i = 0; i<tabPourcentage.length; i++)
		{	
			
			if(tabPourcentage[i] > max) 
			{
				max = tabPourcentage[i];
				indice = i;
				
			}
		}
		return AllLinksWithKeyWord.get(indice);
	}

    /**
     * Calcule le nombre de mots dans une chaine
     * @param href
     * @return int
     */
    public int nombreMots(String href) {
        char[] x = new char[href.length()];
        int cmp=1;
        for(int l=0;l<href.length();l++) {
            x[l]=href.charAt(l);
            if((x[l]=='\\') || (x[l]=='*') || (x[l]=='.') || (x[l]=='+') || (x[l]==',') || (x[l]=='?') || (x[l]==']') || (x[l]=='[')
                    || (x[l]==')') || (x[l]=='(') || (x[l]=='}') || (x[l]=='{') || (x[l]==':') || (x[l]=='_') || (x[l]=='#') || (x[l]=='-')
                    || (x[l]=='&') || (x[l]=='!') || (x[l]=='=') || (x[l]=='/'))
                x[l]=' ';
        }
        for(int l=1;l<href.length();l++)
        {
            if((x[l]==' ')&&(x[l-1]!=' '))
                cmp++;
        }
        return cmp;
    }

    /**
     * Calcule le pourcentage
     * @param nombreMot
     * @param nombreMotCle
     * @return double
     */
    public double pourcentage(int nombreMot, int nombreMotCle)
    {
        double res = 0.0;
        res = ((double)nombreMotCle/(double)nombreMot)*100;
        return res;
    }

	@Override
	public Lien RecupLienAleatoire() {
		// TODO Auto-generated method stub
		return null;
	}


}
package scoring;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.WebElement;

import extraction.Lien;
import extraction.Page;

public class Scoring implements Ponderation{
	
	/**
    * @param str
    * @param chaine
    * @return int
    */
    public int compte(String str, String chaine) {
        chaine = chaine+"i";
        String[] tab = chaine.split(str);
        if(tab.length > 1)
        	return 1;
        return 0;
    }

    /**
     * Fonction principal du scoring, ici la fonction va récupérer un lien et faire appelle aux différentes méthodes pour scorer
     * le lien. A la fin la fonction retourne le lien qui sera choisit pour continuer la navigation
     * @param list
     * @param motcle
     * @return Lien
     */
	public Lien points(List<Lien> list, List<String> motcle){

        ArrayList<Integer> Points = new ArrayList<Integer>();
        double[] tabPourcentage = new double[list.size()];
        
        ArrayList<Lien> AllLinksWithKeyWord = new ArrayList<Lien>();
        Lien FinalLink;
        //parcours de la liste des liens récupérés
        for(int i =0; i<list.size();i++)
        {
            Lien LinkChoice = list.get(i);
            String Texte = LinkChoice.getTexte();
            Points.add(i,0);
            //parcous la liste des mots-clés
            for(int j=0;j<motcle.size();j++){
                Points.set(i, Points.get(i)+compte(motcle.get(j),Texte)); //appelle de la méthode qui va attribuer un score au lien
            }
            
            int ptn = Points.get(i);
            //
    		if(ptn == 0)
    			Points.set(i,ptn);
    		else if(ptn == 1)
    			Points.set(i,ptn*1);
    		else if(ptn == 2)
    			Points.set(i,ptn*10);
    		else
    			Points.set(i,ptn*20);
    		
            LinkChoice.setScore(pourcentage(nombreMots(Texte),Points.get(i)));
			AllLinksWithKeyWord.add(LinkChoice);
		}
		
		return FinalLink = meilleur_lien(AllLinksWithKeyWord);
    }
	
    /**
     * Fonction qui va récupérer le lien avec le score maximum parmit la liste des tous les liens scorés.
     * @param list
     * @return Lien
     */
	public Lien meilleur_lien(List<Lien> list )
	{
		double max = 0.0;
		int indice = 0;
		for(int i = 0; i<list.size(); i++)
		{	
			if(list.get(i).getScore()> max) {
				max = list.get(i).getScore();
				indice = i;
			}
		}
		return list.get(indice);
	}

    /**
     * Fonction qui retourne le nombre de mot présent dans l'url ou le champs texte
     * @param href
     * @return int
     */
    public int nombreMots(String href) {
        char[] x = new char[href.length()];
        int cmp=1;
        //Boucle qui permet de remplacer tous les caractères spéciaux par un espace afin de trouver le nombre de mots
        //présent dans un url.
        for(int l=0;l<href.length();l++) {
            x[l]=href.charAt(l);
            if((x[l]=='\\') || (x[l]=='*') || (x[l]=='.') || (x[l]=='+') || (x[l]==',') || (x[l]=='?') || (x[l]==']') || (x[l]=='[')
                    || (x[l]=='}') || (x[l]=='{') || (x[l]==':') || (x[l]=='_') || (x[l]=='#') || (x[l]=='-')
                    || (x[l]=='&') || (x[l]=='!') || (x[l]=='=') || (x[l]=='/'))
                x[l]=' ';
        }
        // Boucle for qui va a chaque espace trouvé augmenté le compteur de 1. 
        //Ce compteur représente le nombre de mots dans le champs texte
        for(int l=1;l<href.length();l++){ 
            if((x[l]==' ')&&(x[l-1]!=' '))
                cmp++;
        }
        return cmp;
    }

    /**
     * Fonction qui calcul le score d'un lien en divisant le nombre de mots-clés trouvés 
     * par le nombre de mots total dans le champs texte
     * @param nombreMot
     * @param nombreMotCle
     * @return double
     */
    public double pourcentage(int nombreMot, int nombreMotCle){
    	
        double res = ((double)nombreMotCle/(double)nombreMot)*100;
        return res;
    }

	@Override
	public Lien RecupLienAleatoire() {
		// TODO Auto-generated method stub
		return null;
	}
}
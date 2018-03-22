package extraction;

import java.util.ArrayList;
import java.util.List;

public class Page {

	private static List<Lien> liensDansLaPage;
	
	/**
	 * 
	 */
	public Page() {
		this.setLiensDansLaPage(new ArrayList<Lien>());
	}
	
	/**
	 * Ajoute un lien dans la page
	 * @param list
	 */
    public static void addLiens (Lien list) {
    	getLiensDansLaPage().add(list);
    }

    /**
     * Efface les liens de la page
     */
    public void clearLiens (){
    	getLiensDansLaPage().clear();
    }

    /**
     * Récupère tous les liens de la page
     * @return List<Lien>
     */
	public static List<Lien> getLiensDansLaPage() {
		return liensDansLaPage;
	}

	/**
	 * ²
	 * @param liensDansLaPage
	 */
	public void setLiensDansLaPage(List<Lien> liensDansLaPage) {
		Page.liensDansLaPage = liensDansLaPage;
	}
	
}

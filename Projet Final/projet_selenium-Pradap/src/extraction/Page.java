package extraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Page {
	
	private static List<Lien> liensDansLaPage;
	
	/**
	 * Constructeur de page
	 */
	public Page() {
		this.setLiensDansLaPage(new ArrayList<Lien>());
	}
	
	/**
	 * Ajoute un lien dans la liste
	 * @param list
	 */
    public static void addLiens (Lien list) {
    	getLiensDansLaPage().add(list);
    }
    
    /**
     * Remove un lien de la liste
     * @param list
     */
    public static void removeLiens (Lien list) {
    	getLiensDansLaPage().remove(list);
    }
    
    /**
     * Efface la liste
     */
    public void clearLiens (){
    	getLiensDansLaPage().clear();
    }

    /**
     * Getter de la liste
     * @return List<Lien>
     */
	public static List<Lien> getLiensDansLaPage() {
		return liensDansLaPage;
	}
	
	/**
	 * Setter de la liste
	 * @param liens
	 */
	public static void setLiensDansLaPage(List<Lien> liens) {
		liensDansLaPage = liens;
	}
	
}

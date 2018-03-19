package extraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Page {

	private static List<Lien> liensDansLaPage;
	
	public Page() {
		this.setLiensDansLaPage(new ArrayList<Lien>());
	}
	
    public static void addLiens (Lien list) {
    	getLiensDansLaPage().add(list);
    }

    public void clearLiens (){
    	getLiensDansLaPage().clear();
    }

	public static List<Lien> getLiensDansLaPage() {
		return liensDansLaPage;
	}

	public void setLiensDansLaPage(List<Lien> liensDansLaPage) {
		this.liensDansLaPage = liensDansLaPage;
	}
	
}

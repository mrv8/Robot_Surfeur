package Application;

public class lien {

	private String url;
	private String texte;

	public lien(String url, String texte) {
		this.url = url;
		this.texte = texte;
	}
	
	public String getUrl(){
		return url;
	}
	
	public String getTexte(){
		return texte;
	}
	
	public void setUrl(String u) {
		url = u;
	}

}

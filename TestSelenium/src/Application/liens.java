package Application;

public class liens {

	private String url;
	private String texte;

	public liens(String url, String texte) {
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

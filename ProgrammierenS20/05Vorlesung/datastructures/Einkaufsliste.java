package datastructures;

public class Einkaufsliste {
	
	String article;
	String menge;
	
	public Einkaufsliste(String article,String menge) {
		this.article = article;
		this.menge = menge;
	}
	
	public void setArticle(String article) {
		this.article = article;
	}
	
	public void setMenge(String menge) {
		this.menge = menge;
	}
	
	public String getArticle() {
		return article;
	}
	
	public String getMenge() {
		return menge;
	}
	
	

}

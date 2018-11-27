package fr.elba.model;

public enum Genre {

	HOMME("m"),
	FEMME("f");
	
	
	 private String genre ;  
     
     private Genre(String genre) {  
         this.genre = genre ;  
    }

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}  
	
}

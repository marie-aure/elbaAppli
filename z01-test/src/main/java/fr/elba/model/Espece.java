package fr.elba.model;

public enum Espece {

	HUMAIN("Humain"),
	FEE("F�e"),
	VAMPIRE("Vampire"),
	LOUPGAROU("Loup Garou"),
	SORCIER("Sorcier"),
	SIRENE("Sir�ne"),
	VEGESIM("V�g�sim"),
	GENIE("G�nie"),
	FANTOME("Fant�me");
	
	 private String espece ;  
     
     private Espece(String espece) {  
         this.espece = espece ;  
    }

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}  
	
}

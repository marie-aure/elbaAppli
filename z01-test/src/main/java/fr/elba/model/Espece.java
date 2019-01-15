package fr.elba.model;

public enum Espece {

	HUMAIN("Humain"),
	FEE("Fée"),
	VAMPIRE("Vampire"),
	LOUPGAROU("Loup Garou"),
	SORCIER("Sorcier"),
	SIRENE("Sirène"),
	VEGESIM("Végésim"),
	GENIE("Génie"),
	FANTOME("Fantôme");
	
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

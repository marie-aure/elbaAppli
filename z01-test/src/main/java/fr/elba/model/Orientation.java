package fr.elba.model;

public enum Orientation {

	HET("hé"),
	HOM("ho");
	
	
	 private String orientation ;  
     
     private Orientation(String orientation) {  
         this.orientation = orientation ;  
    }

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}  
	
}

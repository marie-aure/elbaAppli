package fr.elba.model;

public enum Orientation {

	HET("h�"),
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

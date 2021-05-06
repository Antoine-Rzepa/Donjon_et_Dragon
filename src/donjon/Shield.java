package donjon;


public class Shield {
	
	private String shieldName;
	private int physicalDefence;
	
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Shield() {
		this.shieldName = "Petit bouclier";
		this.physicalDefence = 1;
	}
	
	public Shield(String shieldName, int physicalDefence) {
		this.shieldName = shieldName;
		this.physicalDefence = physicalDefence;
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return  this.shieldName + "\n" +
				"Défence du bouclier + " + this.physicalDefence;
	}

	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public String getShieldName() {
		return shieldName;
	}
	public void setSpellName(String shieldName) {
		this.shieldName = shieldName;
	}
	
	public int getPhysicalDefence() {
		return physicalDefence;
	}
	public void setPhysicalDefence(int physicalDefence) {
		this.physicalDefence = physicalDefence;
	}
	
}
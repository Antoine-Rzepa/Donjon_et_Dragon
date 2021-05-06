package donjon;


public class Philtre {
	
	private String philtreName;
	private int magicalDefence;
	
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Philtre() {
		this.philtreName = "Bouclier magique léger";
		this.magicalDefence = 1;
	}
	
	public Philtre(String philtreName, int magicalDefence) {
		this.philtreName = philtreName;
		this.magicalDefence = magicalDefence;
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return  this.philtreName + "\n" +
				"Défence du philtre + " + this.magicalDefence;
	}
	
	
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public String getPhiltreName() {
		return philtreName;
	}
	public void setPhiltreName(String philtreName) {
		this.philtreName = philtreName;
	}
	
	public int getMagicalDefence() {
		return magicalDefence;
	}
	public void setMagicalDefence(int magicalDefence) {
		this.magicalDefence = magicalDefence;
	}
	
}
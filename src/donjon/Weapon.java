package donjon;


public class Weapon {
	
	private String weaponName;
	private int physicalDamages;
	
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Weapon() {
		this.weaponName = "Epée courte";
		this.physicalDamages = 1;
	}
	
	public Weapon(String weaponName, int physicalDamages) {
		this.weaponName = weaponName;
		this.physicalDamages = physicalDamages;
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return  this.weaponName + "\n" +
				"Dégat de l'arme + " + this.physicalDamages;
	}
	
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public String getWeaponName() {
		return weaponName;
	}
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	
	public int getPhysicalDamages() {
		return physicalDamages;
	}
	public void setPhysicalDamages(int physicalDamages) {
		this.physicalDamages = physicalDamages;
	}
	
}
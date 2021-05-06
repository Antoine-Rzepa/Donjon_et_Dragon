package donjon;


public class Spell{
	
	private String spellName;
	private int magicalDamages;
	
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Spell() {
		this.spellName = "Trait de feu";
		this.magicalDamages = 1;
	}
	
	public Spell(String spellName, int magicalDamages) {
		this.spellName = spellName;
		this.magicalDamages = magicalDamages;
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return  this.spellName + "\n" +
				"Dégat du sort + " + this.magicalDamages;
	}
	
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public String getSpellName() {
		return spellName;
	}
	public void setSpellName(String spellName) {
		this.spellName = spellName;
	}
	
	public int getMagicalDamages() {
		return magicalDamages;
	}
	public void setMagicalDamages(int magicalDamages) {
		this.magicalDamages = magicalDamages;
	}
		
}
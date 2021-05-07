package donjon;

import java.util.Random;

public class Mage extends Personnage{
	
	private int magicalDamages;
	
	private Spell spell = new Spell();
	private Philtre philtre = new Philtre();
		
	Random rand = new Random();
	
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Mage() {
		super();
		super.setImage("mage");
		super.setLife(3 + (int)(Math.random() * ((6 - 3) + 1)));
		this.magicalDamages = 8 + (int)(Math.random() * ((15 - 8) + 1));
	}
	public Mage(String name) {
		super(name);
		super.setImage("mage");
		super.setLife(3 + (int)(Math.random() * ((6 - 3) + 1)));
		this.magicalDamages = 8 + (int)(Math.random() * ((15 - 8) + 1));
	}
	public Mage(String name, int life, int magicalDamages) {
		super(name, life);
		super.setImage("mage");
		this.magicalDamages = magicalDamages;
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return  "-------------------- \n" +
				"Mage " + super.toString() + "\n" +
				super.getLife() + " de Santé \n" +
				this.magicalDamages + " en Dégats magique \n" +
				spell.toString() + "\n" +
				philtre.toString() + "\n" +
				"--------------------";
	}
		
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public int getMagicalDamages() {
		return magicalDamages;
	}
	public void setMagicalDamages(int magicalDamages) {
		this.magicalDamages = magicalDamages;
	}

}
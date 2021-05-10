package donjon;

import java.util.Random;

public class Warrior extends Personnage{
	
	private int physicalDamages;
	
	private Weapon weapon = new Weapon();
	private Shield shield = new Shield();
	
	Random rand = new Random();
	
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Warrior() {
		super();		
		super.setImage("warrior");
		super.setLife(5 + (int)(Math.random() * ((10 - 5) + 1)));
		this.physicalDamages = 5 + (int)(Math.random() * ((10 - 5) + 1));
	}
	public Warrior(String name) {
		super(name);
		super.setImage("warrior");
		super.setLife(5 + (int)(Math.random() * ((10 - 5) + 1)));
		this.physicalDamages = 5 + (int)(Math.random() * ((10 - 5) + 1));
	}
	public Warrior(String name, int life, int physicalDamages) {
		super(name, life);
		super.setImage("warrior");
		this.physicalDamages = physicalDamages;
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return  "Warrior " + super.toString() + "\n" +
				this.physicalDamages + " en Dégats physique \n" +
				weapon.toString() + "\n" +
				shield.toString() + "\n" +
				"--------------------";
	}
	
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public int getPhysicalDamages() {
		return physicalDamages;
	}
	public void setPhysicalDamages(int physicalDamages) {
		this.physicalDamages = physicalDamages;
	}
	@Override
	public void setDamages(int damages) {
		// TODO Auto-generated method stub
		this.setPhysicalDamages(damages);
	}

}
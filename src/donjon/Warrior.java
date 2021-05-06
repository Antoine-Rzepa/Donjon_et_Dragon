package donjon;

import java.util.Random;

public class Warrior{
	
	private String name;
	private String image;
	private int life;
	private int physicalDamages;
	
	Weapon weapon = new Weapon();
	Shield shield = new Shield();
	
	Random rand = new Random();
	
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Warrior() {
		this.name = "";
		for(int i = 0 ; i < (3 + (int)(Math.random() * ((8 - 3) + 1))) ; i++){
		  char c = (char)(rand.nextInt(26) + 97);
		  this.name += c;
		}
		this.image = "Warrior";
		this.life = 5 + (int)(Math.random() * ((10 - 5) + 1));
		this.physicalDamages = 5 + (int)(Math.random() * ((10 - 5) + 1));
	}
	public Warrior(String name) {
		this.name = name;
		this.image = "Warrior";
		this.life = 5 + (int)(Math.random() * ((10 - 5) + 1));
		this.physicalDamages = 5 + (int)(Math.random() * ((10 - 5) + 1));
	}
	public Warrior(String name, int life, int physicalDamages) {
		this.name = name;
		this.image = "Warrior";
		this.life = life;
		this.physicalDamages = physicalDamages;
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return  "-------------------- \n" +
				this.name + " Warrior \n" +
				this.life + " de Santé \n" +
				this.physicalDamages + " en Dégats physique \n" +
				weapon.toString() + "\n" +
				shield.toString() + "\n" +
				"--------------------";
	}
	
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getPhysicalDamages() {
		return physicalDamages;
	}
	public void setPhysicalDamages(int physicalDamages) {
		this.physicalDamages = physicalDamages;
	}

}
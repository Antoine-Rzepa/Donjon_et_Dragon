package donjon;

import java.util.Random;

public class Mage{
	
	private String name;
	private String image;
	private int life;
	private int magicalDamages;
	
	Spell spell = new Spell();
	Philtre philtre = new Philtre();
		
	Random rand = new Random();
	
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Mage() {
		this.name = "";
		for(int i = 0 ; i < (3 + (int)(Math.random() * ((8 - 3) + 1))); i++){
		  char c = (char)(rand.nextInt(26) + 97);
		  this.name += c;
		}
		this.image = "Magicien";
		this.life = 3 + (int)(Math.random() * ((6 - 3) + 1));
		this.magicalDamages = 8 + (int)(Math.random() * ((15 - 8) + 1));
	}
	public Mage(String name) {
		this.name = name;
		this.image = "Magicien";
		this.life = 3 + (int)(Math.random() * ((6 - 3) + 1));
		this.magicalDamages = 8 + (int)(Math.random() * ((15 - 8) + 1));
	}
	public Mage(String name, int life, int magicalDamages) {
		this.name = name;
		this.image = "Magicien";
		this.life = life;
		this.magicalDamages = magicalDamages;
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return  "-------------------- \n" +
				this.name + " Mage \n" +
				this.life + " de Santé \n" +
				this.magicalDamages + " en Dégats magique \n" +
				spell.toString() + "\n" +
				philtre.toString() + "\n" +
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
	public int getMagicalDamages() {
		return magicalDamages;
	}
	public void setMagicalDamages(int magicalDamages) {
		this.magicalDamages = magicalDamages;
	}

}
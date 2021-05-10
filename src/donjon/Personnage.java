package donjon;

import java.util.Random;



abstract public class Personnage {
	
	private String name;
	private int life;
	private String image;
	
	Random rand = new Random();
	
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Personnage() {
		this.name = "";
		for(int i = 0 ; i < (3 + (int)(Math.random() * ((8 - 3) + 1))) ; i++){
		  char c = (char)(rand.nextInt(26) + 97);
		  this.name += c;
		}
	}	
	public Personnage(String name) {
		this.name = name;	
	}
	public Personnage(String name, int life) {
		this.name = name;
		this.life = life;
	}
	
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	abstract public void setDamages(int damages);
 
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return  this.name + "\n" +
				this.life + " de Santé";
	}
	
	
}
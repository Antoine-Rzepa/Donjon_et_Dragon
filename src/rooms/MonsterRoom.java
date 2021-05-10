package rooms;

public class MonsterRoom extends Rooms{

	private String monsterName;

	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public MonsterRoom() {
	
		super.setName("Monstre");
		super.setWelcomeSentence("Quelle est cette monstruosité !!!");
		this.monsterName = "?";
		
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return 	super.toString() + "\n" +
				"Le monstre a combattre est : \n" +
				this.monsterName + "\n" +
				"--------------------";
	}
	
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}
		
}

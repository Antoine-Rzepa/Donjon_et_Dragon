package rooms;

abstract public class Rooms {

	private String name;
	private String welcomeSentence;
	
	
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return 	this.name + "\n" +
				this.welcomeSentence + "\n";
	}
		
	
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWelcomeSentence() {
		return welcomeSentence;
	}

	public void setWelcomeSentence(String welcomeSentence) {
		this.welcomeSentence = welcomeSentence;
	}
	
}

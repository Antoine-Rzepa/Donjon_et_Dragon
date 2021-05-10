package rooms;

public class EmptyRoom extends Rooms{


	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public EmptyRoom() {
	
		super.setName("No Man's land");
		super.setWelcomeSentence("A quoi sert cette pièce au juste ? ...");
	
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return 	super.toString() + "\n" +
				"--------------------";
	}
	
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
		
}

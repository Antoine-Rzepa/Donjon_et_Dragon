package rooms;


public class ObjectRoom extends Rooms{
	
	private String objectName;

	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public ObjectRoom() {
	
		super.setName("Coffre");
		super.setWelcomeSentence("Cette pièce à l'air vide ... eu non regardez un coffre !");
		this.objectName = "?";
		
	}
	
	// -------------------------------------   AFFICHAGE -------------------------------------- //
	public String toString() {
		return 	super.toString() + "\n" +
				"Vous avez trouvé : \n" +
				this.objectName + "\n" +
				"--------------------";
	}
			
	// ------------------------------------- GETTER / SETTER -------------------------------------- //
	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

}

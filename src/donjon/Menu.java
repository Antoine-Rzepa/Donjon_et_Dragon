package donjon;

import java.util.Scanner;  // Import the Scanner class	
import java.util.ArrayList; //import the ArrayList class
import java.util.InputMismatchException;

public class Menu{

	ArrayList<Personnage> allHeroes = new ArrayList<Personnage>();

	Scanner sc;
	// -------------------------------------   CONSTRUCTOR -------------------------------------- //
	public Menu(){
		this.sc = new Scanner(System.in);
	}

	// ---------------------------------------------- RUN THE GAME -----------------------------------------------//
	private void runGame() {

		boolean runGame = true;
		if(runGame && welcome() == true) {
			do {
				System.out.println("----- MENU PRINCIPAL -----");
				System.out.println("1 : Créer un personnage");
				System.out.println("2 : Voir les personnages");
				System.out.println("3 : Quitter le jeu");
				System.out.println("--------------------------");
				String menuSelected = sc.nextLine();
				switch(menuSelected.toLowerCase()) {
				case "1":
					switch(heroChoice()) {
					case "1":
						allHeroes.add(createWarrior());
						break;
					case "2":
						allHeroes.add(createMage());
						break;
					}
					break;
				case "2":
					showAllHeroes();
					break;
				case "3":
					runGame = false;
					System.out.println("A bientôt !");
					break;
				default:
					System.out.println("Saississez une commande valide");
				}
			}while(runGame);		
		}else {
			System.out.println("A bientôt !");
		}
	}

	// ---------------------------------------------- MENU D'ENTREE -----------------------------------------------//
	private boolean welcome() {
		boolean welcome = true;
		boolean gameStarted = false;
		System.out.println("----- BIENVENUE DANS DONJON & DRAGON ! -----");
		System.out.println("1 : Lancer le jeu");
		System.out.println("2 : Quitter le jeu");
		System.out.println("--------------------------------------------");


		//do {

			try {
				int launchgame = sc.nextInt();
				sc.nextLine();
				switch(launchgame) {
				case 1:
					gameStarted = true;				
					break;
				case 2:
					welcome = false;
					break;
				//default:
					//System.out.println("Saississez une commande valide");
				}

			} catch (InputMismatchException e) {	
				sc.nextLine();
				System.out.println("Saississez une commande valide");
			}
		//}while(!gameStarted && welcome);


		return welcome;
	}

	// ---------------------------------------- CHOOSE THE HERO TO CREATE -------------------------------------------//
	private String heroChoice() {
		String heroChoosen = "";
		boolean classChoosen = false;

		System.out.println("----- CLASSE DISPONIBLE -----");
		System.out.println("1 : Guerrier");
		System.out.println("2 : Mage");
		System.out.println("-----------------------------");
		do {
			String heroChoice = sc.nextLine(); 
			switch(heroChoice.toLowerCase()) {
			case "1":
				classChoosen = true;
				System.out.println("Vous avez choisi le Guerrier, préparez vous à taper dans le tas !");
				heroChoosen = "1";
				break;
			case "2":
				classChoosen = true;
				System.out.println("Vous avez choisi le Mage, a vous la connaissance des sorts !");
				heroChoosen = "2";
				break;
			default:
				System.out.println("Saississez une commande valide");
			}
		}while (!classChoosen);
		return heroChoosen;
	}


	// ---------------------------------------------- CREATION GUERRIER -----------------------------------------------//
	private Warrior createWarrior() {
		boolean kindChoosen = false;
		System.out.println("----- TYPE DE CREATION DU PERSONNAGE -----");
		System.out.println("1 : Par défaut");
		System.out.println("2 : Juste par son nom");
		System.out.println("3 : Toutes les statistiques");
		System.out.println("------------------------------------------");
		Warrior warrior = null;		
		do {			
			boolean lifeChoosen = false;
			boolean physicalDamagesChoosen = false;	
			String name ="";
			int life = 0;
			int physicalDamages = 0;	
			String creationKind = sc.nextLine();

			switch(creationKind.toLowerCase()) {			
			case "1":
				warrior = new Warrior();	
				kindChoosen = true;
				break;

			case "2":					
				// ------------------ CHOICE NAME ----------------------- //
				System.out.println("Choisissez le nom de votre personnage :");
				name = sc.nextLine();
				warrior = new Warrior(name);
				kindChoosen = true;
				break;

			case "3":	
				// ------------------ CHOICE NAME ----------------------- //
				System.out.println("Choisissez le nom de votre personnage :");
				name = sc.nextLine();

				// ------------------ CHOICE LIFE ----------------------- //
				System.out.println("Choisissez la vie de votre personnage entre 5 et 10 :");
				do {
					life = sc.nextInt();
					if (life >= 5 && life <= 10) {
						lifeChoosen = true;
					}else {
						System.out.println("Vous devez choisir un valeur entre 5 et 10");
					}
				}while(!lifeChoosen);	

				// ------------------ CHOICE ATK ----------------------- //
				System.out.println("Choisissez la force de votre personnage entre 5 et 10 :");
				do {
					physicalDamages = sc.nextInt();
					if (physicalDamages >= 5 && physicalDamages <= 10) {
						physicalDamagesChoosen = true;
					}else {
						System.out.println("Vous devez choisir un valeur entre 5 et 10");
					}
				}while(!physicalDamagesChoosen);	

				warrior = new Warrior(name, life, physicalDamages);
				kindChoosen = true;
				break;

			default:
				System.out.println("Saississez une commande valide");
			}
		}while(!kindChoosen);

		boolean creationFinished = false;
		do {
			System.out.println("----- FINALISATION DU PERSONNAGE -----");
			System.out.println("1 : Voir le personnage");
			System.out.println("2 : Modifier le personnage");
			System.out.println("3 : Finir la création du personnage");
			System.out.println("--------------------------------------");

			String creationKind = sc.nextLine();
			switch(creationKind.toLowerCase()) {
			case "1":
				System.out.println(warrior.toString());	
				break;
			case "2":				
				boolean editModifyHero = false;

				do {
					System.out.println("----- MENU DE MODIFICATION -----");
					System.out.println("1 : Changer le nom");
					System.out.println("2 : Modifier la vie");
					System.out.println("3 : Modifier les dégats");
					System.out.println("4 : Finir l'édition du personnage");
					System.out.println("--------------------------------");

					String editKind = sc.nextLine();
					switch(editKind.toLowerCase()) {
					case "1":
						System.out.println("Quel nouveau nom voulez vous donner ?");
						String newName;							
						newName = sc.nextLine();
						warrior.setName(newName);
						break;
					case "2":						
						boolean newLifeChoosen = false;
						System.out.println("Quelle nouvelle quantité de vie voulez vous donner ?(de 5 à 10)");
						do {							
							int newLife;							
							newLife = sc.nextInt();
							sc.nextLine();
							if (newLife >= 5 && newLife <= 10) {
								warrior.setLife(newLife);
								newLifeChoosen = true;
							}else {
								System.out.println("Vous devez choisir un valeur entre 5 et 10");
							}
						}while(!newLifeChoosen);
						break;
					case "3":
						boolean newPhysicalDamagesChoosen = false;
						System.out.println("Quelle nouvelle force voulez vous donner ?(de 5 à 10)");
						do {							
							int newPhysicalDamages;
							newPhysicalDamages = sc.nextInt();
							sc.nextLine();
							if (newPhysicalDamages >= 5 && newPhysicalDamages <= 10) {
								warrior.setPhysicalDamages(newPhysicalDamages);
								newPhysicalDamagesChoosen = true;
							}else {
								System.out.println("Vous devez choisir un valeur entre 5 et 10");
							}
						}while(!newPhysicalDamagesChoosen);
						break;
					case "4":
						editModifyHero = true;
						break;
					default:
						System.out.println("Saississez une commande valide");
					}
				}while(!editModifyHero);
				break;
			case "3":
				creationFinished = true;
				break;
			default:
				System.out.println("Saississez une commande valide");
			}
		}while(!creationFinished);
		return warrior;
	}


	// ---------------------------------------------- CREATION MAGE -----------------------------------------------//
	private Mage createMage() {
		boolean kindChoosen = false;
		System.out.println("----- TYPE DE CREATION DU PERSONNAGE -----");
		System.out.println("1 : Par défaut");
		System.out.println("2 : Juste par son nom");
		System.out.println("3 : Toutes les statistiques");
		System.out.println("------------------------------------------");
		Mage mage = null;
		do {
			boolean lifeChoosen = false;
			boolean magicalDamagesChoosen = false;	
			String name ="";
			int life = 0;
			int magicalDamages = 0;	
			String creationKind = sc.nextLine();

			switch(creationKind.toLowerCase()) {			
			case "1":
				mage = new Mage();
				kindChoosen = true;
				break;

			case "2":					
				// ------------------ CHOICE NAME ----------------------- //
				System.out.println("Choisissez le nom de votre personnage :");
				name = sc.nextLine();
				mage = new Mage(name);
				kindChoosen = true;
				break;

			case "3":	
				// ------------------ CHOICE NAME ----------------------- //
				System.out.println("Choisissez le nom de votre personnage :");
				name = sc.nextLine();

				// ------------------ CHOICE LIFE ----------------------- //
				System.out.println("Choisissez la vie de votre personnage entre 3 et 6 :");
				do {
					life = sc.nextInt();
					if (life >= 3 && life <= 6) {
						lifeChoosen = true;
					}else {
						System.out.println("Vous devez choisir un valeur entre 3 et 6");
					}
				}while(!lifeChoosen);	

				// ------------------ CHOICE ATK ----------------------- //
				System.out.println("Choisissez la force de votre personnage entre 8 et 15 :");
				do {
					magicalDamages = sc.nextInt();
					if (magicalDamages >= 8 && magicalDamages <= 15) {
						magicalDamagesChoosen = true;
					}else {
						System.out.println("Vous devez choisir un valeur entre 8 et 15");
					}
				}while(!magicalDamagesChoosen);	

				mage = new Mage(name, life, magicalDamages);
				kindChoosen = true;
				break;

			default:
				System.out.println("Saississez une commande valide");
			}
		}while(!kindChoosen);


		boolean creationFinished = false;

		do {
			System.out.println("----- FINALISATION DU PERSONNAGE -----");
			System.out.println("1 : Voir le personnage");
			System.out.println("2 : Modifier le personnage");
			System.out.println("3 : Finir la création du personnage");
			System.out.println("--------------------------------------");
			String creationKind = sc.nextLine();
			switch(creationKind.toLowerCase()) {
			case "1":
				System.out.println(mage.toString());	
				break;
			case "2":
				boolean editModifyHero = false;
				do {
					System.out.println("----- MENU DE MODIFICATION -----");
					System.out.println("1 : Changer le nom");
					System.out.println("2 : Modifier la vie");
					System.out.println("3 : Modifier les dégats");
					System.out.println("4 : Finir l'édition du personnage");
					System.out.println("--------------------------------");

					String editKind = sc.nextLine();
					switch(editKind.toLowerCase()) {
					case "1":
						System.out.println("Quel nouveau nom voulez vous donner ?");
						String newName;							
						newName = sc.nextLine();
						mage.setName(newName);
						break;
					case "2":						
						boolean newLifeChoosen = false;
						System.out.println("Quelle nouvelle quantité de vie voulez vous donner ?(de 3 à 8)");
						do {
							int newLife;							
							newLife = sc.nextInt();
							if (newLife >= 3 && newLife <= 8) {
								mage.setLife(newLife);
								newLifeChoosen = true;
							}else {
								System.out.println("Vous devez choisir un valeur entre 3 et 8");
							}
						}while(!newLifeChoosen);
						break;
					case "3":
						boolean newMagicalDamagesChoosen = false;
						System.out.println("Quelle nouvelle force voulez vous donner ?(de 8 à 15)");
						do {
							int newmagicalDamages;
							newmagicalDamages = sc.nextInt();
							if (newmagicalDamages >= 8 && newmagicalDamages <= 15) {
								mage.setMagicalDamages(newmagicalDamages);
								newMagicalDamagesChoosen = true;
							}else {
								System.out.println("Vous devez choisir un valeur entre 8 et 15");
							}
						}while(!newMagicalDamagesChoosen);
						break;
					case "4":
						editModifyHero = true;
						break;
					default:
						System.out.println("Saississez une commande valide");
					}
				}while(!editModifyHero);
				break;
			case "3":
				creationFinished = true;
				break;
			default:
				System.out.println("Saississez une commande valide");
			}
		}while(!creationFinished);
		return mage;
	}

	// ------------------------------------------SHOW CARACTERE -----------------------------------------------//

	private void showAllHeroes() {

		for(Personnage personnage : allHeroes) {
			System.out.println(personnage.toString());		
		}

	}

	// ---------------------------------------------- EXECUTION -----------------------------------------------//
	public static void main(String[] args) {

		Menu m = new Menu();
		m.runGame();

	}
}
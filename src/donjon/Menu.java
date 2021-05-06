package donjon;

import java.util.Scanner;  // Import the Scanner class	
import java.util.ArrayList; //import the ArrayList class

public class Menu{

	ArrayList<Warrior> allWarriors = new ArrayList<Warrior>();
	ArrayList<Mage> allMages = new ArrayList<Mage>();
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
				System.out.println("1 : CREATE HERO");
				System.out.println("2 : SHOW HEROES");
				System.out.println("3 : QUIT GAME");
				String menuSelected = sc.nextLine();
				switch(menuSelected.toLowerCase()) {
				case "1":
					switch(heroChoice()) {
					case "1":
						allWarriors.add(createWarrior());
						break;
					case "2":
						allMages.add(createMage());
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
		System.out.println("Bienvenue dans le Donjon !");
		System.out.println("1 : ENTRER GAME");
		System.out.println("2 : QUIT GAME");
		do {
			String launchgame = sc.nextLine(); 
			switch(launchgame) {
			case "1":
				gameStarted = true;				
				break;
			case "2":
				welcome = false;
				break;
			default:
				System.out.println("Saississez une commande valide");	
			}
		}while(!gameStarted && welcome);
		return welcome;
	}

	// ---------------------------------------- CHOOSE THE HERO TO CREATE -------------------------------------------//
	private String heroChoice() {
		String heroChoosen = "";
		boolean classChoosen = false;

		System.out.println("Choississez votre classe :");
		System.out.println("1 : WARRIOR");
		System.out.println("2 : MAGE");
		do {
			String hero = sc.nextLine(); 
			switch(hero.toLowerCase()) {
			case "1":
				classChoosen = true;
				System.out.println("Vous avez choisi le " + hero + ", préparez vous à taper dans le tas !");
				heroChoosen = "1";
				break;
			case "2":
				classChoosen = true;
				System.out.println("Vous avez choisi le " + hero + ", a vous les connaissances des sorts !");
				heroChoosen = "2";
				break;
			default:
				System.out.println("Le choix que vous avez fait n'est pas correct, choississez Guerrier ou Mage");
			}
		}while (!classChoosen);
		return heroChoosen;
	}


	// ---------------------------------------------- CREATION GUERRIER -----------------------------------------------//
	private Warrior createWarrior() {
		boolean kindChoosen = false;
		System.out.println("Création du Guerrier en cours");
		System.out.println("Choississez le type de paramètrage :");
		System.out.println("1 : DEFAULT");
		System.out.println("2 : ONLY NAME");
		System.out.println("3 : ALL STATS");
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
			System.out.println("Que voulez vous faire :");
			System.out.println("1 : SHOW HERO");
			System.out.println("2 : EDIT HERO");
			System.out.println("3 : END CREATION");
			
			String creationKind = sc.nextLine();
			switch(creationKind.toLowerCase()) {
			case "1":
				System.out.println(warrior.toString());	
				break;
			case "2":				
				boolean editModifyHero = false;
				
				do {
					System.out.println("1 : EDIT NAME");
					System.out.println("2 : EDIT LIFE");
					System.out.println("3 : EDIT DAMAGES");
					System.out.println("4 : END EDIT");
					
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
		System.out.println("Création du Mage en cours");
		System.out.println("Choississez le type de paramètrage :");
		System.out.println("1 : DEFAULT");
		System.out.println("2 : ONLY NAME");
		System.out.println("3 : ALL STATS");
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
			System.out.println("Que voulez vous faire :");
			System.out.println("1 : SHOW HERO");
			System.out.println("2 : EDIT HERO");
			System.out.println("3 : END CREATION");
			String creationKind = sc.nextLine();
			switch(creationKind.toLowerCase()) {
			case "1":
				System.out.println(mage.toString());	
				break;
			case "2":
				boolean editModifyHero = false;
				do {
					System.out.println("1 : EDIT NAME");
					System.out.println("2 : EDIT LIFE");
					System.out.println("3 : EDIT DAMAGES");
					System.out.println("4 : END EDIT");
					
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
		for(int i = 0; i < allMages.size(); i++) {
			System.out.println(allMages.get(i).toString());
		}
		for(int i = 0; i < allWarriors.size(); i++) {
			System.out.println(allWarriors.get(i).toString());
		}
	}
	
	// ---------------------------------------------- EXECUTION -----------------------------------------------//
	public static void main(String[] args) {

		Menu m = new Menu();
		m.runGame();

	}
}
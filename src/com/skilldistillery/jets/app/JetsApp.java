package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApp {
	public AirField airField = new AirField();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.run();
	}

	public void run() {
		displayUserMenu();

	}

	public void displayUserMenu() {
		boolean appOn = true;
		while (appOn) {
			System.out.println("Jets Menu:");
			System.out.println("---------------------------------");
			System.out.println("1. List fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all cargo jets");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to Fleet");
			System.out.println("8. Remove a jet from Fleet");
			System.out.println("9. Quit");

			String select = kb.next();

			switch (select) {
			case "1":
				airField.listJets();
				break;
			case "2":
				airField.flyAllJets();
				break;
			case "3":
				airField.viewFastestJet();
				break;
			case "4":
				airField.viewLongestRangeJet();
				break;
			case "5":
				airField.loadAllCargoJets();
				break;
			case "6":
				airField.dogFight();
				break;
			case "7":
				airField.addJet();
				break;
			case "8":
				airField.removeJet();
				break;
			case "9":
				appOn = false;
				kb.close();
				System.out.println("You've chosen to exit the menu. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice, try again.");
				break;
			}

		}

	}

}

package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AirField {
	public List<Jet> fleetList = new ArrayList<>();
	public Scanner kb = new Scanner(System.in);

	public void listJets() {
		BufferedReader list = null;
		try {
			list = new BufferedReader(new FileReader("Jets.txt"));
			String line;
			while ((line = list.readLine()) != null) {
				String[] jetAspects = line.split(", ");
				if (jetAspects[0].equals("Fighter")) {
					FighterJet fighter = new FighterJet(jetAspects[1], Double.parseDouble(jetAspects[2]),
							Integer.parseInt(jetAspects[3]), Long.parseLong(jetAspects[4]));
					fleetList.add(fighter);
				} else if (jetAspects[0].equals("Cargo")) {
					CargoLiner cargo = new CargoLiner(jetAspects[1], Double.parseDouble(jetAspects[2]),
							Integer.parseInt(jetAspects[3]), Long.parseLong(jetAspects[4]));
					fleetList.add(cargo);
				} else if (jetAspects[0].equals("Passenger")) {
					PassengerPlane passenger = new PassengerPlane(jetAspects[1], Double.parseDouble(jetAspects[2]),
							Integer.parseInt(jetAspects[3]), Long.parseLong(jetAspects[4]));
					fleetList.add(passenger);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (list != null) {
				try {
					list.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void flyAllJets() {
		System.out.println("Flying all jets...");
		for (Jet jet : fleetList) {
			jet.fly();
		}

	}

	public void viewFastestJet() {
		double fastestSpeed = 0.0;
		Jet fastestJet = null;
		for (Jet jet : fleetList) {
			if (jet.getSpeed() > fastestSpeed) {
				fastestSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}
		if (fastestJet != null) {
			System.out.println("The fastest Jet in your fleet is: ");
			System.out.println("Model: " + fastestJet.getModel());
			System.out.println("Speed: " + fastestJet.getSpeed());
			System.out.println("Range: " + fastestJet.getRange());
			System.out.println("Price: " + fastestJet.getPrice());
		} else {
			System.out.println("No jets found in the fleet.");
		}
	}

	public void viewLongestRangeJet() {
		int longestRange = 0;
		Jet longestR = null;
		for (Jet jet : fleetList) {
			if (jet.getSpeed() > longestRange) {
				longestRange = jet.getRange();
				longestR = jet;
			}
		}
		if (longestR != null) {
			System.out.println("The fastest Jet in your fleet is: ");
			System.out.println("Model: " + longestR.getModel());
			System.out.println("Speed: " + longestR.getSpeed());
			System.out.println("Range: " + longestR.getRange());
			System.out.println("Price: " + longestR.getPrice());
		} else {
			System.out.println("No jets found in the fleet.");
		}
	}

	public void loadAllCargoJets() {
		for (Jet jet : fleetList) {
			if (jet instanceof Cargo) {
				((Cargo) jet).loadCargo();
			}
		}
	}

	public void addJet() {
		try {
			System.out.println("What kind of Jet would you like to fly?");
			System.out.println("Type 'C' for Cargo, 'F' for Fighter or 'P' for Passenger");
			String choice = kb.next().toUpperCase();
			String jetChoice = "";
			if (choice.equals("C")) {
				jetChoice = "Cargo";
			} else if (choice.equals("F")) {
				jetChoice = "Fighter";
			} else if (choice.equals("P")) {
				jetChoice = "Passenger";
			}

			System.out.println("What is the model of your Jet?");
			String model = kb.next();
			System.out.println("What is the max speed of your Jet?");
			double speed = kb.nextDouble();
			System.out.println("What is the max range your Jet can travel?");
			int range = kb.nextInt();
			System.out.println("What is the price of your Jet?");
			long price = kb.nextLong();
			System.out.println("You've chosen to build a: " + jetChoice + "Model: " + model + "Max Speed: " + speed
					+ "Max range: " + range + "Purchase Price: " + price);

			if (jetChoice.equals("Cargo")) {
				CargoLiner cargo = new CargoLiner(model, speed, range, price);
				fleetList.add(cargo);
			}
			if (jetChoice.equals("Fighter")) {
				FighterJet fighter = new FighterJet(model, speed, range, price);
				fleetList.add(fighter);
			}
			if (jetChoice.equals("Passenger")) {
				PassengerPlane passenger = new PassengerPlane(model, speed, range, price);
				fleetList.add(passenger);
			}

			System.out.println("New jet added to your fleet");
		} catch (InputMismatchException e) {
			System.out.println("Invalid choice. Please enter 'C', 'F', or 'P'.");
		}
	}

	public void removeJet() {
		for (int idx = 0; idx < fleetList.size(); idx++) {
			System.out.println(idx + 1 + ". " + fleetList.get(idx));
		}
		System.out.println("Which jet would you like to remove?");
		int remove = kb.nextInt();
		if (remove < fleetList.size() + 1 && remove > 0) {
			fleetList.remove(remove - 1);

		}
	}

	public void dogFight() {
		for (Jet jet : fleetList) {
			if (jet instanceof Fighter) {
				((Fighter) jet).dogFight();
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

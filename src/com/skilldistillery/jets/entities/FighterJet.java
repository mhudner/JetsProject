package com.skilldistillery.jets.entities;

import java.util.Scanner;

public class FighterJet extends Jet implements Fighter {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void dogFight() {
		try (Scanner kb = new Scanner(System.in)) {
			System.out.println("Target Aquired: would you like to engage? Y/N");
			String userInput = kb.nextLine();

			if (userInput == "Y") {
				System.out.println("FIRE ZE MISSILES!");
			} else {
				System.out.println("What a baby! You should be ashamed!");
			}
		}
	}
}

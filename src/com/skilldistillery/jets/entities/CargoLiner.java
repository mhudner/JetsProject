package com.skilldistillery.jets.entities;

public class CargoLiner extends Jet implements Cargo {

	public CargoLiner(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	}

	@Override
	public void loadCargo() {
		System.out.println("Wide Load, coming through!");

	}

}

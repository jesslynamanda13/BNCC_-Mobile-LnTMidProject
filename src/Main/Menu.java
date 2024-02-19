package Main;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.AutomaticMotorcycle;
import Model.Car;
import Model.Kendaraan;
import Model.ManualMotorcycle;
import Model.MinivanCar;
import Model.Motorcycle;
import Model.SUVCar;
import Model.SupercarCar;



public class Menu {
	protected ArrayList<Kendaraan> kendaraans = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public Menu() {
		int choice;
		while(true) {
			choice = 0;
			System.out.println("1. Input car");
			System.out.println("2. View car");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					inputTransportation();
					break;
				case 2:
					viewInput();
					break;
				}
		}
	}
	
	protected void inputTransportation() {
		// type
		String type = "";
		do {
			System.out.print("Input type [Car | Motorcycle]: ");
			type = sc.nextLine();
		}while(!type.equals("Car") && !type.equals("Motorcycle"));
		
		// brand
		String brand = "";
		do {
			System.out.print("Input brand [>= 5]: ");
			brand = sc.nextLine();
		}while(brand.length() < 5);
		
		// name
		String name = "";
		do {
			System.out.print("Input name [>= 5]: ");
			name = sc.nextLine();
		}while(name.length() < 5);
		
		// license
		String license = "";
		do {
			System.out.print("Input license: ");
			license = sc.nextLine();
		}while(!checkLicenseNumber(license));
		
		// top speed
		int topSpeed = 0;
		do {
			System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
			topSpeed = sc.nextInt();
		}while(topSpeed < 100 || topSpeed > 250);
		
		// gas capacity
		int gasCapacity = 0;
		do {
			System.out.print("Input gas capacity [30 <= gasCap <= 60]:");
			gasCapacity = sc.nextInt();
		}while(gasCapacity < 30 || gasCapacity > 60);
		
		// wheel
		int wheel = 0;
		if(type.equals("Car")) {
			do {
				System.out.print("Input wheel [4 <= wheel <= 6]:");
				wheel = sc.nextInt();
			}while(wheel < 4 || wheel > 6);
		}else if(type.equals("Motorcycle")) {
			do {
				System.out.print("Input wheel [2 <= wheel <= 3]:");
				wheel = sc.nextInt();
			}while(wheel < 2 || wheel > 3);
		}
		
		// type 
		String transType = "";
		if(type.equals("Car")) {
			do {
				System.out.print("Input type [SUV | Supercar | Minivan]: ");
				transType = sc.nextLine();
			}while(!transType.equals("SUV") && !transType.equals("Supercar") && !transType.equals("Minivan"));
		}else if(type.equals("Motorcycle")) {
			do {
				System.out.print("Input type [Automatic | Manual]: ");
				transType = sc.nextLine();
			}while(!transType.equals("Automatic") && !transType.equals("Manual"));
		}
		
		// helm \ ent system
		int helm = 0;
		int entSystem = 0;
		if(type.equals("Car")) {
			do {
				System.out.print("Input entertainment system amount [>= 1]: ");
				entSystem = sc.nextInt();
			}while(entSystem < 1);
		}else if(type.equals("Motorcycle")) {
			do {
				System.out.print("Input helm amount [>= 1]: ");
				helm = sc.nextInt();
			}while(helm < 1);
		}
		
		
		if(type.equals("Car")) {
			if(transType.equals("SUV")) {
				kendaraans.add(new SUVCar(brand, name, license, topSpeed, gasCapacity, wheel, transType, entSystem));
			}else if(transType.equals("Supercar")) {
				kendaraans.add(new SupercarCar(brand, name, license, topSpeed, gasCapacity, wheel, transType, entSystem));
			}else if(transType.equals("Minivan")) {
				kendaraans.add(new MinivanCar(brand, name, license, topSpeed, gasCapacity, wheel, transType, entSystem));
			}
		}else if(type.equals("Motorcycle")) {
			if(transType.equals("Automatic")) {
				kendaraans.add(new AutomaticMotorcycle(brand, name, license, topSpeed, gasCapacity, wheel, transType, helm));
			}else if(transType.equals("Manual")) {
				kendaraans.add(new ManualMotorcycle(brand, name, license, topSpeed, gasCapacity, wheel, transType, helm));
			}
		}
	}
	
	protected void viewInput() {
		if(kendaraans.size() == 0) {
			System.out.println("You haven't added anything yet!");
			return;
		}
		int count = 0;
		for(Kendaraan kend : kendaraans) {
			count++;
			System.out.println(count + ". " + kend.getType() + " " +  kend.getName());
		}
		
		int choice = -1;
		do {
			System.out.println("Pick a vehicle to test drive [0 to exit]: ");
			choice = sc.nextInt();
		}while(choice < 0);
		
		if(choice == 0) {
			return;
		}else {
			Kendaraan kend = kendaraans.get(choice - 1);
			System.out.println("Brand: " + kend.getBrand());
			System.out.println("Name: " + kend.getName());
			System.out.println("License Plate: " + kend.getLicenseNumber());
			System.out.println("Type: " + kend.getType());
			System.out.println("Gas Capacity: " + kend.getGasCap());
			System.out.println("Top Speed: " + kend.getTopSpeed());
			System.out.println("Wheel(s): " + kend.getWheel());
			if(kend  instanceof Car) {
				Car car = (Car) kend;
				System.out.println("Entertainment System: " + car.getEntertainmentSystem());
				car.turningOnSystem();
			}else if(kend instanceof Motorcycle) {
				Motorcycle motor = (Motorcycle) kend;
				System.out.println("Helms: " + motor.getHelm());
				motor.turningOnSystem();
			}
	}
		
	}

	 boolean checkLicenseNumber(String license) {
		 String pattern = "[A-Z] \\d{1,4} [A-Z]{1,3}";
		 Pattern regex = Pattern.compile(pattern);
		 Matcher matcher = regex.matcher(license);

	     return matcher.matches();
	}
	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			Menu menu = new Menu();
			
		}

}

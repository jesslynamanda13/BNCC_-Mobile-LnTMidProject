package Model;

public class SUVCar extends Car {

	public SUVCar(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String type,
			int entertainmentSystem) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel, type, entertainmentSystem);
		// TODO Auto-generated constructor stub
	}

	public void turningOnSystem() {
//		this.turningOnSystem();
		System.out.println("Turning on entertainment ");
		System.out.println("Boosting...");
	}

}

package Model;

public class Car extends Kendaraan {
	protected int entertainmentSystem;

	public Car(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String type, int entertainmentSystem) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel, type);
		this.entertainmentSystem = entertainmentSystem;
	}

	public int getEntertainmentSystem() {
		return entertainmentSystem;
	}

	public void setEntertainmentSystem(int entertainmentSystem) {
		this.entertainmentSystem = entertainmentSystem;
	}
	
	public void turningOnSystem() {
		System.out.println("Turning on entertainment system...");
	}
	
//	abstract void turnOnCar();
}

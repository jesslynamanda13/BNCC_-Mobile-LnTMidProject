package Model;

public class Motorcycle extends Kendaraan {
	protected int helm;
	public Motorcycle(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel,
			String type, int helm) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel, type);
		this.helm = helm;
		// TODO Auto-generated constructor stub
	}
	public int getHelm() {
		return helm;
	}
	public void setHelm(int helm) {
		this.helm = helm;
	}
	
	public void turningOnSystem() {
		System.out.println(name + " is standing!");
	}

}

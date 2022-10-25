
public class Sphere extends CircleSolid {

	//Default constructor
	public Sphere() {
		super();
	}
	
	//Parameterized constructor
	public Sphere(int radius) {
		super(radius);
	}
	
	//Overwritten toString() method
	public String toString() {
		return super.toString() + "Sphere: Volume == " + this.getVolume();
	}
	
	//Return volume of sphere
	public double getVolume() {
		return Math.PI * (4.0/3) * Math.pow(this.radius,3);
	}
}

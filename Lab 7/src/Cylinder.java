
public class Cylinder extends CircleSolid {

	//Attribute
	private double height;
	
	//Default constructor
	public Cylinder() {
		super();
		this.height = 1;
	}
	
	//Parameterized constructor
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	
	//Setter
	public void setHeight(double height) {
		this.height = height;
	}
	
	//Getter
	public double getHeight() {
		return this.height;
	}
	
	//Overwritten toString() method
	public String toString() {
		return super.toString() + "Cylinder: Height == " + this.height + " Volume == " + this.getVolume();
	}
	
	//Return volume of cylinder
	public double getVolume() {
		return this.getArea() * this.height;
	}
}

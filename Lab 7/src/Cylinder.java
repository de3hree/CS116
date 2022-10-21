
public class Cylinder extends CircleSolid {

	public double height = 1;
	
	public Cylinder() {
		super();
		this.height = 1;
	}
	
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	
	public String toString() {
		return super.toString() + "Cylinder: Height == " + this.height + " Volume == " + this.getVolume();
	}
	
	public double getVolume() {
		return this.getArea() * this.height;
	}
}

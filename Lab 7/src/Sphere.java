
public class Sphere extends CircleSolid {

	
	public Sphere() {
		super();
	}
	
	public Sphere(int radius) {
		super(radius);
	}
	
	public double getArea() {
		return super.getArea() * 4;
	}
	
	public String toString() {
		return super.toString() + "Sphere: Volume == " + this.getVolume();
	}
	
	public double getVolume() {
		return Math.PI * (4.0/3) * Math.pow(this.radius,3);
	}
}

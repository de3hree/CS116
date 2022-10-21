
abstract class CircleSolid {

	double radius;
	
	public CircleSolid() {radius = 1;};
	
	public CircleSolid(int radius) {this.radius = radius;};
	
	public void setRadius(double radius) {this.radius = radius;};
	
	public double getRadius() {return this.radius;};
	
	public double getCircumference() {return this.radius * Math.PI * 2;};
	
	public double getArea() {return Math.PI * Math.pow(this.radius,2);};
	
	public String toString() {return "CircleSolid: Radius == " + this.radius + "\n";};
	
	abstract double getVolume();
}


abstract class CircleSolid {

	
	//Attributes
	protected double radius;
	
	//Default Constructor
	public CircleSolid() {radius = 1;};
	
	//Parameterized Constructor
	public CircleSolid(int radius) {this.radius = radius;};
	
	//Setter
	public void setRadius(double radius) {this.radius = radius;};
	
	//Getter
	public double getRadius() {return this.radius;};
	
	//Calculate circumference of circle face
	public double getCircumference() {return this.radius * Math.PI * 2;};
	
	//Calculate area of circle face
	public double getArea() {return Math.PI * Math.pow(this.radius,2);};
	
	//Overwritten toString() method
	public String toString() {return "CircleSolid: Radius == " + this.radius + "\n";};
	
	//Abstract method since there is no formula for a generic "CircleSolid"
	abstract double getVolume();
}

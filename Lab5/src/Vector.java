
public class Vector {

	private static int x;
	private static int y;
	
	//Parameterized constructor
	public Vector(int xval, int yval) {
		x = xval;
		y = yval;
	}
	
	//Unparameterized constructor
	public Vector() {
		x = 0;
		y = 0;
	}
	
	
	//Getters
	public  int getStartPointY() {
		return 0;
	}
	
	public  int getStartPointX() {
		return 0;
	}
	
	public  int getEndPointX() {
		return x;
	}
	
	public  int getEndPointY() {
		return y;
	}

	
	//Uses pythagorean theorem to get length of arc
	public double getLength() {
		return Math.sqrt(Math.pow(Math.abs(getEndPointX()) - Math.abs(getStartPointX()), 2) + 
				         Math.pow(Math.abs(getEndPointY()) - Math.abs(getStartPointX()), 2));
		
	}
	
}

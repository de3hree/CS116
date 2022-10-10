
public class BoundVector extends Vector {

	
	private static int startX;
	private static int startY;
	
	
	//Full parameterized constructor
	public BoundVector(int startX, int endX, int startY, int endY) {
		super(endX,endY);
		BoundVector.startX = startX;
		BoundVector.startY = startY;
	}
	
	//Default start point
	public BoundVector( int endX, int endY) {
		super(endX,endY);
	}
	
	//Unparameterized constructor
	public BoundVector() {
		super(0,0);
	}
	
	//Overrides hard coded parent method
	@Override
	public int getStartPointY() {
		return startX;
	}
	
	//Overrides hard coded parent method
	@Override
	public int getStartPointX() {
		return startY;
	}
	
	
	
}

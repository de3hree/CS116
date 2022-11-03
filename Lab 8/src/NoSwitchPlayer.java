import java.util.Random;

public class NoSwitchPlayer extends Player implements PlayerInterface {

private Random rng = new Random();
	
	public NoSwitchPlayer() {
		
	}
	
	public int selectDoor() {
		this.selectedDoor = rng.nextInt(3) + 1;
		return this.selectedDoor;
	}
	
	public int selectDoorAgain(int openDoor) {
		return this.getSelectedDoor();
		
	}
	
}

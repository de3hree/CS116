import java.util.Random;

public class SwitchPlayer extends Player implements PlayerInterface {

	private Random rng = new Random();
	
	public SwitchPlayer() {
		
	}
	
	public int selectDoor() {
		this.selectedDoor = rng.nextInt(3) + 1;
		return this.selectedDoor;
	}
	
	public int selectDoorAgain(int openDoor) {
		this.selectedDoor =  this.getSelectedDoor() ^ openDoor;
		return this.selectedDoor;
	}
}

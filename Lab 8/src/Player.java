public abstract class Player {
	// Player's prize location door "guess"
	protected int selectedDoor;
	
	// Make initial prize location "guess"
	public abstract int selectDoor();
	
	// Returns current prize location
	// "guess" / selection
	public int getSelectedDoor(){
		return this.selectedDoor;
	}
	
	// Given the actual prize location (integer door number)
	// this method returns true if player's selected door
	// is the same, false otherwise
	public boolean won(int prizeLocation){
		if (this.selectedDoor == prizeLocation){
			return true;
		} else {
			return false;
		}
	}
}


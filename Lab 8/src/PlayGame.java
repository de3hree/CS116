public class PlayGame {
	public static void main(String[] arguments){
		// Set up number of plays
		int numberOfPlays = 1000000;
		
		// Set up an array of win counters for three players
		int [] wins = new int [3];

		// Instantiate the game object (and reset the game)
		Game myGame = new Game();
		
		// Instantiate three players with different strategies
		SwitchPlayer P1 = new SwitchPlayer();
		NoSwitchPlayer P2 = new NoSwitchPlayer();
		RandomSwitchPlayer P3 = new RandomSwitchPlayer();
		
		// Repeat the game numberOfPlays times
		for(int i = 0; i < numberOfPlays; i++){
			// Player with SWITCH Strategy turn:
			// Make initial door selection
			P1.selectDoor();
			
			// Make second selection knowing which door is open
			P1.selectDoorAgain(myGame.getOpenDoor(P1.getSelectedDoor()));
			// If won - update corresponding counter
			if(P1.won(myGame.getPrizeLocation())){
				wins[0]++;
			}
			
			// Player with NO SWITCH Strategy turn:
			// Make initial door selection
			P2.selectDoor();
			
			// Make second selection knowing which door is open
			P2.selectDoorAgain(myGame.getOpenDoor(P2.getSelectedDoor()));
			// If won - update corresponding counter
			if(P2.won(myGame.getPrizeLocation())){
				wins[1]++;
			}

			// Player with RANDOM Strategy turn:
			// Make initial door selection
			P3.selectDoor();
			
			// Make second selection knowing which door is open
			P3.selectDoorAgain(myGame.getOpenDoor(P3.getSelectedDoor()));
			// If won - update corresponding counter
			if(P3.won(myGame.getPrizeLocation())){
				wins[2]++;
			}
			
			// All three players played the game - time to reset it.
			myGame.reset();
		}
		
		// Display results
		System.out.println("Switch strategy %: \t\t" + (100*(double)wins[0]/(double)numberOfPlays));
		System.out.println("NoSwitch strategy %: \t" + (100*(double)wins[1]/(double)numberOfPlays));
		System.out.println("Random Switch strategy %: \t" + (100*(double)wins[2]/(double)numberOfPlays));		
	}
}

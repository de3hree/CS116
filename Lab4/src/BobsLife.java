
public class BobsLife {

	//Unparameterized attributes
	private static int time = 0;
	private static boolean isDead = false;
	private static boolean isJail = false;
	private static String currLocation = "home";
	
	//Parameterized attributes
	private static int hunger;
	private static int fitness;
	private static int dollars;
	
	//Default constructor
	public BobsLife() {
		setHunger(0);
		setFitness(1);
		setDollars(3);
		
	}
	
	
	//Parameterized constructor
	public BobsLife(int hunger, int fitness, int money) {
		setHunger(hunger);
		setFitness(fitness);
		setDollars(money);
	}
	
	
	//Overwrite toString()
	public String toString() {
		String hungryString = (hunger >= 3) ? "famished":"satisfied";
		String bmiString = (fitness <= 3) ? "unhealthy":"lean";
		String broknessString = (dollars <= 3) ? "impovershied":"bustling";
		String grammerString = (currLocation.equals("gym")) ? " the":" " ;
		
		
		
		
		String result = 
				"The atomic time of the universe is " + time + ".\n"+
				"He is currently at" + grammerString + currLocation + ".\n" +
				"He appears to be " + hungryString + ".(" + hunger + ")\n" + 
				"His wallet seems to be " + broknessString + ".(" + dollars + ")\n" +
				"On closer inspection he seems to be quite " + bmiString +".(" + fitness + ")\n" ;
		
		if(isDead) {
			result = 
					"The atomic time of the universe is " + time + ".\n"+
					"Bob is six-feet under. (dead)\n" +
					"He appears to be " + hungryString + ".(" + hunger + ")\n" + 
					"His wallet seems to be " + broknessString + ".(" + dollars + ")\n" +
					"On closer inspection he seems to be quite " + bmiString +".(" + fitness + ")\n" ;
		} else if(isJail) {
			result = 
					"The atomic time of the universe is " + time + ".\n"+
					"Bob is in jail for deciding to be broke. (jailed)\n" +
					"He appears to be " + hungryString + ".(" + hunger + ")\n" + 
					"His wallet seems to be " + broknessString + ".(" + dollars + ")\n" +
					"On closer inspection he seems to be quite " + bmiString +".(" + fitness + ")\n" ;
		}
		
		return result;
	}
	
	
	/**Hunger setter
	 * 
	 * @param delta, positive for increase and negative for decrease
	 */
	private static void setHunger(int delta) {
		hunger += delta;
		if (hunger < 0) {
			hunger = 0;
		} else if (hunger > 6) {
			isDead = !isDead;
		}
	}
	
	/**Fitness setter
	 * 
	 * @param delta, positive for increase and negative for decrease
	 */
	private static void setFitness(int delta) {
		fitness += delta;
		if (fitness <= 0) {
			isDead = !isDead;
		} 
	}
	
	/**Money setter
	 * 
	 * @param delta, positive for increase and negative for decrease
	 */
	private static void setDollars(int delta) {
		dollars += delta;
		if (dollars < 0) {
			isJail = !isJail;
		} 
	}
	
	//Changes location of Bob in preparation for the nextTime() method
	public void move(String location) {
		if(isDead || isJail) {
			return;
		}
		
		location = location.replaceAll(" ", "").toLowerCase();
		if(location.equals("home")) {
			currLocation = location;
		} else if(location.equals("gym")) {
			currLocation = location;
		} else if(location.equals("work")) {
			currLocation = location;
		} else {
			currLocation = "home";
		}
	}
	
	public void nextTime() {
		if(isDead || isJail) {
			return;
		}
		
		if (currLocation.equals("home")) {
			setHunger(-3);
			setDollars(-1);
		} else if (currLocation.equals("work")) {
			setHunger(2);
			setFitness(-1);
			setDollars(3);
		} else {
			setHunger(3);
			setFitness(2);
			setDollars(-2);
		}
		time += 1;
	}
	
}


public class IDDatabase {

	//Unparameterized attributes
	private int numberOfIDs = 0;
	
	//Parameterized attributes
	private final int  MAX_DATABASE_SIZE;
	private StudentID[] IDList;
	
	//Default constructor
	public IDDatabase() {
		MAX_DATABASE_SIZE = 5;
		IDList = new  StudentID[MAX_DATABASE_SIZE];
	}
	
	
	//Parameterized constructor
	public IDDatabase(int databaseSize) {
		
		//Checks if the provided database size is positive and then insantiates the size of the array representing the ID database
		if(databaseSize >= 0) {
			MAX_DATABASE_SIZE = databaseSize;
			IDList = new  StudentID[MAX_DATABASE_SIZE];
		} else {
			MAX_DATABASE_SIZE = 5;
			IDList = new  StudentID[MAX_DATABASE_SIZE];
		}
		
	}
	
	//Getter
	public int getnumberOfIDs() {
		return numberOfIDs;
	}
	
	//Adds new StudentID objects to the "database"
	public boolean add(StudentID ID) {
		
		if(numberOfIDs >= MAX_DATABASE_SIZE) { //Checks if the max size has been reached
			return false;
		} else if(ID.getANumber().equals("INVALID")) { //Checks if the ID has an invalid ANumber
			return false;
		} else if(ID.getFirstName().equals("INVALID") || ID.getLastName().equals("INVALID")) {//All ID's with 'null' or an empty string have 'INVALID' as these fields
			return false;
		}
		IDList[numberOfIDs] = ID; //Update array and current array index
		numberOfIDs += 1;
		return true;
	}
	
	//Prints the list of names in the database
	public void listNames() {
		if(IDList.length < 1) { //If the database has no entries, the method prints the error and exits
			System.out.println("ERROR: empty database.");
			return;
		}
		for(int x  = 0; x < IDList.length; x++) {//Loop through all entries and print the relevant data
			System.out.println("ID " + x + ": " + IDList[x].getFirstName() + " " + IDList[x].getLastName());
		}
		System.out.println();//Spacing print
		
	}
	
	//Returns a string of all the toString() methods of the stored StudentID classes
	public String toString() {
		String result = "Database:\n";
		for(int x  = 0; x < IDList.length; x++) {
			result += IDList[x] + "\n\n";
		}
		
		return result;
		
	}
	
		
		
	
}

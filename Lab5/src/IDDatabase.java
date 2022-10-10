
public class IDDatabase {

	private int numberOfIDs = 0;
	private final int  MAX_DATABASE_SIZE;
	private StudentID[] IDList;
	
	public IDDatabase() {
		MAX_DATABASE_SIZE = 5;
		IDList = new  StudentID[MAX_DATABASE_SIZE];
	}
	
	public IDDatabase(int databaseSize) {
		
		if(databaseSize >= 0) {
			MAX_DATABASE_SIZE = databaseSize;
			IDList = new  StudentID[MAX_DATABASE_SIZE];
		} else {
			MAX_DATABASE_SIZE = 5;
			IDList = new  StudentID[MAX_DATABASE_SIZE];
		}
		
	}
	
	
	public int getnumberOfIDs() {
		return numberOfIDs;
	}
	
	public boolean add(StudentID ID) {
		if(numberOfIDs >= MAX_DATABASE_SIZE) {
			return false;
		} else if(ID.getANumber().equals("INVALID")) {
			return false;
		} else if(ID.getFirstName().equals("INVALID") || ID.getLastName().equals("INVALID")) {
			return false;
		}
		IDList[numberOfIDs] = ID;
		numberOfIDs += 1;
		return true;
	}
	
	
	public void listNames() {
		if(IDList.length < 1) {
			System.out.println("ERROR: empty database.");
			return;
		}
		for(int x  = 0; x < IDList.length; x++) {
			System.out.println("ID " + x + ": " + IDList[x].getFirstName() + " " + IDList[x].getLastName());
		}
		System.out.println();
		
	}
	
	public String toString() {
		String result = "Database:\n";
		for(int x  = 0; x < IDList.length; x++) {
			result += IDList[x] + "\n\n";
		}
		
		return result;
		
	}
	
		
		
	
}

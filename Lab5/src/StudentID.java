
public class StudentID {

	//Static attributes
	private static final String INSTITUTION_NAME = "Illinois Tech";
	
	//Parameterized attributes
	private final String ANumber;
	private final String firstName;
	private final String lastName;
	
	//Parameterized constructor
	public StudentID(String Anumber, String first, String last){
		if(Anumber.equals("") || Anumber.equals(null) || first.equals("") || first.equals(null) || last.equals("") || last.equals(null)) {
			
			this.ANumber = "INVALID";
			this.firstName = "INVALID";
			this.lastName = "INVALID";
		} else {
			this.ANumber = Anumber;
			this.firstName = first;
			this.lastName = last;
			
		}
	}
	
	//Unparameterized constructor
	public StudentID(){
		this.ANumber = "INVALID";
		this.firstName = "INVALID";
		this.lastName = "INVALID";
	}
	
	
	
	public String toString() {
		
		String result = StudentID.INSTITUTION_NAME + 
						"\nStudent ID\n" +
						this.firstName + "\n" +
						this.lastName + "\n" +
						this.ANumber;
		
		return result;
	}
	
	//Getters
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getANumber() {
		return ANumber;
	}
	
	public String getInstitution() {
		return StudentID.INSTITUTION_NAME;
	}
}

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StreamingSystem {

	private Scanner input = new Scanner(System.in);
	private static File DB = new File("userDB.csv");
	private static Scanner userDB;
	private int userNumber = 0;
	private static User currentUser = null;
	
	ArrayList<User> userList = new ArrayList<User>();
	
	public StreamingSystem() {
		this.loadDB();
		
	}
	
	public int menuChoice() {
		try {
			System.out.print("Choice : ");
			userNumber = input.nextInt();
			return userNumber;
		} catch(InputMismatchException e) {
			input = new Scanner(System.in);
			return -1;
		}
		
	}
	
	private void loadDB() {
		try {
			System.out.print(DB);
			userDB = new Scanner(DB);
			while(userDB.hasNextLine()) {
				String inLine = userDB.nextLine();
				if(inLine != null) {
					String [] splitLine = inLine.split(",");
					
					if (splitLine != null && splitLine.length == 1) {
						String name = splitLine[0].substring(0);
						User tempUser = new User(name);
						tempUser.getPlaylist().load(name + "Playlist.csv");
						userList.add(tempUser);
					} else {
						System.out.println("ERROR: Inconsistent or no data read (" + inLine + ").");
					}
				}	
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("No user db omegalul");
		}
	}
	
	private static void displayMenu() {
		if(currentUser != null) {
			System.out.println(
				"\nChoose from the choices below: \n" +
				"  1. Add recording to playlist \n" +
				"  2. Add playlist from a file  \n" +
				"  3. Add playlist from another user  \n" +
				"  4. Remove recording from playlist \n" +
				"  5. Play single recording on playlist \n" +
				"  6. Play entire playlist \n" +
				"  7. Shuffle entire playlsit \n" +
				"  8. Save entire playlist to file \n" +
				"  9. Display playlist information \n" +
				"  10. Logout");
		} else {
			System.out.println(
				"\nChoose from the choices below: \n" +
				"  1. Add user \n" +
				"  2. Remove user  \n" +
				"  3. List all users \n" +
				"  4. Login to user \n" + 
				"  5. Save users and Exit");
		}
	}
	
	public void startChoices() {
		while(userNumber != 5 || currentUser != null) {
			displayMenu();
			actions();
		}
		
	}
	
	private void actions() {
		if (currentUser == null) {
			switch(this.menuChoice()) {
			case(1):
				addUser();
				break;
			case(2):
				removeUser();
				break;
			case(3):
				listUsers();
				break;
			case(4):
				login();
				break;
			case(5):
				//Try block to catch any errors from opening the files 
				try {
					//File writer to pass to the buffer writer, the buffer writer is utilized for better performance 
					//   (although that doesn't really matter on such a small data set)
					FileWriter saveFile = new FileWriter(DB.getAbsoluteFile());
					BufferedWriter buffer = new BufferedWriter(saveFile);
					
					//Save each string representation of the User object in UserList to the csv file in the order that they are read from the file
					//  This over writes any data previously in the file
					for(int i = 0; i < userList.size(); i++) {
						System.out.println("Saving " + userList.get(i).toString());
						buffer.write(userList.get(i).toString());
						buffer.write("\n");
					}
					buffer.close();
				} catch (IOException e) {
					System.out.print("There was an error with saving the user database.\n\tPlease make sure that the file was not deleted and is closed.");
				}
				break;	
			default:
				System.out.print("Number entered is an invalid choice, please try again.");
				break;
			}
		} else {
			switch(this.menuChoice()) {
			case(1):
				addRecording();
				break;
			case(2):
				addPlaylist();
				break;
			case(3):
				addPlaylist();
				break;
			case(4):
				removeRecoring();
				break;
			case(5):
				playRecording();
				break;
			case(6):
				playPlaylist();
				break;
			case(7):
				shufflePlaylist();
				break;
			case(8):
				savePlaylist();
				break;
			case(9):
				showPlaylist();
				break;
			case(10):
				this.currentUser = null;
				System.out.println("Logged out");
				break;	
			default:
				System.out.print("Number entered is an invalid choice, please try again.");
				break;
			}
		}
	}
	
	private void addRecording() {
		
		System.out.println("What is the artist's name? : ");
		String artist = input.next();
		System.out.println("What is the recording's name? : ");
		String name = input.next();
		System.out.println("What is the duration in seconds? : ");
		int duration = input.nextInt();
		
		
		System.out.println("Is the recording video or just audio? (Enter a or v) : ");
		if(input.next().toLowerCase().equals("v")) {
			System.out.println("What is the framerate in decimal? : ");
			double framerate = input.nextDouble();
			this.currentUser.getPlaylist().add(new VideoRecording(artist,name,duration,framerate));
		} else if(input.next().toLowerCase().equals("a")) {
			System.out.println("What is the bitrate in decimal? : ");
			double bitrate = input.nextDouble();
			this.currentUser.getPlaylist().add(new AudioRecording(artist,name,duration,bitrate));
		} else {
			System.out.println("ERROR: Input is out of scope.");
		}
		
	}
	
	private void removeRecoring() {
		System.out.println("Remove by name or ID ? (Enter n or i) : ");
		if(input.next().toLowerCase().equals("n")) {
			System.out.println("What is the song name? : ");
			String name = input.next();
			//TODO
		} else if(input.next().toLowerCase().equals("i")) {
			System.out.println("What is the song index? : ");
			int id = input.nextInt();
			//TODO
		} else {
			System.out.println("ERROR: Input is out of scope.");
		}
	}
	
	private void addPlaylist() {
		System.out.println("Is the playlist stored as another users or in a file? (U/F): ");
		String locationAnswer = input.next();
		if(locationAnswer.toLowerCase().equals("u")) {
			//TODO
		} else if(locationAnswer.toLowerCase().equals("f")) {
			//TODO
		}
			
	}
	
	private void savePlaylist() {
		try {
			userDB = new Scanner(DB);
			userList.indexOf(currentUser);
			
		} catch (FileNotFoundException e) {
			System.out.println("DB lost");
		}
		
	}
	
	private void playPlaylist() {
		currentUser.getPlaylist().play();
	}
	
	private void shufflePlaylist() {
		currentUser.getPlaylist().shuffle(currentUser.getPlaylist().size());
	}
	
	private void showPlaylist() {
		System.out.println(currentUser.getPlaylist());
	}
		
	private void playRecording() {
			System.out.println("What is the name of the song or ID of the song?");
			try {
				String response = input.next();
				Integer.parseInt(response);
			} catch(NumberFormatException e) {
				
				
			}
	}
	
	private void addUser() {
		System.out.print("\nPlease enter the new user's name: ");
		try {
			String inputName = this.input.next();
			userList.add(new User(inputName));
		} catch(InputMismatchException e) {
			System.out.println("Wrong input for name, please try again.");
			this.input = new Scanner(System.in);
		}
	}
	
	private void removeUser() {
		System.out.print("\nPlease enter the user name of the account to remove: ");
		try {
			//Strip the input to ignore extra whitespace
			String inputName = this.input.next().strip();
			
			//Go through every user, since they aren't sorted, and check if the user exists via the user name
			for(int i = 0; i < userList.size();i++) {
				
				//Upon a match remove the user from the list and their associated playlist, if they have one
				if(userList.get(i).getUsername().toUpperCase().equals(inputName.toUpperCase())) {
					userList.remove(i);
					System.out.println("\nUser successfully removed.");
					File removePlaylist = new File(inputName + "Playlist.csv");
					removePlaylist.delete();
					return;
				}
			}
			System.out.println("\nERROR: User not found.");
			return;
		} catch(InputMismatchException e) { //If user does not exist, reset the scanner and inform the user
			System.out.println("Wrong input for name, please try again.");
			this.input = new Scanner(System.in);
		}
		
	}
	
	private void listUsers() {
		System.out.println("List of users:");	
		;
		for(int i = 0; i < this.userList.size(); i++) {
			System.out.println("\t" + userList.get(i));
			
		}
	}
	
	private void login() {
		System.out.print("\nPlease enter the user name of the account to login to: ");
		try {
			String inputName = this.input.next().strip();
			for(int i = 0; i < userList.size();i++) {
				if(userList.get(i).getUsername().toUpperCase().equals(inputName.toUpperCase())) {
					currentUser = userList.get(i);
					System.out.println("\nLogged in.");
					return;
				}
			}
			System.out.println("\nERROR: User not found.");
		} catch(InputMismatchException e) {
			System.out.println("Wrong input for name, please try again.");
			this.input = new Scanner(System.in);
		}
		
	}
	
	
}

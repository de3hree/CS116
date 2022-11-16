import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StreamingSystem {

	private Scanner input = new Scanner(System.in);
	private static File DB = new File("BillboardHot100.csv");
	private static Scanner userDB;
	private int userNumber = 0;
	static boolean isLogged = false;
	User currentUser = null;
	
	ArrayList<User> userList = new ArrayList<User>();
	
	public StreamingSystem() {
		
	}
	
	public int menuChoice() {
		System.out.print("Choice : ");
		userNumber = input.nextInt();
		return userNumber;
	}
	
	private static void loadDB() {
		try {
			userDB = new Scanner(DB);
			while(userDB.hasNextLine()) {
				String inLine = userDB.nextLine();
				if(inLine != null) {
					String [] splitLine = inLine.split(",");
					
					if (splitLine != null && splitLine.length == 2) {
						if (splitLine[0]. || splitLine[0].equals("V")) {
							String name = splitLine[1];
							int id = Integer.parseInt(splitLine[0]);
							try {
															
							} catch (NumberFormatException nfe){
								System.out.println("ERROR: Number format exception. Recording rejected (" + line + ").");
							}
						} else {
							System.out.println("ERROR: Unknown recording type data (" + line + ").");
						}
						
					} else {
						System.out.println("ERROR: Inconsistent or no data read (" + line + ").");
					}
				}
					
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println("No user db omegalul");
		}
	}
	
	private static void displayMenu() {
		if(isLogged) {
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
				"  5. Exit");
		}
	}
	
	public void startChoices() {
		while(userNumber != 5 || isLogged) {
			displayMenu();
			actions();
		}
		
	}
	
	private void actions() {
		if (!isLogged) {
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
				this.isLogged = false;
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
		System.out.println("");
	}
	
	private void savePlaylist() {
		
	}
	
	private void playPlaylist() {
		
	}
	
	private void shufflePlaylist() {
		
	}
	
	private void showPlaylist() {
		
	}
		
	private void playRecording() {
			
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
			String inputName = this.input.next();
			System.out.print(inputName);
			for(int i = 0; i < userList.size();i++) {
				if(userList.get(i).getUsername().equals(inputName)) {
					userList.remove(i);
					System.out.println("\nUser successfully removed.");
				} else {
					System.out.println("\nERROR: User not found.");
				}
			}
		} catch(InputMismatchException e) {
			System.out.println("Wrong input for name, please try again.");
			this.input = new Scanner(System.in);
		}
		
	}
	
	private void listUsers() {
		for(int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
	}
	
	private void login() {
		System.out.print("\nPlease enter the user name of the account to login to: ");
		try {
			String inputName = this.input.next();
			for(int i = 0; i < userList.size();i++) {
				if(userList.get(i).getUsername().equals(inputName)) {
					currentUser = userList.get(i);
					System.out.println("\nLogged in.");
					isLogged = true;
				} else {
					System.out.println("\nERROR: User not found.");
				}
			}
		} catch(InputMismatchException e) {
			System.out.println("Wrong input for name, please try again.");
			this.input = new Scanner(System.in);
		}
		
	}
	
	
}

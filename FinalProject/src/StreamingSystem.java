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
				System.out.println("Please enter the file name: ");
				String fileName = input.next();
				addPlaylist(null,fileName);
				break;
			case(3):
				System.out.println("Please enter the user name: ");
				String name = input.next();
				addPlaylist(name,null);
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
		//Branch between two inputs
		System.out.println("Remove by name or ID ? (Enter n or i) : ");

		//User input
		String choice = input.next();
		
		if(choice.toLowerCase().equals("n")) {
			System.out.print("What is the song name? : ");
			String name = "";
			
			//Made new scanner due to the delimiter on the default being any whitespace, 
			//    making it impossible to search for songs with whitespace in the name
			Scanner songName = new Scanner(System.in);
			
			name = songName.nextLine();
			
			//Also closing the scanner here closes the System.in stream, for some reason, so memory leak I guess
			
			//The "findSong" returns a -1 if the song does not exist
			int songInd = currentUser.getPlaylist().findSong(name);
			if(songInd >= 0) {
				currentUser.getPlaylist().remove(songInd);
			} else {
				System.out.print("Song does not exist in playlist. Please try again.");
			}
		} else if(choice.strip().toLowerCase().equals("i")) {
			System.out.println("What is the song index? : ");
			int id = input.nextInt();
			//Check to see if the id is valid, if not do nothing and inform the user
			if(-1 <  id && id < currentUser.getPlaylist().size()) {
				currentUser.getPlaylist().remove(id);
			} else {
				System.out.print("Id was out of range for playlist. Please try again.");
			}
		} else {
			System.out.println("ERROR: Input is out of scope. Please type either 'n or 'i'.");
		}
	}
	
	private void addPlaylist(String name, String fileName) {
		
		if(name != null) {
			for(int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getUsername().toLowerCase().equals(name.toLowerCase())) {
					currentUser.getPlaylist().load(name.strip().toLowerCase() + "Playlist.csv");
				}
			}
			
		} else {
			File songFile = new File(fileName);
			if(songFile.exists()) {
				currentUser.getPlaylist().load(songFile.getAbsolutePath());
			} else {
				System.out.println("The entered file does not exist.");
			}
			
		}
		
			
	}
	
	private void savePlaylist() {
		//Catches general errors for accessing a file to write
		try {
			FileWriter saveFile = new FileWriter(new File(currentUser.getUsername() + "Playlist.csv"));
			BufferedWriter save = new BufferedWriter(saveFile);
			
			//For every entry stored in the recordingList array of the current user's play list, append the values in a csv friendly format
			for(int i = 0; i < currentUser.getPlaylist().size(); i++) {
				if(currentUser.getPlaylist().getRecordings().get(i) instanceof AudioRecording) {
				}
				save.write(currentUser.getPlaylist().getRecordings().get(i).getType() + ",");
				save.write(currentUser.getPlaylist().getRecordings().get(i).getName() + ",");
				save.write(currentUser.getPlaylist().getRecordings().get(i).getartist() + ",");
				save.write(currentUser.getPlaylist().getRecordings().get(i).getDuration() + ",");
				save.write(currentUser.getPlaylist().getRecordings().get(i).getQuality() + "\n");
			}
			//Close buffer to write to file
			save.close();
		} catch(IOException e) {
			//I always forger to close the file so here is the reminder, also notifies the user of error
			System.out.println("ERROR: File did not save. Make sure that it is not open and in the directory.");
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
		//Branch between two inputs
				System.out.println("Remove by name or ID ? (Enter n or i) : ");

				//User input
				String choice = input.next();
				
				if(choice.toLowerCase().equals("n")) {
					System.out.print("What is the song name? : ");
					String name = "";
					
					//Made new scanner due to the delimiter on the default being any whitespace, 
					//    making it impossible to search for songs with whitespace in the name
					Scanner songName = new Scanner(System.in);
					
					name = songName.nextLine();
					
					//Also closing the scanner here closes the System.in stream, for some reason, so memory leak I guess
					
					//The "findSong" returns a -1 if the song does not exist
					int songInd = currentUser.getPlaylist().findSong(name);
					if(songInd >= 0) {
						currentUser.getPlaylist().getRecordings().get(songInd).play();;
					} else {
						System.out.print("Song does not exist in playlist. Please try again.");
					}
				} else if(choice.strip().toLowerCase().equals("i")) {
					System.out.println("What is the song index? : ");
					int id = input.nextInt();
					//Check to see if the id is valid, if not do nothing and inform the user
					if(-1 <  id && id < currentUser.getPlaylist().size()) {
						currentUser.getPlaylist().getRecordings().get(id).play();
					} else {
						System.out.print("Id was out of range for playlist. Please try again.");
					}
				} else {
					System.out.println("ERROR: Input is out of scope. Please type either 'n or 'i'.");
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

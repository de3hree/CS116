import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Playlist{
	private String name;
	private int durationInSeconds = 0;
	private ArrayList<Recording> recordingList;
	
	// Non-parametrized constructor
	Playlist(){
		this.name = "Unknown";
		this.recordingList = new ArrayList<Recording>();
	}
	
	// Parametrized constructor
	Playlist(String name){
		// Check if arguments are valid...
		if (name != null){
			// ...if yes, use them to set attribute values
			this.name = name;
			this.recordingList = new ArrayList<Recording>();
		} else {
			// ...if not, fall back on non-parametrized constructor behavior
			this.name = "Unknown";
			this.recordingList = new ArrayList<Recording>();
		}			
	}
	
	// Setters
	public void setName(String name){
		if (name != null){
			this.name = name;
		}
	}
	
	// Getters
	
	public String getName(){
		return this.name;
	}
	
	public int getDuration(){
		return this.durationInSeconds;
	}
	
	public ArrayList<Recording> getRecordings(){
		return recordingList;
	}
	
	public int size() {
		return recordingList.size();
	}
	
	// A method that adds a new recording
	public boolean add(Recording newRecording){
		// Make sure we can add this recording first (not null and enough space)
		if (!recordingList.contains(newRecording)){
			// ...if we can, add it...
			this.recordingList.add(newRecording);
			// ...increment the number of recordings...
			// ...and add its duration to total playlist duration
			this.durationInSeconds = this.durationInSeconds + newRecording.getDuration();
			// everything worked - return false
			return true;
		} else {
			// ...if we cannot - return false
			return false;
		}	
	}
	
	
	public int findSong(String name) {
		for(int i = 0; i < recordingList.size(); i++) {
			if(recordingList.get(i).recordingName.toUpperCase().equals(name.toUpperCase())) {
				return i;
			}
		}
		return -1;
		
		
	}
	
	public void remove(int index) {
		recordingList.remove(index);
	}
	
	// play method
	public void play(){
		// Check if the playlist is empty...
		if (this.recordingList.size() > 0) {
			// ...if not, iterate over all array objects ...
			for (int index = 0; index < this.recordingList.size(); index++){
				// ... and invoke their play method
				recordingList.get(index).play();
			}
			System.out.println();
		} else {
			// ...if empty, display this error message
			System.out.println("ERROR: Empty playlist.");
		}
	}
	
	// shuffle method
	public void shuffle(){
		// Check if the playlist is empty...
		if (this.recordingList.size() > 0) {
			// Set up "already played" counter
			int recordingsPlayedCounter = 0;
			
			// Set up the random number generator object
			Random randomNumberGenerator = new Random();
			
			// ...if not, randomly choose numberOfRecordings...
			while (recordingsPlayedCounter < this.recordingList.size()- 1){
				// ... and invoke their play method
				int rng  = randomNumberGenerator.nextInt(recordingList.size() - 1 - recordingsPlayedCounter);
				recordingList.add(recordingList.remove(rng));
				recordingsPlayedCounter++;
			}
		} else {
			// ...if empty, display this error message
			System.out.println("ERROR: Empty playlist.");
		}
	}
	
	public void load(String fileName){
		if (fileName != null){
			try {
				File playlistFile = new File(fileName);
				
				Scanner fileScanner = new Scanner(playlistFile);
				
				System.out.println("Processing playlist file " + playlistFile + ":");
				
				while (fileScanner.hasNextLine()){
					String line = fileScanner.nextLine();
					
					if (line != null){
						String [] lineAsArray = line.split(",");
					
						if (lineAsArray != null && lineAsArray.length == 5) {
							if (lineAsArray[0].equals("A") || lineAsArray[0].equals("V")) {
								String name = lineAsArray[1];
								String artist = lineAsArray[2];
								try {
									int durationInSeconds = Integer.parseInt(lineAsArray[3]);
									double rate = Double.parseDouble(lineAsArray[4]);
									
									if (lineAsArray[0].equals("A")){
										AudioRecording newRecording = new AudioRecording(artist, name, durationInSeconds, rate);
										this.add(newRecording);
									}
									if (lineAsArray[0].equals("V")){
										VideoRecording newRecording = new VideoRecording(artist, name, durationInSeconds, rate);
										this.add(newRecording);
									}
																
								} catch (NumberFormatException nfe){
									System.out.println("ERROR: Number format exception. Recording rejected (" + line + ").");
								}
							} else {
								System.out.println("ERROR: Unknown recording type data (" + line + ").");
							}
							
						} else {
							System.out.println("ERROR: Inconsistent or no data read (" + line + ").");
						}
					} else {
						System.out.println("ERROR: Empty line read from a file");
					}
				}
				fileScanner.close();
			} catch (FileNotFoundException fnfe) {
				System.out.println("ERROR: File " +fileName + " not found!");
			}
		} else {
			System.out.println("ERROR: No file name provided.");
		}
	}
	
	// toString method
	public String toString(){
		String returnString = "Playlist: " + this.name + " [" + ((int) Math.floor(this.durationInSeconds/60)) + "m" + (this.durationInSeconds % 60) + "s]:\n";
		if (this.recordingList.size() > 0) {
			for (int index = 0; index < this.recordingList.size(); index++){
				returnString = returnString + recordingList.get(index).toString() + "\n";
			}
		} 
		return returnString;
	}
}
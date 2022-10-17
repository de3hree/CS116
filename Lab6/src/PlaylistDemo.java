
public class PlaylistDemo {
	public static void main(String [] args){
		// Instantiate new playlist
		Playlist myPlaylist = new Playlist("CS 116 Playlist", 10);
		
		// Add some songs to it
		AudioRecording newRecording = new AudioRecording("Billie Eilish", "Everything I Wanted", 201, 192);
		myPlaylist.add(newRecording);
		VideoRecording newRecording2 = new VideoRecording("Eminem", "Godzilla", 245, 60.00);
		myPlaylist.add(newRecording2);
		newRecording = new AudioRecording("The Weeknd", "Blinding Lights", 145, 160);
		myPlaylist.add(newRecording);
		newRecording2 = new VideoRecording("Nicki Minaj", "Yikes", 217, 29.97);
		myPlaylist.add(newRecording2);
		newRecording = new AudioRecording("Justin Bieber", "Intentions", 234, 320);
		myPlaylist.add(newRecording);		
		
		// "Play" the playlist
		myPlaylist.play();
		
		// Display playlist "summary"
		System.out.println(myPlaylist.toString());
		
		// "shuffle" the playlist 6 times
		myPlaylist.shuffle(6);
		
		// Instantiate new playlist
		Playlist billboardList = new Playlist("Billboard Playlist", 100);
		
		// Load the playlist from a file
		// This one should throw a FileNotFoundException
		billboardList.load("nonExistingFile.csv");
		// This one should work
		billboardList.load("BillboardHot100.csv");
		System.out.println();
		
		// Shuffle songs 10 times
		billboardList.shuffle(10);
	}
}	

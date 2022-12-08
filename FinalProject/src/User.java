
public class User {

	private String userName;
	private Playlist userPlaylist;
	private int userID;
	
	public User() {
	this.userName = "DEFAULT";
	this.userPlaylist = new Playlist();
	}
	
	public User(String userName) {
		this.userName = userName;
		this.userPlaylist = new Playlist(userName + "'s playlist");
	}
	
	
	public String getUsername() {
		return this.userName;
	}
	
	public String toString() {
		return this.userName;
	}
	
	public Playlist getPlaylist() {
		return this.userPlaylist;
	}
	
	
}

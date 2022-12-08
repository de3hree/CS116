public abstract class Recording {
	// Class attributes / fields
	// Final because we can only set it once
	protected String artist;
	protected String recordingName;
	protected int durationInSeconds;
	
	// Non-parametrized constructor
	// Essentially here to prevent Java from setting Strings to default null
	Recording(){
		this.artist = "Unknown";
		this.recordingName = "Unknown";
		this.durationInSeconds = 0;
	}
	
	// Parametrized constructor
	Recording(String artist, String recordingName, int durationInSeconds){
		// Check if inputs are legit...
		if (artist != null && recordingName != null && durationInSeconds > 0){
			// ...if yes, use them to set instance variables / attributes / fields
			this.artist = artist;
			this.recordingName = recordingName;
			this.durationInSeconds = durationInSeconds;
		} else {
			// ...if no, do what the non-parametrized constructor does
			this.artist = "Unknown";
			this.recordingName = "Unknown";
			this.durationInSeconds = 0;
		}
	}
	
	
	public String getartist(){
		return this.artist;
	}
	
	public String getName(){
		return this.recordingName;
	}
	
	public int getDuration(){
		return this.durationInSeconds;
	}
	
	// play() method
	// Display error message if duration is not positive
	// Otherwise display Now playing + toString() output
	public void play(){
		if (this.durationInSeconds > 0){
			System.out.println("Now playing: " + this.toString());
		} else {
			System.out.println("ERROR: Cannot play this recording.");
		}
	}
	
	// toString() method
	// Returns: author - recording name [XXmYYs]
	// where XX - full minutes and YY - remaining seconds (no leading zero necessary)
	public String toString(){
		return this.artist + " - " + this.recordingName + " [" + ((int) Math.floor(this.durationInSeconds/60)) + "m" + (this.durationInSeconds % 60) + "s]";	
	}
	
	public String getType() {
		return "R";
	}
	
	public abstract double getQuality();

}

public class AudioRecording extends Recording {

	
	private final double bitrate;
	
	//Double default
	public AudioRecording() {
		super();
		bitrate = 0;
	}
	
	public AudioRecording(String artist, String recordingName, int durationInSeconds, double bitRate){
		super(artist,recordingName, durationInSeconds);
		if(bitRate >0) {
			this.bitrate = bitRate;
		} else {
			bitrate = 0;
		}
		
	}
	
	public double getQuality() {
		return bitrate;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [AUDIO | bitrate: " + bitrate + " kbps]";
	}
	
	
	@Override
	public String getType() {
		return "A";
	}
	
	
}

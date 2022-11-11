
public class VideoRecording extends Recording {

	private final double framerate;
	
	public VideoRecording() {
		super();
		framerate = 0;
	}
	
	public VideoRecording(String artist, String recordingName, int durationInSeconds, double bitRate){
		super(artist,recordingName, durationInSeconds);
		if(bitRate >0) {
			this.framerate = bitRate;
		} else {
			framerate = 0;
		}
		
	}
	
	public double getFramerate() {
		return framerate;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [VIDEO | framerate: " + framerate + " fps]";
	}
	
	
}

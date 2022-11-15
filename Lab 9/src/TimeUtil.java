import java.util.concurrent.TimeUnit;

// Program to measure elapsed time in Java
class TimeUtil {
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.nanoTime();
		/* ... the code being measured starts ... */
// sleep for 5 seconds
		TimeUnit.SECONDS.sleep(5);
		/* ... the code being measured ends ... */
		long endTime = System.nanoTime();
// get difference of two nanoTime values
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds : " + timeElapsed);
		System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
	}
}

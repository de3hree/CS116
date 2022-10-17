
public class UnsortedData {

	
	public static int countOutOfPosition(double[] input) {
		int count = 0;
		for(int x = 0; x < input.length; x++) {
			for(int i = x; i < input.length;i++) {
				if(input[x] > input[i]) {
					count += 1;
				}
			}
		}
		
		return count;
	}
	
	public static void bubble(double[] input) {
		for(int x = 1; x < input.length; x++){
			if(input[x -1] > input[x]) {
				double temp = input[x-1];
				input[x-1] = input[x];
				input[x] = temp;
			}
		}
	}
}

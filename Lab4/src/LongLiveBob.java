
public class LongLiveBob {

	public static void main(String[] arrgs) {
		
		BobsLife notBob = new BobsLife(0,4,5,"home");
		
		
		System.out.println(notBob);
		
		
		//Infinite move loop
		for(int i = 0; i < 20; i ++) {
			notBob.move("gym");
			notBob.nextTime();// +2 fit -2 dollars +3 hunger
			System.out.println(notBob);
			notBob.move("home");
			notBob.nextTime(); //+2 fit -3 dollars 0 hunger
			System.out.println(notBob);
			notBob.move("work");
			notBob.nextTime();// +1 fit 0 dollars +2 hunger
			System.out.println(notBob);
			notBob.move("work");
			notBob.nextTime();// 0 fit +3 dollars +4 hunger
			System.out.println(notBob);
			notBob.move("home");
			notBob.nextTime();// 0 fit  +2 dollars +1 hunger
			System.out.println(notBob);
			notBob.move("gym");
			notBob.nextTime();// +2 fit 0 dollars +4 hunger
			System.out.println(notBob);
			notBob.move("home");
			notBob.nextTime();// +2 fit -1 dollars +1 hunger
			System.out.println(notBob);
			notBob.move("work");
			notBob.nextTime();// +1 fit +2 dollars +3 hunger
			System.out.println(notBob);
			notBob.move("home");
			notBob.nextTime();// +1 fit +1 dollar 0 hunger
			System.out.println(notBob);
			
			
		}
		
	}
	
}

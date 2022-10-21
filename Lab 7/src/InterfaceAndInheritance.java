
public class InterfaceAndInheritance {

	
	public static void main( String [] args ) {
		Vehicle myVehicle = new Vehicle();
		Vehicle myCar = new Car();
		Vehicle mySupersonicJet = new SupersonicJet();
		
		Animal myAnimal = new Animal();
		Animal mySnake = new Snake();
		Animal myBird = new Bird();
		
		myVehicle.memberOf();
		myVehicle.makeSound();
		myCar.memberOf();
		myCar.makeSound(); 
		mySupersonicJet.memberOf();
		mySupersonicJet.makeSound();
		
		myVehicle.move();
		myCar.move();
		mySupersonicJet.move();	
		
		myAnimal.memberOf();
		myAnimal.makeSound();
		mySnake.memberOf();
		mySnake.makeSound();
		myBird.memberOf();
		myBird.makeSound();
		
		myAnimal.move();
		mySnake.move();
		myBird.move();	
	}

}

public class CircleSolidClient {

	public static void main(String[] args) {

		// create and output a Cylinder
		Cylinder cylinder1 = new Cylinder(28,35);
		System.out.println(cylinder1.toString()+"\n");

		// create and output a Sphere
		Sphere sphere1 = new Sphere(6);
		System.out.println(sphere1.toString()+"\n");

		// calculate and output the number of Spheres in the Cylinder
		System.out.println("Approximate number of spheres in this cylinder=" + (cylinder1.getVolume()/sphere1.getVolume())+"\n");

		// create a CircleSolid reference
		CircleSolid circleV1;

		// assign subclass object reference (Cylinder) to a superclass object reference (CircleSolid)
		// then output the superclass object reference
		circleV1 = cylinder1;
		System.out.println(circleV1.toString()+"\n");

		// assign subclass object reference (Sphere) to a superclass object reference (CircleSolid)
		// then output the superclass object reference
		circleV1 = sphere1;
		System.out.println(circleV1.toString()+"\n");

		// create an array of 3 CircleSolid objects, 
		// assign a whatever the CircleSolid reference is pointing to one position,
		// a new Cylinder to the second position, and a new Sphere to the third position
		// then use a loop to output the objects in the array to show runtime polymorphism
		CircleSolid [] solids = new CircleSolid [3];
		solids[0] = circleV1;
		solids[1] = new Cylinder(10, 15);
		solids[2] = new Sphere(20);
		for (int i=0; i<solids.length; i++)
			System.out.println(solids[i].getClass() + " Radius="+solids[i].getRadius() + " Volume=" +solids[i].getVolume());	
	}
}
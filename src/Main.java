import java.util.Scanner;

public class Main {
	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		FlyingCar fc = new FlyingCar(120, 1800);

		// Test basic vehicles
		testBasicVehicles();

		// Test interfaces
		testInterfaces();


		System.out.println("=== VEHICLE CONSOLE PROJECT ===");
		System.out.println("1. Test Car");
		System.out.println("2. Test Plane");
		System.out.println("3. Test Flying Car");
		System.out.print("Choose option: ");


		int choice = scanner.nextInt();


		switch (choice) {
			case 1:
				testCar();
				break;
			case 2:
				testPlane();
				break;
			case 3:
				testFlyingCar();
				break;
		}

		System.out.print("Enter gear (1-6): ");
		int userGear = scanner.nextInt();
		fc.changeToGear(userGear);

		scanner.close();
	}

	private static void testFlyingCar() {
	}

	private static void testPlane() {
	}

	private static void testCar() {
	}


	private static void testBasicVehicles() {

		Car myCar = new Car(120, 1500f);
		Plane myPlane = new Plane(850, 75000.0f);
		FlyingCar myFLyingCar = new FlyingCar(150, 1800.0f);

		Vehicle[] vehicles = {myCar, myPlane, myFLyingCar};
		for (Vehicle v : vehicles) {
			v.displayInfo();
			v.startEngine();
			v.turnOffEngine();
			System.out.println();
		}
	}

	private static void testInterfaces() {
		System.out.println("--- Interface Testing ---");

		Car car = new Car(0, 1200.0f);
		FlyingCar flyingCar = new FlyingCar(0, 1700.0f);

		// Test Driveable
		System.out.println("Testing Driveable:");
		car.accelerate();
		car.changeGear();
		car.brake();

		// Test Flyable
		System.out.println("\nTesting Flyable:");
		flyingCar.accelerate();
		flyingCar.accelerate(); // Get speed up
		flyingCar.takeOff();
		flyingCar.changeHeight();
		flyingCar.land();
		System.out.println();

	}
}
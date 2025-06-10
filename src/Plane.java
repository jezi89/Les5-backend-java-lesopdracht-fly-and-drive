// Plane.java
public class Plane extends Vehicle implements Flyable {
	private int altitude = 0;
	private boolean flying = false;

	public Plane(int speed, float weight) {
		super(speed, weight);
	}

	public static Plane getDefault() {
		return new Plane(850, 75000.0f);
	}

	@Override
	public void startEngine() {
		System.out.println("✈️ Plane engines started!");
	}

	@Override
	public void turnOffEngine() {
		System.out.println("✈️ Plane engines stopped!");
		if (flying) land();
	}

	@Override
	public void takeOff() {
		if (!flying) {
			flying = true;
			altitude = 1000;
			System.out.println("✈️ Taking off! Altitude: " + altitude + "m");
		}
	}

	@Override
	public void land() {
		flying = false;
		altitude = 0;
		setSpeed(0);
		System.out.println("✈️ Landed safely!");
	}

	@Override
	public void changeHeight() {
		if (flying) {
			altitude += 500;
			System.out.println("✈️ Climbing to " + altitude + "m");
		}
	}
}
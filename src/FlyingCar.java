public class FlyingCar extends Vehicle implements Driveable, Flyable {
	private int altitude = 0;
	private boolean flying = false;
	private int gear = 1;  // Eigen gear field

	public FlyingCar(int speed, float weight) {
		super(speed, weight);
	}

	public static FlyingCar getDefault() {
		return new FlyingCar(120, 1800.0f);
	}


	@Override
	public void startEngine() {
		System.out.println("🚗✈️ Flying car engine started! Mode: " + (flying ? "Flight" : "Ground"));
	}

	@Override
	public void turnOffEngine() {
		System.out.println("🚗✈️ Flying car stopped!");
		if (flying) land();
	}


	@Override
	public void accelerate() {
		increaseSpeed(flying ? 40 : 25);
		System.out.println("🚗✈️ Accelerating to " + getSpeed() + " km/h");

	}

	@Override
	public void brake() {
		decreaseSpeed(30);  // Helper method
		System.out.println("🚗✈️ Slowing to " + getSpeed() + " km/h");

	}

	@Override
	public void changeGear() {
		if (!flying) {
			gear = (gear % 6) + 1;  // Flying cars have 6 gears
			System.out.println("🚗✈️ Changed to gear " + gear);
		} else {
			System.out.println("🚗✈️ No gears in flight mode!");
		}
	}

	// Als je handmatige gear input wilt:
	public void changeToGear(int targetGear) {
		if (!flying && targetGear >= 1 && targetGear <= 6) {
			this.gear = targetGear;
			System.out.println("🚗✈️ Manually changed to gear " + gear);
		}
	}

	@Override
	public void takeOff() {
		if (!flying && getSpeed() > 100) {
			flying = true;
			altitude = 500;
			System.out.println("🚗✈️ Taking off! Altitude: " + altitude + "m");
		} else if (!flying) {
			System.out.println("🚗✈️ Need speed >100 km/h to take off!");
		}
	}

	@Override
	public void land() {
		flying = false;
		altitude = 0;
		System.out.println("🚗✈️ Landed! Now in ground mode.");
	}

	@Override
	public void changeHeight() {
		if (flying) {
			altitude += 300;
			System.out.println("🚗✈️ Climbing to " + altitude + "m");
		}

	}
}
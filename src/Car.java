public class Car extends Vehicle implements Driveable {
	private int gear = 1;

	public Car(int speed, float weight) {
		super(speed, weight);
	}

	public static Car getDefault() {
		return new Car(0, 1200.0f);
	}

	@Override
	public void startEngine() {
		System.out.println("🚗 Car engine started! Ready to drive!");
		System.out.println("Current speed: " + getSpeed() + " km/h");
	}

	@Override
	public void accelerate() {
		increaseSpeed(20);
		System.out.println("🚗 Accelerating to " + getSpeed() + " km/h");
	}

	@Override
	public void turnOffEngine() {
		System.out.println("🚗 Car engine stopped!");
		setSpeed(0);
	}

	@Override
	public void brake() {
		decreaseSpeed(30);
		System.out.println("Braking to " + getSpeed() + " km/h");
	}

	@Override
	public void changeGear() {
		gear = (gear % 5) + 1;  // Cycle through 1-5
		System.out.println("🚗 Changed to gear " + gear);
	}

	protected int getGear() {
		return gear;
	}

	// Helper voor handmatige gear change
	protected void setGear(int newGear) {
		if (newGear >= 1 && newGear <= 5) {
			this.gear = newGear;
		}
	}
}




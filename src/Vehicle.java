public abstract class Vehicle {
	private final float weight;
	private int speed;

	public Vehicle(int speed, float weight) {
		this.speed = speed;
		this.weight = weight;
	}

	public abstract void startEngine();

	public abstract void turnOffEngine();


	protected int getSpeed() {
		return speed;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}


	protected float getWeight() {
		return weight;
	}

	// Helper methods voor veilige speed aanpassingen
	protected void increaseSpeed(int amount) {
		setSpeed(getSpeed() + amount);
	}

	protected void decreaseSpeed(int amount) {
		setSpeed(Math.max(0, getSpeed() - amount));
	}
	
	// Publieke methode voor informatie - alle subclasses kunnen deze gebruiken

	public void displayInfo() {
		System.out.println("=== Vehicle Info ===");
		System.out.println("Type: " + this.getClass().getSimpleName());
		System.out.println("Speed: " + speed + " km/h");
		System.out.println("Weight: " + weight + " kg");
	}

}

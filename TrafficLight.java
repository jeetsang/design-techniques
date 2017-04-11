public class TrafficLight {
	public static final int RED = 0;
	public static final int YELLOW = 1;
	public static final int GREEN = 2;
	private int currentColor = RED;
	public int change() {
		switch(currentColor) {
			case RED:
				currentColor = GREEN;
				break;
			case YELLOW:
				currentColor = RED;
				break;
			case GREEN:
				currentColor = YELLOW;
				break;
		}

		return currentColor;
	}

	public int getCurrentColor() {
		return currentColor;
	}
	//Test Client
	public static void main(String[] args) {
		TrafficLight trafficLight = new TrafficLight();
		System.out.println(trafficLight.getCurrentColor());
		trafficLight.change();
		System.out.println(trafficLight.getCurrentColor());
	}
}
class InvalidObjectException extends Exception {
}
public class CoffeeCup {
	//Pre defined size of CoffeeCups
	public static final int SHORT = 0;
	public static final int TALL = 1;
	public static final int GRANDE = 2;
	public static final int MAX_SHORT_ML = 237;
	public static final int MAX_TALL_ML = 355;
	public static final int MAX_GRANDE_ML = 473;
	private boolean sizeValid;
	private int size;
	private int innerCoffee;
	private int innerCream;
	private int innerSugar;
	private boolean needWashing;
	public CoffeeCup() {

	}
	public CoffeeCup(int size) {
		this(size,0);
	}
	public CoffeeCup(int size, int startingAmount) {
		if(startingAmount < 0) {
			String s = "Can't have negative coffe.";
			throw  new IllegalArgumentException(s);
		}

		if(startingAmount > getMaxAmount(size)) {
			String s = "too much coffee.";
			throw new IllegalArgumentException(s);
		}

		setSize(size);
		innerCoffee = startingAmount;
	}

	public final void setSize(int size) {
		if( size!=TALL && size != GRANDE && size != SHORT) {
			String s = "Invalid cup size.";
			throw new IllegalArgumentException(s);
		}
		sizeValid = true;
		this.size = size;
	}

	private static int getMaxAmount(int size) {
		int retValue = 0;
		switch(size) {
			case SHORT:
				retValue = MAX_SHORT_ML;
				break;
			case TALL:
				retValue = MAX_TALL_ML;
				break;
			case GRANDE:
				retValue = MAX_GRANDE_ML;
			default:
				String s = "Invalid cup size";
				throw new IllegalArgumentException(s);
		}

		return retValue;
	}

	public int addCoffee(int amount) throws InvalidObjectException {
		if(!sizeValid) {
			throw new InvalidObjectException();
		}

		innerCoffee += amount;
		int max = getMaxAmount(size);
		int spillAmout = 0;
		if (innerCoffee > max) {
			spillAmout  = innerCoffee - max;
			innerCoffee = max;
		}

		return spillAmout;
	}

	public void addCream(int amount) {
		innerCream += amount;
	}

	public void addSugar(int amount) {
		innerSugar += amount;
	}
	public boolean isReadyForNextUse() {
		return !needWashing;
	}

	public void setCustomerDone(){
		needWashing = true;
	}

	public void wash(){
		needWashing = false;
	}

	//Test Client
	public static void main(String[] args) {
		// Create a "tall" coffee cup filled with 50 ml coffee.
        CoffeeCup cup1 = new CoffeeCup(CoffeeCup.TALL, 50);
        // Create an empty "short" coffee cup.
        CoffeeCup cup2 = new CoffeeCup(CoffeeCup.SHORT);
	}
}

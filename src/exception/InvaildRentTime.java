package exception;

public class InvaildRentTime extends Exception {
	public InvaildRentTime(String msg) {
		super(msg);
	}

	public InvaildRentTime() {
		super("Rent time cannot be zero or negative");
	}
}

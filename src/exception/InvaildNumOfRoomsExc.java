package exception;

public class InvaildNumOfRoomsExc extends Exception {
	
	public InvaildNumOfRoomsExc(String msg) {
		super(msg);
	}
	
	public InvaildNumOfRoomsExc() {
		super("Number of rooms cannot be zero or negative!!");
	}
}

package exception;

public class ApartmentAlredyExistExc extends Exception {
	public ApartmentAlredyExistExc(String msg) {
		super(msg);
	}

	public ApartmentAlredyExistExc() {
		super("Apartment already exist!");
	}
}

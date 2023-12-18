package exception;

public class PhoneNumberExc extends Exception {
	public PhoneNumberExc(String msg) {
		super(msg);
	}

	public PhoneNumberExc() {
		super("Phone number cannot be null");
	}
}

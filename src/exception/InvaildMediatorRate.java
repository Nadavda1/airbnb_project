package exception;

public class InvaildMediatorRate extends Exception {

	public InvaildMediatorRate(String msg) {
		super(msg);
	}

	public InvaildMediatorRate() {
		super("rate must be number between 1-10");
	}

}

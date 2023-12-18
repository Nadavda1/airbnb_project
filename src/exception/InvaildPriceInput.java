package exception;

public class InvaildPriceInput extends Exception {
	public InvaildPriceInput(String msg) {
		super(msg);
	}

	public InvaildPriceInput() {
		super("Price cannot be zero or negative!!");
	}

}

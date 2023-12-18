package exception;

public class InvaildAreaInput extends Exception{
	public InvaildAreaInput(String msg) {
		super(msg);
	}

	public InvaildAreaInput() {
		super("Area cannot be zero or negative!!");
	}

}

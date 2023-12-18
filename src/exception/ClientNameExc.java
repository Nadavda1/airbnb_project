package exception;

public class ClientNameExc extends Exception {
	public ClientNameExc(String msg) {
		super(msg);
	}

	public ClientNameExc() {
		super("Client's name cannot be null");
	}
}

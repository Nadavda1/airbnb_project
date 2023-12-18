package exception;

public class ClientAlreadyExistExc extends Exception {
	public ClientAlreadyExistExc(String msg) {
		super(msg);
	}

	public ClientAlreadyExistExc() {
		super("Client already exist!");
	}
}

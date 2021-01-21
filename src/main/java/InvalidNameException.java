public class InvalidNameException extends Exception {

	private static final long serialVersionUID = 1L;

	private int errorCode;

	public InvalidNameException(int errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String getMessage() {
		String message = "";

		switch (errorCode) {
		case 0:
			message = "The name cannot be empty.";
			break;
		case 1:
			message = "The name cannot include numbers.";
			break;
		}
		return message;
	}
}
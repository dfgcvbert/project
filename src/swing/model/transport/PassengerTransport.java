package swing.model.transport;

public abstract class PassengerTransport {

	private String type;

	public PassengerTransport() {
	}

	public PassengerTransport(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

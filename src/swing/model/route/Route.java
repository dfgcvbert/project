package swing.model.route;

public class Route {

	private int number;
	private String typePassengerTransport;
	private HalfRoute routeForward;
	private HalfRoute routeBack;

	public Route() {
	}

	public Route(int number, String typePassengerTransport, HalfRoute routeForward, HalfRoute routeBack) {
		this.number = number;
		this.typePassengerTransport = typePassengerTransport;
		this.routeForward = routeForward;
		this.routeBack = routeBack;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTypePassengerTransport() {
		return typePassengerTransport;
	}

	public void setTypePassengerTransport(String typePassengerTransport) {
		this.typePassengerTransport = typePassengerTransport;
	}

	public HalfRoute getRouteForward() {
		return routeForward;
	}

	public void setRouteForward(HalfRoute routeForward) {
		this.routeForward = routeForward;
	}

	public HalfRoute getRouteBack() {
		return routeBack;
	}

	public void setRouteBack(HalfRoute routeBack) {
		this.routeBack = routeBack;
	}

	public String getTitle() {
		return routeForward.getPartsRoute()[0].getTitle() + " - "
				+ routeForward.getPartsRoute()[routeForward.getPartsRoute().length - 1].getTitle() + " - "
				+ routeForward.getPartsRoute()[0].getTitle();
	}

}

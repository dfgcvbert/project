package swing.model.transport;

import swing.model.route.Route;

public class UrbanPassengerTransport extends PassengerTransport {

	private Route route;

	public UrbanPassengerTransport() {
	}

	public UrbanPassengerTransport(Route route) {
		super(route.getTypePassengerTransport());
		this.route = route;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}

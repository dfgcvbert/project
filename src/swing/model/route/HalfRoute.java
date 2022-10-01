package swing.model.route;

public class HalfRoute {

	private PartRoute[] partsRoute;

	public HalfRoute() {
	}

	public HalfRoute(PartRoute... partsRoute) {
		this.partsRoute = partsRoute;
	}

	public PartRoute[] getPartsRoute() {
		return partsRoute;
	}

	public void setPartsRoute(PartRoute... partsRoute) {
		this.partsRoute = partsRoute;
	}

	public String getTitle() {
		return partsRoute[0].getTitle() + " - " + partsRoute[partsRoute.length - 1].getTitle();
	}

	public void addPartsRoute(PartRoute... partsRoute) {
		if (this.partsRoute == null) {
			this.partsRoute = partsRoute;
		} else {
			PartRoute[] newPartsRoute = new PartRoute[this.partsRoute.length + partsRoute.length];
			System.arraycopy(this.partsRoute, 0, newPartsRoute, 0, this.partsRoute.length);
			System.arraycopy(partsRoute, 0, newPartsRoute, newPartsRoute.length - 1, partsRoute.length);
			this.partsRoute = newPartsRoute;
		}
	}

}

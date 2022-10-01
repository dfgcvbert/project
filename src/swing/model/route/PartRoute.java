package swing.model.route;

import swing.model.MyTime;

public class PartRoute {

	private String title;
	private MyTime[] arrTime;

	public PartRoute() {
	}

	public PartRoute(String title, MyTime... arrTime) {
		this.title = title;
		this.arrTime = arrTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MyTime[] getArrTime() {
		return arrTime;
	}

	public void setArrTime(MyTime... arrTime) {
		this.arrTime = arrTime;
	}

}

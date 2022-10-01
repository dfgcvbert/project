package swing.controller;

import java.util.List;
import java.util.Set;

import swing.model.Database;
import swing.model.MyTime;

public class Controller {

	private Database database;

	public Controller(Database database) {
		this.database = database;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Set<String> getAllStopTitles() {
		return database.getAllStopTitles();
	}

	public List<String> findNearestTransport(MyTime time, String startPoint, String finishPoint) {
		return database.findNearestTransport(time, startPoint, finishPoint);
	}

}

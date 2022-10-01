package swing.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import swing.model.route.PartRoute;
import swing.model.transport.PassengerTransport;
import swing.model.transport.UrbanPassengerTransport;

public class Database {

	private List<PassengerTransport> arrPassengerTransport;

	public Database(List<PassengerTransport> arrPassengerTransport) {
		this.arrPassengerTransport = arrPassengerTransport;
	}

	public List<PassengerTransport> getArrPassengerTransport() {
		return arrPassengerTransport;
	}

	public void setArrPassengerTransport(List<PassengerTransport> arrPassengerTransport) {
		this.arrPassengerTransport = arrPassengerTransport;
	}

	public Set<String> getAllStopTitles() {
		Set<String> allStopTitles = new HashSet<>();
		for (PassengerTransport passengerTransport : arrPassengerTransport) {
			for (PartRoute partRoute : ((UrbanPassengerTransport) passengerTransport).getRoute().getRouteForward()
					.getPartsRoute())
				allStopTitles.add(partRoute.getTitle());
		}
		return allStopTitles;
	}

	public List<String> findNearestTransport(MyTime time, String startPoint, String finishPoint) {
		MyTime[] arrSearchTime = new MyTime[arrPassengerTransport.size()];
		List<String> nearestTransport = new ArrayList<>();
		int indexStart = -1;
		int indexFinish = -1;
		for (int i = 0; i < arrPassengerTransport.size(); i++) {
			for (int j = 0; j < ((UrbanPassengerTransport) arrPassengerTransport.get(i)).getRoute().getRouteForward()
					.getPartsRoute().length; j++) {
				if (startPoint.equals(((UrbanPassengerTransport) arrPassengerTransport.get(i)).getRoute()
						.getRouteForward().getPartsRoute()[j].getTitle())) {
					indexStart = j;
				}
				if (finishPoint.equals(((UrbanPassengerTransport) arrPassengerTransport.get(i)).getRoute()
						.getRouteForward().getPartsRoute()[j].getTitle())) {
					indexFinish = j;
				}
			}
			if ((indexStart > 0) && (indexFinish > 0)) {
				if (indexStart < indexFinish) {
					arrSearchTime[i] = findPreviousSmallerTime(time,
							((UrbanPassengerTransport) arrPassengerTransport.get(i)).getRoute().getRouteForward()
									.getPartsRoute()[indexStart].getArrTime());
				} else if (indexStart > indexFinish) {
					arrSearchTime[i] = findPreviousSmallerTime(time,
							((UrbanPassengerTransport) arrPassengerTransport.get(i)).getRoute().getRouteBack()
									.getPartsRoute()[indexStart].getArrTime());
				}
				nearestTransport.add(((UrbanPassengerTransport) arrPassengerTransport.get(i)).getType() + " №"
						+ ((UrbanPassengerTransport) arrPassengerTransport.get(i)).getRoute().getNumber()
						+ ". Отправление в "
						+ ((arrSearchTime[i].getMinutes() < 10) ? time.getHours() + ":0" + arrSearchTime[i].getMinutes()
								: +arrSearchTime[i].getHours() + ":" + arrSearchTime[i].getMinutes()));
			}
			indexStart = -1;
			indexFinish = -1;
		}
		return nearestTransport;
	}

	private static MyTime findPreviousSmallerTime(MyTime time, MyTime[] arrTime) {
		int t1;
		int t2;
		t1 = MyTime.convertToMinutes(time);
		for (int i = 0; i < arrTime.length; i++) {
			t2 = MyTime.convertToMinutes(arrTime[i]);
			if (t1 < t2) {
				return arrTime[i - 1];
			}
		}
		return null;
	}

}

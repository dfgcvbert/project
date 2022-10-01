package swing;

import java.util.Arrays;

import swing.controller.Controller;
import swing.model.Database;
import swing.model.MyTime;
import swing.model.route.HalfRoute;
import swing.model.route.PartRoute;
import swing.model.route.Route;
import swing.model.transport.PassengerTransport;
import swing.model.transport.UrbanPassengerTransport;
import swing.view.Window;

public class Main {
	public static void main(String[] args) {
// ----------------------------------------------------------------------------------------------------------------------
//		Маршрут вперед
		HalfRoute Route6Forward = new HalfRoute();
//		Число прибытий на одну остановку за сутки
		int numberArrivals = 50;
//		Максимальное время ожидания
		int period = 22;
		String[] titles = { "Микрорайон №6", "Проспект Строителей", "Улица Батова", "ОАО ФанДОК", "Улица Октябрьская",
				"Дом связи", "Площадь Ленина", "Улица Дзержинского", "Парковая" };
		int[][] arrStartTime = { { 5, 50 }, { 5, 54 }, { 5, 56 }, { 6, 8 }, { 6, 15 }, { 6, 18 }, { 6, 20 }, { 6, 27 },
				{ 6, 35 } };
		for (int i = 0; i < titles.length; i++) {
			createAndAddPartRoute(titles[i], numberArrivals, period, arrStartTime[i][0], arrStartTime[i][1],
					Route6Forward);
		}
//		Маршрут назад
		HalfRoute Route6Back = new HalfRoute();
		arrStartTime = new int[][] { { 5, 58 }, { 6, 5 }, { 6, 14 }, { 6, 16 }, { 6, 18 }, { 6, 24 }, { 6, 38 },
				{ 6, 39 }, { 6, 42 } };
		for (int i = titles.length - 1; i >= 0; i--) {
			createAndAddPartRoute(titles[i], numberArrivals, period, arrStartTime[i][0], arrStartTime[i][1],
					Route6Back);
		}
//		Полный маршрут
		Route Route6 = new Route(6, "Автобус", Route6Forward, Route6Back);
//		Автобус
		PassengerTransport bus6 = new UrbanPassengerTransport(Route6);
//----------------------------------------------------------------------------------------------------------------------
		HalfRoute Route2Forward = new HalfRoute();
		numberArrivals = 85;
		period = 13;
		titles = new String[] { "Улица Сикорского", "Проспект Строителей", "Техникум", "Улица Октябрьская", "Дом связи",
				"Площадь Ленина", "Кинотеатр Мир", "Станция Бобруйск" };
		arrStartTime = new int[][] { { 5, 51 }, { 5, 52 }, { 6, 2 }, { 6, 15 }, { 6, 16 }, { 6, 17 }, { 6, 22 },
				{ 6, 28 } };
		for (int i = 0; i < titles.length; i++) {
			createAndAddPartRoute(titles[i], numberArrivals, period, arrStartTime[i][0], arrStartTime[i][1],
					Route2Forward);
		}
		HalfRoute Route2Back = new HalfRoute();
		arrStartTime = new int[][] { { 5, 8 }, { 5, 15 }, { 5, 21 }, { 5, 23 }, { 5, 25 }, { 5, 35 }, { 5, 44 },
				{ 5, 45 } };
		for (int i = titles.length - 1; i >= 0; i--) {
			createAndAddPartRoute(titles[i], numberArrivals, period, arrStartTime[i][0], arrStartTime[i][1],
					Route2Back);
		}
		Route Route2 = new Route(2, "Троллейбус", Route2Forward, Route2Back);
		PassengerTransport trolleybus2 = new UrbanPassengerTransport(Route2);
//-----------------------------------------------------------------------------------------------------------------------
		Database database = new Database(Arrays.asList(bus6, trolleybus2));
		Controller controller = new Controller(database);
		Window window = new Window(controller);
		window.setVisible(true);
	}

	static void createAndAddPartRoute(String titlePartRoute, int numberArrivals, int period, int startTimeHours,
			int startTimeMinutes, HalfRoute halfRoute) {
		MyTime startTime = new MyTime(startTimeHours, startTimeMinutes);
		MyTime[] arrTime = MyTime.calculateArrTime(startTime, numberArrivals, period);
		PartRoute partRoute = new PartRoute(titlePartRoute, arrTime);
		halfRoute.addPartsRoute(partRoute);
	}

}

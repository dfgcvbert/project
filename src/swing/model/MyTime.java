package swing.model;

public class MyTime {

	private int hours;
	private int minutes;

	public MyTime() {
	}

	public MyTime(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**
	 * @param startTime
	 * @param numberRepeat
	 * @param period       minutes
	 */
	public static MyTime[] calculateArrTime(MyTime startTime, int numberRepeat, int period) {
		MyTime[] arrTime = new MyTime[numberRepeat];
		arrTime[0] = new MyTime(startTime.getHours(), startTime.getMinutes());
		int temp = 0;
		for (int i = 1; i < numberRepeat; i++) {
			temp = 60 * arrTime[i - 1].getHours() + arrTime[i - 1].getMinutes() + period;
			arrTime[i] = new MyTime();
			arrTime[i].setHours(temp / 60);
			arrTime[i].setMinutes(temp % 60);
		}
		return arrTime;
	}

	static int convertToMinutes(MyTime time) {
		return time.getHours() * 60 + time.minutes;
	}

	static void print(MyTime time) {
		System.out.print((time.getMinutes() < 10) ? time.getHours() + ":0" + time.getMinutes()
				: +time.getHours() + ":" + time.getMinutes());
	}

}

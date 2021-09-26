package utility;

import java.time.LocalTime;

public class GreetingUtility {

	private static final LocalTime MORNING = LocalTime.of(0, 0, 0);
	private static final LocalTime AFTER_NOON = LocalTime.of(12, 0, 0);
	private static final LocalTime EVENING = LocalTime.of(16, 0, 0);
	private static final LocalTime NIGHT = LocalTime.of(21, 0, 0);

	private LocalTime now;

	public GreetingUtility(LocalTime now) {
		this.now = now;
	}

	public String get() {
		String message;
		if (between(MORNING, AFTER_NOON)) {
			message = "Good Morning";
		} else if (between(AFTER_NOON, EVENING)) {
			message = "Good Afternoon";
		} else if (between(EVENING, NIGHT)) {
			message = "Good Evening";
		} else {
			message = "Good Night";
		}

		return message;
	}

	private boolean between(LocalTime start, LocalTime end) {
		return (!now.isBefore(start)) && now.isBefore(end);
	}
}

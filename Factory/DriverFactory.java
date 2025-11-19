public class DriverFactory {
	public static Driver getDriver(String type) {
		if (type == null) return null;
		switch (type) {
			case "Car":
				return new CarDriver();
			case "Plane":
				return new PlaneDriver();
			default:
				return null;
		}
	}
}

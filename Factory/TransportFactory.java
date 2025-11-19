public class TransportFactory {
	public static Transport getTransport(String type) {
		if (type == null) return null;
		switch (type) {
			case "Car":
				return new Car();
			case "Plane":
				return new Plane();
			default:
				return null;
		}
	}
}

public class DriverFactory {
    public static Driver getDriver(String driver) {
        if (driver == "Car") {
            return new CarDriver();
        }
        if (driver == "Plane") {
            return new PlaneDriver();
        }
        return null;
    }
    public static void main(String[] args)  {

        System.out.println(DriverFactory.getDriver("Car").createTransport().getDistance());
        System.out.println(DriverFactory.getDriver("Plane").createTransport().getDistance());
    }

}

import java.util.List;

public class Galaxy {
    private List<CelestialObject>  celestialObjects;

    public Galaxy() {
        this.celestialObjects = new java.util.ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject obj) {
        this.celestialObjects.add(obj);
    }
}

import java.util.List;
import java.util.Map;

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

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> massRepartition = new java.util.HashMap<>();
        int totalMassStars = 0;
        int totalMassPlanets = 0;
        int totalMassOthers = 0;

        for (CelestialObject obj : celestialObjects) {
            if (obj instanceof Star) {
                totalMassStars += obj.getMass();
            } else if (obj instanceof Planet) {
                totalMassPlanets += obj.getMass();
            } else {
                totalMassOthers += obj.getMass();
            }
        }

        massRepartition.put("Other", totalMassOthers);
        massRepartition.put("Planet", totalMassPlanets);
        massRepartition.put("Star", totalMassStars);

        return massRepartition;
    }
}

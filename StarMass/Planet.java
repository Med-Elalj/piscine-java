import java.util.Objects;

public class Planet extends CelestialObject{
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }
    
    public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
        super(name, x, y, z, mass);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }
    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z, centerStar);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Planet)) return false;
        if (!super.equals(obj)) return false;
        Planet other = (Planet) obj;
        return Objects.equals(this.centerStar, other.centerStar);
    }

    @Override
    public String toString() {
        return String.format("%s circles around %s at the %.3f AU",
            this.name,
            this.centerStar.getName(),
            this.distanceBetween(this.centerStar));
    }

    public double distanceBetween(Star star) {
        return CelestialObject.getDistanceBetween(this, star);
    }

}

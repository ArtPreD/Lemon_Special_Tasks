package samples.builder;

public class StarShip {
    private String type;
    private EngineType engineType;
    private int maxSpeed;

    public void setType(String type) {
        this.type = type;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Starship type - " + type + ", engine on ship - " + engineType + ", max speed - " + maxSpeed;
    }
}

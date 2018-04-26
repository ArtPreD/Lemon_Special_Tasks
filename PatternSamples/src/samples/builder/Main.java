package samples.builder;

public class Main {

    public static void main(String[] args) {
        StarShipBuilder starShipBuilder = new StarShipBuilder();

        StarShip starShipDefault = starShipBuilder.build();
        StarShip starShipFrigate = starShipBuilder
                .buildType("Frigate")
                .buildEngineType(EngineType.MASS_DRIVE)
                .buildMaxSpeed(70).build();

        System.out.println(starShipDefault);
        System.out.println(starShipFrigate);
    }
}

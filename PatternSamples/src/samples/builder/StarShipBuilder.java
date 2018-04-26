package samples.builder;

public class StarShipBuilder {
   private String t = "Fighter";
   private EngineType e = EngineType.HYPER_DRIVE;
   private int s = 100;

    StarShipBuilder buildType(String t){
        this.t = t;
        return this;
    }

    StarShipBuilder buildEngineType(EngineType e){
        this.e = e;
        return this;
    }

    StarShipBuilder buildMaxSpeed(int s){
        this.s = s;
        return this;
    }

    StarShip build(){
        StarShip starShip = new StarShip();
        starShip.setType(t);
        starShip.setEngineType(e);
        starShip.setMaxSpeed(s);

        return starShip;
    }
}

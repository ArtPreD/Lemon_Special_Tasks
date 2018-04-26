package samples.factory;


public class Main {

    public static void main(String[] args) {
        WatchMaker maker = new DigitalWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();

        WatchMaker maker2 = getWatchMakerByName("Rome");
        Watch watch2 = maker2.createWatch();
        watch2.showTime();
    }


    public static WatchMaker getWatchMakerByName(String maker){
        if(maker.equals("Digital")){
            return new DigitalWatchMaker();
        }else if (maker.equals("Rome")){
            return new RomeWatchMaker();
        }
        throw  new RuntimeException(maker + " не поддерживается");
    }
}

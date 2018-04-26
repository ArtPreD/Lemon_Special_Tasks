package samples.factory;

public class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new ProductRomeWatch();
    }
}

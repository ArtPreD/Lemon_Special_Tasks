package samples.command;

public class InvokerUser {
    private CommandStart start;
    private CommandRestart restart;
    private CommandStop stop;

    public InvokerUser(CommandStart start, CommandRestart restart, CommandStop stop) {
        this.start = start;
        this.restart = restart;
        this.stop = stop;
    }

    public void startServer(){
        start.execute();
    }

    public void restartServer(){
        restart.execute();
    }

    public void stopServer(){
        stop.execute();
    }
}

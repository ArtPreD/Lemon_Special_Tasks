package samples.command;

public class CommandStart implements Command {

    Server server;

    public CommandStart(Server server) {
        this.server = server;
    }

    @Override
    public void execute() {
        server.start();
    }
}

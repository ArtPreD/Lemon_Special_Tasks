package samples.command;

public class CommandStop implements Command {

    Server server;

    public CommandStop(Server server) {
        this.server = server;
    }

    @Override
    public void execute() {
        server.stop();
    }
}

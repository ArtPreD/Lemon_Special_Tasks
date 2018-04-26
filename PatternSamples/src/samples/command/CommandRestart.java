package samples.command;

public class CommandRestart implements Command {

    Server server;

    public CommandRestart(Server server) {
        this.server = server;
    }

    @Override
    public void execute() {
        server.restart();
    }
}

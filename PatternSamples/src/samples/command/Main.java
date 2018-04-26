package samples.command;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        InvokerUser user = new InvokerUser(new CommandStart(server),
                new CommandRestart(server), new CommandStop(server));

        user.startServer();
        user.restartServer();
        user.stopServer();
    }
}

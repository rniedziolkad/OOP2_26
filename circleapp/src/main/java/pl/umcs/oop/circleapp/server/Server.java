package pl.umcs.oop.circleapp.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void listen() {
        System.out.println("Server started");

    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(5000);
        server.listen();
    }
}

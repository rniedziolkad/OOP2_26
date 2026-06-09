package pl.umcs.oop.circleapp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void listen() throws IOException {
        System.out.println("Server started");
        while (true) {
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();
            ClientThread ct = new ClientThread(socket);
            Thread thread = new Thread(ct);
            thread.start();

        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(5000);
        server.listen();
    }
}

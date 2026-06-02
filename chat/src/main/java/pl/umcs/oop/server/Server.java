package pl.umcs.oop.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private int port;
    public Server(int port) {
        this.port = port;
    }

    public void listen() {
        // ServerSocket służy do przyjmowania połączeń klientów
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serwer nasłuchuje na porcie " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // ten Socket służy do komunikacji z klientem
                System.out.println("Połączono: " + clientSocket);
                Scanner in = new Scanner(clientSocket.getInputStream());
                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    System.out.println("Otrzymano: " + message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

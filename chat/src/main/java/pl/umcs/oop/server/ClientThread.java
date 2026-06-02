package pl.umcs.oop.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientThread extends Thread {
    private Socket socket;
    private List<ClientThread> allClients;
    private PrintWriter out;
    public ClientThread(Socket socket, List<ClientThread> allClients) {
        this.socket = socket;
        this.allClients = allClients;
    }

    public void broadcast(String message) {
        for (ClientThread ct : allClients) {
            ct.send(message);
        }
    }

    public void send(String message) {
        out.println("echo: " + message);
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            while (in.hasNextLine()) {
                String message = in.nextLine();
                System.out.println("Otrzymano: " + message);
                broadcast(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Zakończono połączenie " + socket);
            allClients.remove(this);    // usuń się z listy klientów
        }
    }
}

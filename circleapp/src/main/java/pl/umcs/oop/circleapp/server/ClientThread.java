package pl.umcs.oop.circleapp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        System.out.println("Client connected");
        String message;
        try {
            while ((message = reader.readLine()) != null)
                writer.println(message);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("CLient disconnected");
    }
}

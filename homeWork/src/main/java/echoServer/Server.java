package echoServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int PORT = 8000;
    private static String WORD_WITCH_END_SERVER = "end";

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
        ) {

            System.out.println("Waiting for connection.....");

            Socket clientSocket = serverSocket.accept();

            System.out.println("Connection successful");
            OutputStream outputStream = clientSocket.getOutputStream();
            InputStream inputStream = clientSocket.getInputStream();

            while (true) {
                byte[] buffer = new byte[100];
                int value = inputStream.read(buffer);
                String messageFromClient = new String(buffer, 0, value);
                if (messageFromClient.equalsIgnoreCase(WORD_WITCH_END_SERVER)) {
                    break;
                }
                String messageToClient = "echo: " + messageFromClient;
                outputStream.write(messageToClient.getBytes());
            }
        }
    }
}

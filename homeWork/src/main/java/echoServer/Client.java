package echoServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static int PORT = 8000;
    private static String WORD_WITCH_END_SERVER = "end";
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", PORT);) {

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            while (true) {
                System.out.print("message: ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase(WORD_WITCH_END_SERVER)) {
                    break;
                }
                outputStream.write(message.getBytes());

                byte[] buffer = new byte[100];
                int value = inputStream.read(buffer);
                String messageFromServer = new String(buffer, 0, value);
                System.out.println(messageFromServer);
            }

        }

    }
}

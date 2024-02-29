import java.io.*;
import java.net.*;
import java.util.*;

public class MyClient {
    public static void main(String[] args) {
        try {

            // Step 1: Create a socket and connect to the server
            Socket socket = new Socket("localhost",6666);



          // Step 2: Set up input and output streams for communication

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Step 3: Set up a BufferedReader to read input from the console

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage;
            String clientMessage;

            // Step 4: Start a loop for continuous communication
            while (true) {

                // Step 5: Get user input and send it to the server

                System.out.print("Client: ");

                clientMessage = consoleReader.readLine();

                writer.println(clientMessage);

                // Step 6: Check if the client wants to exit (by typing "bye")
                if (clientMessage.equals("bye")) {
                    break;
                }

                // Step 7: Receive and display messages from the server

                serverMessage = reader.readLine();
                System.out.println("Server: " + serverMessage);


                // Step 8: Check if the server wants to exit
                if (serverMessage.equals("bye")) {
                    break;
                }
            }
            // Step 9: Close streams and socket when done
            reader.close();
            writer.close();
            consoleReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


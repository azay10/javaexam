import java.io.*;
import java.net.*;

public class MyServer {

    public static void main(String[] args) {


        try {
            // Step 1: Create a ServerSocket that listens on port 6666

            ServerSocket serverSocket = new ServerSocket(6666);

            System.out.println("Server waiting for connection...");




            // Step 2: Wait for a client to connect and accept the connection

            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected");





            // Step 3: Set up input and output streams for communication with the client

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Step 4: Set up a BufferedReader to read input from the console

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            String serverMessage;


            // Step 5: Start a loop for continuous communication
            while (true) {

                // Step 6: Receive and display messages from the client
                clientMessage = reader.readLine();

                System.out.println("Client: " + clientMessage);

                // Step 7: Check if the client wants to exit (by typing "bye")

                if (clientMessage.equals("bye")) {
                    break;
                }

                // Step 8: Get server input and send it to the client

                System.out.print("Server: ");

                serverMessage = consoleReader.readLine();

                writer.println(serverMessage);

                // Step 9: Check if the server wants to exit

                if (serverMessage.equals("bye")) {
                    break;
                }
            }

            // Step 10: Close streams and sockets when done
            reader.close();
            writer.close();
            consoleReader.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

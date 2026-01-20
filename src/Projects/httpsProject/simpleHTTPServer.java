package Projects.httpsProject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class simpleHTTPServer {

    public static void main(String args[]) throws IOException {

        try (ServerSocket server = new ServerSocket(6969)) {
            System.out.println("Listening for connection on port 6969 ....");
            try (Socket socket = server.accept()) {
                System.out.println("Connection established. Sending response...");
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "Today's date\n\n" + today;
                socket.getOutputStream()
                        .write(httpResponse.getBytes("UTF-8"));
            }
        }
        System.out.println("Server is closed.");
    }
}

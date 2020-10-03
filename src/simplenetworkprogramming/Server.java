package simplenetworkprogramming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        new Server().runServer();
    }

    public void runServer() throws IOException {

        ServerSocket ss = new ServerSocket(9002);

        System.out.println("Server je UP...");

        while (true) {
            Socket s = ss.accept();

            new ServerTherad(s).start();

        }
    }

}

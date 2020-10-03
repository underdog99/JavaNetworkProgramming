package simplenetworkprogramming;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {

        String p;
        String m;

        Socket s = new Socket("localhost", 9002);
        System.out.println("Kreirana uticnicaa");

        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.println("Unesi poruku: ");

        p = in.readLine();

        System.out.println("Uneosi poruku: " + p);

        out.writeBytes(p + '\n');

        System.out.println("Poslata poruka serveru je: " + p);

        m = inFromServer.readLine();
        System.out.println("Primljena poruka od servera: " + m);
        s.close();
    }
}


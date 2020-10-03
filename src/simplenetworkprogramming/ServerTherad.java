package simplenetworkprogramming;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerTherad extends Thread {

    Socket socket;

    public ServerTherad(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {
            String msg = null;
            String mod;

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while ((msg = in.readLine()) != null) {
                //msg = in.readLine();
                System.out.println("Dolazna poruka: " + msg);
                mod = msg.toUpperCase() + '\n';
                System.out.println("Modifikovao sam poruku: " + mod);
                out.writeBytes(mod);
                System.out.println("Posalo mod poruku nazad klijentu");
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

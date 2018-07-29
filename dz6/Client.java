package dz6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String ip = "localhost";
        int port = 9910;
        Socket socket = new Socket(ip, port);
        if (socket.isConnected()) System.out.println("We are online");
        System.out.println("OUR CHAT IS CLOSED BY \"bye\"");
        Scanner enter = new Scanner(System.in);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String tmp = enter.nextLine();
                        if (tmp.equalsIgnoreCase("bye")) {
                            out.writeUTF(tmp);
                            socket.close();
                            System.exit(0);
                        }
                        out.writeUTF(tmp);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if(!socket.isConnected()) System.exit(0);
                        String tmp = in.readUTF();
                        if (tmp.equalsIgnoreCase("bye")) {
                            System.out.println("Server disconnected...");
                            out.writeUTF("bye");
                            socket.close();
                            System.exit(0);
                        }
                        System.out.println("Server: " + tmp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();

    }
}

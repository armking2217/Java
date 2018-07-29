package dz6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9910);
        System.out.println("Waiting Client...");
        Socket socket = server.accept();
        System.out.println("Client is online");
        System.out.println("OUR CHAT IS CLOSED BY \"bye\"");
        Scanner enter=new Scanner(System.in);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        String tmp=in.readUTF();
                        if(tmp.equalsIgnoreCase("bye")){
                            System.out.println("Client disconnected...");
                            server.close();
                            System.exit(0);
                        }
                        System.out.println("Client: " +  tmp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        String tmp=enter.nextLine();
                        /*if(tmp.equals("bye")){
                            out.writeUTF(tmp);
                            System.exit(0);
                        }*/
                        out.writeUTF(tmp);
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

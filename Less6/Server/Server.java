package Less6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server {

    private  Vector<ClientHandle> clients;
    public Server() {
        clients = new Vector<>();
        ServerSocket server =null;
        Socket socket =null;
        int i=0;
        try{
            server=new ServerSocket(9999);
            System.out.println("Server on");

            while(true){
                socket = server.accept();//На этом этапе код ждет пока не придет клиент
                System.out.println("Client on");
                i++;
                clients.add(new ClientHandle(this,socket,i));
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void drawCastMsg(String msg) throws IOException {
        for (ClientHandle o: clients) {
            if(o.isSockOn()) o.sentMsg(msg);
        }
    }
}

package Less6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandle {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private int number;

    public ClientHandle(Server server,Socket socket1,int number) {
        try {
            this.socket = socket1;
            this.number=number;
            this.out = new DataOutputStream(this.socket.getOutputStream());
            this.in = new DataInputStream(this.socket.getInputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        while (true) {
                            String str = in.readUTF();
                            if(str.equals("/end")) {
                                out.writeUTF("/end");
                                server.drawCastMsg("Client"+number+" "+" off...");
                                break;
                            }
                            server.drawCastMsg("Client"+number+": "+str);

                        }

                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }

                    finally{
                        try {
                            in.close();
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            //server.drawCastMsg("Client"+number+" is off...");
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sentMsg(String msg) throws IOException {
        if (msg.equals("/serverclosed")) {
            return;
        }
        out.writeUTF(msg);
    }
    public boolean isSockOn(){
        return !socket.isClosed();
    }
}

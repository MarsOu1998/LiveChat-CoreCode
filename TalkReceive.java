

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
    private DatagramSocket server;
    private int port;

    public TalkReceive(int port) throws SocketException {
        this.port = port;
        server=new DatagramSocket(port);
    }

    public void run() {
        while(true){
            byte[] contianer=new byte[1024*64];
            DatagramPacket packet=new DatagramPacket(contianer,0,contianer.length);
            try {
                server.receive(packet);
                byte[] datas=packet.getData();
                System.out.println("Ta:"+new String(datas, 0, packet.getLength()));
                if(datas.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        server.close();

    }
}

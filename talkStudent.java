

import java.net.SocketException;

public class talkStudent {
    public static void main(String[] args) throws SocketException {
        System.out.println("Student");
        new Thread(new TalkSend(7777,"127.0.0.1",9999)).start();
        new Thread(new TalkReceive(8888)).start();
    }
}

package main;

import java.net.SocketException;

public class talkTeacher {
    public static void main(String[] args) throws SocketException {
        System.out.println("Teacher");
        new Thread(new TalkReceive(9999)).start();
        new Thread(new TalkSend(6666,"127.0.0.1",8888)).start();
    }
}

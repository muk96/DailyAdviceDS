package org.example;

import java.io.PrintWriter;
import java.net.Socket;

public class Advice implements Runnable{
    private Socket socket;
    public static AdviceServer adviceServer;

    public Advice(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(PrintWriter printWriter= new PrintWriter(socket.getOutputStream());) {
            printWriter.println(adviceServer.getAdvice());

            printWriter.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class AdviceServer {
    String adviceList[] = {"Brush your teeth twice a day!", "Clean you room everyday!", "Follow your passion!", "Eat healthy!",
    "Prioritize fitness!", "Live, Laugh, Love!"};

    int portNo = 12345;
    public void go() {
        try(ServerSocket serverSock = new ServerSocket(portNo)) {
            while(true) {
                Socket sock = serverSock.accept();
                PrintWriter printWriter= new PrintWriter(sock.getOutputStream());
                printWriter.println(getAdvice());

                printWriter.flush();
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        AdviceServer adviceServer = new AdviceServer();
        adviceServer.go();
    }
}

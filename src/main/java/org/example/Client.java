package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    int portNo = 12345;

    public void go(){
        try{
            Socket socket = new Socket("127.0.0.1", portNo);

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            System.out.println("------------------------------------------------");
            System.out.println(bufferedReader.readLine());
            System.out.println("------------------------------------------------");
            bufferedReader.close();
            inputStreamReader.close();
        }
        catch (IOException e){
            System.out.println("IO exception occurred. Please check connection details.");
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.go();
    }
}

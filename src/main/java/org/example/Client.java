package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private Connection connection;
    private final String IP = "IP";
    private final String PORT = "Port";

    public void go(){
        String ipAddress = connection.getConnectionDetails().get(IP);
        int port = Integer.parseInt(connection.getConnectionDetails().get(PORT));

        try(Socket socket = new Socket(ipAddress, port);
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(is))
        {
            System.out.println("Connected to : " + ipAddress + ", port : " + port);
            String val;
            while((val = br.readLine()) != null){
                System.out.println(val);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        client.connection = new Connection();
        client.go();
    }
}

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Connection {
    private HashMap<String, String> connectionDetails;

    public HashMap<String, String> getConnectionDetails() {
        return connectionDetails;
    }

    public Connection() throws IOException {
        connectionDetails = new HashMap<>();
        readConnectionDetails();
    }

    private void readConnectionDetails() throws IOException {
        FileReader fileReader = new FileReader("//Users//mukulrana//IdeaProjects//DailyAdviceDS//src//main//resources//ConnectionDetails");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        try {
            String val;
            while ((val = bufferedReader.readLine()) != null) {
                String[] tokens = val.split(" ");
                connectionDetails.put(tokens[0], tokens[1]);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}

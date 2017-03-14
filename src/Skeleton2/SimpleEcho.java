/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skeleton2;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gab
 */
public class SimpleEcho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleEcho echo = new SimpleEcho();
        try {
            echo.execute();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SimpleEcho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void execute() throws UnknownHostException {
        SimpleClient client = new SimpleClient();
        SimpleServer server = new SimpleServer();

        String message = client.sendMessage();
        server.receiveMessage(message);
        message = server.sendMessage();
        client.receiveMessage(message);
    }
}

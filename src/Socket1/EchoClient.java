/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket1;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EchoClient {

    public static void main(String[] args) throws IOException {
        /* 
         This is to print the date and time 
         */
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        /*
         These variables are to print the details of client and server
         */
        InetAddress ipAddress = null;
        String hostname = null;
        String message = null;

        String serverHostname = new String("127.0.0.1");
        int portNumber = 10007;

        /*
         This is to print the details of client and server
         */
        System.out.println("[CLIENT][" + dateFormat.format(new Date()) + "] - Initializing Simple Client");
        ipAddress = InetAddress.getLocalHost();
        hostname = InetAddress.getLocalHost().getHostName();

        System.out.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Attemping to connect to host " + serverHostname + " on port " + portNumber);

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            // echoSocket = new Socket("taranis", 7);
            echoSocket = new Socket(serverHostname, portNumber);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Don't know about host: " + serverHostname + ":" + portNumber);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Couldn't get I/O for the connection to: " + serverHostname  + ":" + portNumber);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.print("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Enter the message to send to " + serverHostname + ":" + portNumber + ": ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println();
            System.out.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Received " + in.readLine() + " from " + serverHostname + ":" + portNumber + ": ");
            System.out.print("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Enter the message to send to " + serverHostname + ":" + portNumber + ": ");
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}

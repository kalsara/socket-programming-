/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket1;

import java.net.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EchoServer {

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
        /*
         This is the server-side socket
         */
        ServerSocket serverSocket = null;
        int          portNumber   = 10007;

        try {
            /*
             This is to print the details of client and server
             */
            System.out.println("[SERVER][" + dateFormat.format(new Date()) + "] - Initializing Simple Server");
            ipAddress = InetAddress.getLocalHost();
            hostname = InetAddress.getLocalHost().getHostName();

            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.err.println("[SERVER][" + ipAddress + "][" + dateFormat.format(new Date()) + "][ERROR] - Could not listen on port: " + portNumber);
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println("[SERVER][" + ipAddress + ":" + portNumber+"][" + dateFormat.format(new Date()) + "] - Waiting for connection.....");

        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("[SERVER][" + ipAddress + ":" + portNumber + "][" + dateFormat.format(new Date()) + "][ERROR] - Accept failed.");
            System.exit(1);
        }

        System.out.println("[SERVER][" + ipAddress + ":" + portNumber + "][" + dateFormat.format(new Date()) + "] - Connection successful.");
        System.out.println("[SERVER][" + ipAddress + ":" + portNumber + "][" + dateFormat.format(new Date()) + "] - Waiting for input.....");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("[SERVER][" + ipAddress + ":" + portNumber + "][" + dateFormat.format(new Date()) + "] - Server received: " + inputLine);
            System.out.println("[SERVER][" + ipAddress + ":" + portNumber + "][" + dateFormat.format(new Date()) + "] - Server sending back: " + inputLine);
            out.println(inputLine);

            if (inputLine.equals("Bye.")) {
            System.out.println("[SERVER][" + ipAddress + ":" + portNumber + "][" + dateFormat.format(new Date()) + "] - Terminating Server " + inputLine);
                break;
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

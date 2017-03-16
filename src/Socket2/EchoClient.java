/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket2;

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
        int portNumberA = 10007;
        int portNumberB = 10008;

        /*
         This is to print the details of client and server
         */
        System.out.println("[CLIENT][" + dateFormat.format(new Date()) + "] - Initializing Simple Client");
        ipAddress = InetAddress.getLocalHost();
        hostname = InetAddress.getLocalHost().getHostName();

        Socket echoSocketA = null;
        PrintWriter outA = null;
        BufferedReader inA = null;

        System.out.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Attemping to connect to host " + serverHostname + " on port " + portNumberA);
        try {
            echoSocketA = new Socket(serverHostname, portNumberA);
            outA = new PrintWriter(echoSocketA.getOutputStream(), true);
            inA = new BufferedReader(new InputStreamReader(
                    echoSocketA.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Don't know about host: " + serverHostname + ":" + portNumberA);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Couldn't get I/O for the connection to: " + serverHostname + ":" + portNumberA);
            System.exit(1);
        }

        Socket echoSocketB = null;
        PrintWriter outB = null;
        BufferedReader inB = null;

        System.out.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Attemping to connect to host " + serverHostname + " on port " + portNumberB);
        try {
            echoSocketB = new Socket(serverHostname, portNumberB);
            outB = new PrintWriter(echoSocketB.getOutputStream(), true);
            inB = new BufferedReader(new InputStreamReader(
                    echoSocketB.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Don't know about host: " + serverHostname + ":" + portNumberB);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Couldn't get I/O for the connection to: " + serverHostname + ":" + portNumberB);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.print("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Enter the message to send to " + serverHostname + ":" + portNumberA + "," + portNumberB + ": ");
        while ((userInput = stdIn.readLine()) != null) {
            outA.println(userInput);
            outB.println(userInput);
            System.out.println();
            System.out.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Received " + inA.readLine() + " from " + serverHostname + ":" + portNumberA + ": ");
            System.out.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Received " + inB.readLine() + " from " + serverHostname + ":" + portNumberB + ": ");
            System.out.print("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Enter the message to send to " + serverHostname + ":" + portNumberA + "," + portNumberB + ": ");
        }

        outA.close();
        inA.close();
        outB.close();
        inB.close();
        stdIn.close();
        echoSocketA.close();
        echoSocketB.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skeleton1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
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
        /* 
         This is to print the date and time 
         */
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        /*
         These variables are to print the details of client and server
         */
        InetAddress clientIpAddress = null;
        String      clientHostname  = null;
        InetAddress serverIpAddress = null;
        String      serverHostname  = null;
        try {
            /*
             This is to print the details of client and server
             */
            clientIpAddress = InetAddress.getLocalHost();
            clientHostname = InetAddress.getLocalHost().getHostName();
            serverIpAddress = InetAddress.getLocalHost();
            serverHostname = InetAddress.getLocalHost().getHostName();
        } 
        catch (UnknownHostException ex) 
        {
            Logger.getLogger(SimpleEcho.class.getName()).log(Level.SEVERE, null, ex);
        }
        // This simulates the Client
        Scanner scanner = new Scanner(System.in);
        System.out.print("[CLIENT][" + clientIpAddress + "][" + dateFormat.format(new Date()) + "] - Please enter a message to send to the server: ");
        String message = scanner.nextLine();
        System.out.println();
        System.out.println("[CLIENT][" + clientIpAddress + "][" + dateFormat.format(new Date()) + "] - The client is sending back to the server the following message: " + message);

        // This simulates the Server
        System.out.println("[SERVER][" + clientIpAddress + "][" + dateFormat.format(new Date()) + "] - The server has received following message: " + message);
        System.out.println("[SERVER][" + clientIpAddress + "][" + dateFormat.format(new Date()) + "] - The server is sending back to the client the following message: " + message);

        // This simulates the Client
        System.out.println("[CLIENT][" + clientIpAddress + "][" + dateFormat.format(new Date()) + "] - The client has received following message: " + message);
    }
}

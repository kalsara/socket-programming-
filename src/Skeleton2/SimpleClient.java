/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skeleton2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gab
 */
public class SimpleClient {
    /* 
     This is to print the date and time 
     */
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    /*
     These variables are to print the details of client and server
     */
    InetAddress ipAddress = null;
    String hostname = null;

    public SimpleClient() throws UnknownHostException {
        /*
         This is to print the details of client and server
         */
        System.out.println("[CLIENT][" + dateFormat.format(new Date()) + "] - Initializing Simple Client");
        ipAddress = InetAddress.getLocalHost();
        hostname = InetAddress.getLocalHost().getHostName();
    }

    public String sendMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - Please enter a message to send to the server: ");
        return scanner.nextLine();
    }

    public void receiveMessage(String message) 
    {
        System.out.println("[CLIENT][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - The client has received following message: " + message);
    }
}

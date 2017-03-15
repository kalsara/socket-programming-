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

/**
 *
 * @author Gab
 */
public class SimpleServer {
    /* 
     This is to print the date and time 
     */
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    /*
     These variables are to print the details of client and server
     */
    InetAddress ipAddress   =   null;
    String      hostname    =   null;
    String      message     =   null;
    /**
     *
     * @throws UnknownHostException
     */
    public SimpleServer() throws UnknownHostException {
        /*
         This is to print the details of client and server
         */
        System.out.println("[SERVER][" + dateFormat.format(new Date()) + "] - Initializing Simple Server");
        ipAddress = InetAddress.getLocalHost();
        hostname = InetAddress.getLocalHost().getHostName();
    }

    public String sendMessage() {
        System.out.println("[SERVER][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - The server is sending the following message: " + message);
        return message;
    }

    public void receiveMessage(String msg) 
    {
        System.out.println("[SERVER][" + ipAddress + "][" + dateFormat.format(new Date()) + "] - The server has received following message: " + msg);
        message =   msg;
    }
}

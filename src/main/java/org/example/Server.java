package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
//    public static String command = "";
    public static Socket client;
    public static void main(String[] args) {
        ServerSocket server = null;
        try{
//            server = new ServerSocket(3000);
    //            Thread serverThread = new Thread(() -> {
    //                Scanner scanner = new Scanner(System.in);
    //                command = scanner.nextLine();
    //            });
//            serverThread.start();
//            while (true) {
//                if(command.equals("EXIT")){
//                    serverThread.interrupt();
//                    serverThread.interrupt();
//                    break;
//                }
//                 client = server.accept();
//                Thread clientThread = new Thread(() -> {
//                    try{
//                        BufferedInputStream clientInputStream = new BufferedInputStream(client.getInputStream());
//                        int ascii;
//                        String data = "";
//                        while((ascii = clientInputStream.read()) != -1){
//                            data += (char)ascii;
//                        }
//                        System.out.println(data);
//                        BufferedOutputStream clientOutputStream = new BufferedOutputStream(client.getOutputStream());
//                        clientOutputStream.write((data+'\n').getBytes());
//                        clientOutputStream.flush();
//                        client.close();
//                    }
//                    catch (IOException ioe){
//                        System.out.println("client thread "+ioe);
//                    }
//                });
//                clientThread.start();
//            }
            server = new ServerSocket(3000);
            client = server.accept();
            BufferedInputStream input = new BufferedInputStream(client.getInputStream());
            BufferedOutputStream output = new BufferedOutputStream(client.getOutputStream());
            int ascii;
            String data = "";
            while((ascii = input.read()) != -1){
                if((char) ascii == '\n'){
                    break;
                }
                data += (char) ascii;
            }
            System.out.println(data);
            output.write(data.getBytes());
            output.flush();
//            client.close();
        }
        catch (IOException ioe){
            System.out.println("main thread"+ioe);
        }
    }
}
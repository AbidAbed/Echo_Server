package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedOutputStream output = null;
        try{
            String sentData = "";
                sentData = scanner.nextLine();
                Socket socket = new Socket("127.0.0.1",5000);
                output = new BufferedOutputStream(socket.getOutputStream());
                BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
                output.write((sentData+'\n').getBytes());
                output.flush();
                socket.setSoTimeout(10000);
                String dataReceived = "";
                int ascii;
                while((ascii = input.read())!= -1){
                    dataReceived += (char) ascii;
                    if((char)ascii == '\n')
                        break;
                }
                System.out.println(dataReceived);
                socket.close();

        }
        catch (SocketTimeoutException e) {
            System.out.println("Socket timed out - sending message...");
            try{
                output.write("EXIT".getBytes());
                output.flush();
            }catch (IOException ioException){
                System.out.println(ioException);
            }
        }
        catch (IOException ioe){
            System.out.println(ioe);
        }
    }
}

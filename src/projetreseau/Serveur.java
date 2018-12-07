/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author morga
 */
public class Serveur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        Socket clientSocket = null;
        
        try{
            serverSocket = new ServerSocket(4444);

        }catch(IOException e){
            System.out.println("Coulnd not listen on port 4444");
            System.exit(-1);
        }
         
        
         
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String serverInput;
        clientSocket = serverSocket.accept();
        System.out.println("Bonjour Client !");
        while(true){
           
                
            
         try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            
             while((serverInput = stdIn.readLine()) != null){
                out.println(stdIn.readLine());
                System.out.println(in.readLine());
            }
            
            
        }catch(IOException e){
            System.out.println("Accept failed on port 4444");
            System.exit(-1);
        }
        }
    }
    
    
}

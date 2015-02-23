package com.example.brucewil.simple_chat_client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by tmtwd on 15-02-22.
 */
public class Client {



    static String sentence;



    static String returnedSentence;
    Socket clientSocket = null;

    public Client(){
        sentence = "filler sentence";
        Socket connectionSocket = null;
        try {
            connectionSocket = new Socket("199.103.57.66", 7999);
        } catch (IOException e) {
            e.printStackTrace();
        }

            new Thread(new ClientThread(connectionSocket)).start();
            new Thread(new ListenToServer(connectionSocket)).start();

    }

    public static String getReturnedSentence() {
        return returnedSentence;
    }

    public static void setSentence(String sentence) {
        Client.sentence = sentence;
    }

    static class ListenToServer implements Runnable{

        Socket connectionSocket;

        public ListenToServer(Socket connectionSocket){
            this.connectionSocket = connectionSocket;
        }

        @Override
        public void run(){
            while(true){
                BufferedReader inFromServer = null;

                try {
                    inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                    returnedSentence = inFromServer.readLine();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    static class ClientThread implements Runnable {

        Socket connectionSocket;

        public ClientThread(Socket connectionSocket){
            this.connectionSocket = connectionSocket;
        }


        @Override
        public void run() {
            while(true){

                DataOutputStream outToServer = null;

                try{

                    outToServer =  new DataOutputStream(connectionSocket.getOutputStream());
                    outToServer.writeBytes(sentence);
                    outToServer.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

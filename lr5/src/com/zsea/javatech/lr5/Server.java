package com.zsea.javatech.lr5;

import com.zsea.javatech.lr1.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
    public static final int PORT_NUMBER = 8283;

    private List<ConnectionThread> connectionThreads = Collections.synchronizedList(new ArrayList<ConnectionThread>());
    private ServerSocket server;

    public Server() {
        try {
            server = new ServerSocket(PORT_NUMBER);

            while (true) {
                Utils.DBG("Server is waiting for connection");
                Socket socket = server.accept();
                ConnectionThread con = new ConnectionThread(socket);
                connectionThreads.add(con);
                Utils.DBG("Connection got");
                con.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        try {
            synchronized(connectionThreads) {
                for(ConnectionThread connectionThread : connectionThreads){
                    connectionThread.close();
                }
            }
            server.close();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ConnectionThread extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;

        public ConnectionThread(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                Utils.DBG("exception in connection to socket");
                e.printStackTrace();
                close();
            }
        }

        @Override public void run() {
            String name = null;
            try {
                name = in.readLine();
                Utils.DBG("Connected username ="+ name);
            } catch (IOException e) {
                e.printStackTrace();
                close();
            }

            String messageFromClient = null;
            while (true) {
                try {
                    messageFromClient = in.readLine();
                    if(!messageFromClient.isEmpty()) {
                        Utils.DBG("Message from Client " + messageFromClient);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    close();
                }
                if("exit".equals(messageFromClient)) {
                    close();
                    break;
                }
                for(ConnectionThread connectionThread :connectionThreads){
                    connectionThread.out.println(name+":"+messageFromClient);
                }
            }
        }

        public void close() {
            try {
                socket.shutdownInput();
                socket.shutdownOutput();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

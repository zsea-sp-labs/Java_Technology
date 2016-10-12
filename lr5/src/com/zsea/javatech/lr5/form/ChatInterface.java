package com.zsea.javatech.lr5.form;

import com.zsea.javatech.lr1.Utils;
import com.zsea.javatech.lr5.Server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatInterface extends JFrame {
    private JPanel ChatInterface;
    private JButton connectButton;
    private JTextField serverIPTextField;
    private JTextField yourNicknameTextField;
    public JTextArea chatTextArea;
    private JTextArea yourMessageTextArea;
    private JButton sendMessageButton;

    String ip;
    String nickname;

    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public ChatInterface() {

        //final JScrollPane scrollPane = new JScrollPane(chatTextArea);

        setContentPane(ChatInterface);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatTextArea.setEditable(false);
        String defaultIp = "127.0.0.1";
        serverIPTextField.setText(defaultIp);
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ip = serverIPTextField.getText();
                nickname = yourNicknameTextField.getText();
                try {
                    socket = new Socket(ip, Server.PORT_NUMBER); //TODO test with null as loop adress
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(nickname);
                    Utils.DBG("Socket isConnected "+ socket.isConnected());
                    Reader reader = new Reader();
                    reader.start();
                    //reader.setStop();

                } catch (Exception e) {
                    e.printStackTrace();
                    close();
                }
            }
        });

        sendMessageButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                out.println(yourMessageTextArea.getText());
            }
        });

        chatTextArea.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                chatTextArea.setLineWrap(true);
                chatTextArea.setWrapStyleWord(true);
            }
        });

        yourMessageTextArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                yourMessageTextArea.setLineWrap(true);
                yourMessageTextArea.setWrapStyleWord(true);
            }
        });
        setVisible(true);
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Reader extends Thread {

        private boolean stoped;
        public void stopReader() {
            stoped = true;
        }

        @Override
        public void run() {
            try {
                while (!stoped) {
                    String strOut = in.readLine();
                    chatTextArea.setText(chatTextArea.getText() +"/n"+strOut);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


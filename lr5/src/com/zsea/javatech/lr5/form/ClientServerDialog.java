package com.zsea.javatech.lr5.form;

import com.zsea.javatech.lr1.Utils;
import com.zsea.javatech.lr5.Client;
import com.zsea.javatech.lr5.Server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientServerDialog extends JFrame {

    private JButton clientButton;
    private JButton serverButton;
    private JPanel modePanel;
    private Server server = null;
    private JFrame jFrame = this;

    public ClientServerDialog() {

        setContentPane(modePanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Client();
                jFrame.dispose();
            }
        });

        serverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientButton.setEnabled(false);
                if (server == null){
                    server = new Server();
                    serverButton.setText("Stop server");
                } else {
                    Utils.DBG("Trying to stop server");
                    server.stopServer();
                    jFrame.dispose();
                }
            }
        });

        setVisible(true);
    }
}


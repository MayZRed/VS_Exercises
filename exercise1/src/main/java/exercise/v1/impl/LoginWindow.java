package exercise.v1.impl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginWindow implements ActionListener {

    private static final Logger logger = Logger.getLogger("WindowLauncher");

    // window declaration
    JFrame window = new JFrame();
    // button declaration
    JButton exit = new JButton("Exit");
    JButton login = new JButton("Login");
    // text field declaration
    JTextField warning = new JTextField(" Username and/or password is not valid! Please retry.");
    JTextField nameDesc = new JTextField("Username:");
    JTextField passwdDesc = new JTextField("Password:");
    JTextField name = new JTextField("");
    JTextField passwd = new JTextField("");

    public LoginWindow() throws IOException {
        // provide window properties
        int screenWidth = 400;
        int screenHeight = 225;
        Color baseColor = new Color(255,236,139);

        // set window accordingly
        window.setSize(screenWidth, screenHeight);
        window.getContentPane().setBackground(baseColor);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // configure exit button
        exit.setBounds(15, 150, 100, 25);
        exit.setFocusable(false);
        exit.addActionListener(this);

        // configure login button
        login.setBounds(screenWidth-130, 150, 100, 25);
        login.setFocusable(false);
        login.addActionListener(this);

        // configure warning field
        warning.setBounds(50, 0, 300, 20);
        warning.setBackground(new Color(248, 32, 32));
        warning.setBorder(BorderFactory.createEmptyBorder());
        warning.setEditable(false);
        warning.setVisible(false);

        // configure name field
        nameDesc.setBounds(55, 30, 70, 30);
        nameDesc.setFont(new Font(nameDesc.getFont().getName(),Font.BOLD,nameDesc.getFont().getSize()));
        nameDesc.setBackground(baseColor);
        nameDesc.setBorder(BorderFactory.createEmptyBorder());
        nameDesc.setEditable(false);
        name.setBounds(125, 30, 200, 30);
        name.setFocusable(true);

        // configure password field
        passwdDesc.setBounds(55, 90, 70, 30);
        passwdDesc.setFont(new Font(passwdDesc.getFont().getName(),Font.BOLD,passwdDesc.getFont().getSize()));
        passwdDesc.setBackground(baseColor);
        passwdDesc.setBorder(BorderFactory.createEmptyBorder());
        passwdDesc.setEditable(false);
        passwd.setBounds(125, 90, 200, 30);
        passwd.setFocusable(true);

        // put content in window
        window.add(nameDesc);
        window.add(name);
        window.add(passwdDesc);
        window.add(passwd);
        window.add(exit);
        window.add(login);
        window.add(warning);

        logger.log(Level.INFO, "this is to buffer the last action of this window");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit) window.dispose();
        if(e.getSource()==login) {
            SecurityConfig sec = new SecurityConfig();
            if(sec.authorizationCheck(name.getText(), passwd.getText())) {
                System.out.println("Successfully logged in...");
                warning.setVisible(false);
            } else {
                warning.setVisible(true);
            }
        }
    }

}

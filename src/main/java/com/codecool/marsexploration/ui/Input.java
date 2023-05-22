package com.codecool.marsexploration.ui;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class Input {
    private JTextField field1, field2, field3, field4, field5, field6, field7;
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private JButton saveButton;
    private boolean isPressed;
    private int timeout;
    private int landingX;
    private int landingY;
    private int roverId;
    private int sight;
    private int alienX;
    private int alienY;
    private String testString;

    public boolean isPressed() {
        return isPressed;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getLandingX() {
        return landingX;
    }

    public int getLandingY() {
        return landingY;
    }

    public int getRoverId() {
        return roverId;
    }

    public int getSight() {
        return sight;
    }

    public int getAlienX() {
        return alienX;
    }

    public int getAlienY() {
        return alienY;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public void initialize(){

        JFrame f=new JFrame();//creating instance of JFrame



        label1=new JLabel("Timeout: ");
        label1.setBounds(50,50, 100,30);
        field1=new JTextField();
        field1.setBounds(200,50, 200,30);

        label2=new JLabel("Landing Position X: ");
        label2.setBounds(50,100, 150,30);
        field2= new JTextField();
        field2.setBounds(200,100,200,30);

        label3=new JLabel("Landing Position Y: ");
        label3.setBounds(50,150, 150,30);
        field3= new JTextField();
        field3.setBounds(200,150,200,30);

        label4=new JLabel("Rover Id: ");
        label4.setBounds(50,200, 100,30);
        field4=new JTextField();
        field4.setBounds(200,200, 200,30);

        label5=new JLabel("Sight: ");
        label5.setBounds(50,250, 150,30);
        field5= new JTextField();
        field5.setBounds(200,250,200,30);

        label6=new JLabel("AlienX: ");
        label6.setBounds(50,300, 150,30);
        field6= new JTextField();
        field6.setBounds(200,300,200,30);

        label7=new JLabel("AlienY: ");
        label7.setBounds(50,350, 100,30);
        field7=new JTextField();
        field7.setBounds(200,350, 200,30);





        JButton b=new JButton("Submit");//creating instance of JButton
        b.setBounds(250,400,100, 40);//x axis, y axis, width, height
        b.addActionListener(this::actionPerformed);

        f.add(label1); f.add(label2);f.add(label3);f.add(label4);f.add(label5);f.add(label6);f.add(label7);
        f.add(field1);f.add(field2);f.add(field3);f.add(field4);f.add(field5);f.add(field6);f.add(field7);
        f.add(b);//adding button in JFrame*/

       /* int a = Integer.parseInt(field1.getText());
        System.out.println(a);*/


        f.setSize(500,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        //f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);//making the frame visible

    }
    public void actionPerformed(ActionEvent e) {
        timeout = Integer.parseInt(field1.getText());
        System.out.println("1 " +timeout);
        landingX = Integer.parseInt(field2.getText());
        System.out.println("2 " +landingX);
        landingY = Integer.parseInt(field3.getText());
        System.out.println(landingY);
        roverId = Integer.parseInt(field4.getText());
        System.out.println(roverId);
        sight = Integer.parseInt(field5.getText());
        System.out.println(sight);
        alienX = Integer.parseInt(field6.getText());
        System.out.println(alienX);
        alienY = Integer.parseInt(field7.getText());
        System.out.println(alienY);
        System.out.println("You have clicked the ACTIVE button times");
        System.out.println(e.getActionCommand().isEmpty());
        isPressed = true;
    }
}
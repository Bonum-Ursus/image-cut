package com.bonum.ursus;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyFrame extends JFrame {
    public static void main(String[] args) {
        new MyFrame();
    }
    public MyFrame(){
        setTitle("Image converter");
        setBounds(250,250,400,200);
        JButton button = new JButton("Convert images");

        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(button);
        this.getContentPane().add(panel);
        JLabel topLabel = new JLabel("Кол-во пикселей сверху: ");
        JTextField textField = new JTextField(5);
        panel.add(topLabel);
        panel.add(textField);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField chosenDir = new JTextField(25);
        panel.add(chosenDir);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser dialog = new JFileChooser();
                dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                dialog.setApproveButtonText("OK");
                dialog.setDialogTitle("Выбрать папку с изображениями");
                dialog.setDialogType(JFileChooser.OPEN_DIALOG);
                dialog.setMultiSelectionEnabled(false);
                dialog.showOpenDialog(MyFrame.this);

                File file = dialog.getSelectedFile();
                chosenDir.setText(file.getAbsolutePath());
                System.out.println(file.getAbsolutePath());
                setVisible(true);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
//    String imgPath = "c:\\Users\\Viktor\\Desktop\\me.png";
//    File file = new File(imgPath);
//    BufferedImage bi = ImageIO.read(file);
//    BufferedImage subimage = bi.getSubimage(0, 30, bi.getWidth(), bi.getHeight()-80);
//    ImageIO.write(subimage, "png", new File("newFile.png"));

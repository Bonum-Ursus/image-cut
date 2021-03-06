package com.bonum.ursus;

import org.w3c.dom.ls.LSOutput;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class MyFrame extends JFrame {
    private JPanel panel1;

    public static void main(String[] args) {
        new MyFrame();
    }
    public MyFrame(){
        int windowWidth = 500;
        int windowHeight = 400;
        setTitle("Bonum-Ursus");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width/2 - windowWidth/2,dimension.height/2 - windowHeight/2,
                windowWidth,windowHeight);
        JButton button = new JButton("Обрезать изображения");

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
        button.addActionListener(actionEvent -> {
            JFileChooser dialog = new JFileChooser();
            dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            dialog.setApproveButtonText("OK");
            dialog.setDialogTitle("Выбираем папку с изображениями");
            dialog.setDialogType(JFileChooser.OPEN_DIALOG);
            dialog.setMultiSelectionEnabled(false);
            dialog.showOpenDialog(MyFrame.this);

            File file = dialog.getSelectedFile();
            chosenDir.setText(file.getAbsolutePath());
            System.out.println(file.getAbsolutePath());
            File[] files = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return true;
                }
            });
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getAbsolutePath());
            }
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
    }
}
//    String imgPath = "c:\\Users\\Viktor\\Desktop\\me.png";
//    File file = new File(imgPath);
//    BufferedImage bi = ImageIO.read(file);
//    BufferedImage subimage = bi.getSubimage(0, 30, bi.getWidth(), bi.getHeight()-80);
//    ImageIO.write(subimage, "png", new File("newFile.png"));

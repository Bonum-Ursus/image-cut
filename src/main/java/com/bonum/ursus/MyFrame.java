package com.bonum.ursus;

import javax.swing.*;
import java.io.File;

public class MyFrame extends JFrame {
    public static void main(String[] args) {
        new MyFrame();
    }
    public MyFrame(){
        setTitle("Image converter");
        setBounds(0,0,500,500);
        JFileChooser dialog = new JFileChooser();
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setApproveButtonText("Выбрать");
        dialog.setDialogTitle("Выберите файл для загрузки");
        dialog.setDialogType(JFileChooser.OPEN_DIALOG);
        dialog.setMultiSelectionEnabled(true);
        dialog.showOpenDialog(this);
        File[] file = dialog.getSelectedFiles();
        for (File f : file) {
            System.out.println(f.getAbsolutePath());
        }
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

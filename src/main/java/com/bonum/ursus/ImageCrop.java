package com.bonum.ursus;


import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCrop {
    public static void main(String[] args) throws IOException {
        String imgPath = "c:\\Users\\Viktor\\Desktop\\me.png";
        File file = new File(imgPath);
        BufferedImage bi = ImageIO.read(file);
        BufferedImage subimage = bi.getSubimage(0, 30, bi.getWidth(), bi.getHeight()-80);
        ImageIO.write(subimage, "png", new File("newFile.png"));
    }
}

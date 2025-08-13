package com.example.ui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LoadIcon {
    public ImageIcon loadIcon(String path, int size) {
        URL url = getClass().getResource(path);
        if (url == null) return null;
        Image img = new ImageIcon(url).getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}

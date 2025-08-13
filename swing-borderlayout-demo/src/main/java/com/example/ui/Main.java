package com.example.ui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BorderLayoutDemo frame = new BorderLayoutDemo();
            frame.setVisible(true);
        });
    }
}

package com.example.ui;

import javax.swing.*;
import java.awt.*;

public class Button {
    LoadIcon loadIcon = new LoadIcon();

    public JButton createButton(String text, String iconPath, String tooltipHtml, int mnemonic) {
        JButton b = new JButton(text);
        ImageIcon icon = loadIcon.loadIcon(iconPath, 18);
        if (icon != null) {
            b.setIcon(icon);
        }
        b.setToolTipText(tooltipHtml);
        b.setMnemonic(mnemonic);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setFocusPainted(false);
        b.setBorder(new javax.swing.border.EmptyBorder(8, 12, 8, 12));

        b.addActionListener(e -> JOptionPane.showMessageDialog(b, "Clique em " + text + "!", "Ação", JOptionPane.INFORMATION_MESSAGE));

        return b;
    }
}

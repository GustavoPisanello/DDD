package com.example.ui;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JFrame {

    public BorderLayoutDemo() {
        super("BorderLayout Demo");
        initialize();
    }

    private void initialize() {
        configureLookAndFeel();
        configureFrame();
        addComponents();
    }

    private void configureLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) { /* Fallback para o L&F padrão */ }
    }

    LoadIcon loadIcon = new LoadIcon();

    private void configureFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        setSize(420, 300);
        setLocationRelativeTo(null);

        ImageIcon appIcon = loadIcon.loadIcon("/icons/app.png", 32);
        if (appIcon != null) {
            setIconImage(appIcon.getImage());
        }
    }

    private void addComponents() {
        Button button = new Button();

        // Criar os botões usando a fábrica
        JButton btnNorte = button.createButton(
                "NORTE", "/icons/north.png",
                "<html><b>Ir para o Norte</b><br/>Atalho: Alt+N</html>", 'N');

        JButton btnSul = button.createButton(
                "SUL", "/icons/south.png",
                "<html><b>Ir para o Sul</b><br/>Atalho: Alt+S</html>", 'S');

        JButton btnOeste = button.createButton(
                "OESTE", "/icons/west.png",
                "<html><b>Ir para o Oeste</b><br/>Atalho: Alt+O</html>", 'O');

        JButton btnLeste = button.createButton(
                "LESTE", "/icons/east.png",
                "<html><b>Ir para o Leste</b><br/>Atalho: Alt+L</html>", 'L');

        JButton btnCentro = button.createButton(
                "CENTRO", "/icons/center.png",
                "<html><b>Ação do Centro</b><br/>Atalho: Alt+C</html>", 'C');

        // Adicionar os botões no layout
        add(btnNorte,  BorderLayout.NORTH);
        add(btnSul,    BorderLayout.SOUTH);
        add(btnOeste,  BorderLayout.WEST);
        add(btnLeste,  BorderLayout.EAST);
        add(btnCentro, BorderLayout.CENTER);
    }
}
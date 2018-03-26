package com.jalasoft.search.View;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    JButton simpleSearchButton;
    SearchMenu menuPanel;
    SimpleFieldsPanel simpleFieldPanel;
    JPanel fieldsPanel;

    public MainWindow() {
        super("Search App - Group E");
    }

    public void displayMainWindow() {
        this.getContentPane().setLayout(new BorderLayout());
        simpleSearchButton = new JButton("Simple");
        menuPanel = new SearchMenu();
        simpleFieldPanel = new SimpleFieldsPanel();
        fieldsPanel = new JPanel(new GridLayout(2,1));
        fieldsPanel.add(simpleFieldPanel);
        this.getContentPane().add(menuPanel, BorderLayout.WEST);
        this.getContentPane().add(fieldsPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setVisible(true);
        window.displayMainWindow();
    }
}
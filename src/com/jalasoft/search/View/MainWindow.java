package com.jalasoft.search.View;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    SearchMenu menuPanel;
    SimpleFieldsPanel simpleFieldPanel;
    AdvancedFieldsPanel advancedFieldPanel;
    ResultSearchPanel resultSearchPanel;
    JPanel fieldsPanel;

    public MainWindow() {
        super("Search App - Group E");
    }

    public void displayMainWindow() {
        this.getContentPane().setLayout(new BorderLayout());
        menuPanel = new SearchMenu();
        simpleFieldPanel = new SimpleFieldsPanel();
        advancedFieldPanel = new AdvancedFieldsPanel();
        resultSearchPanel = new ResultSearchPanel();
        fieldsPanel = new JPanel(new GridLayout(3,1));
        fieldsPanel.add(simpleFieldPanel);
        fieldsPanel.add(advancedFieldPanel);
        fieldsPanel.add(resultSearchPanel);
        this.getContentPane().add(menuPanel, BorderLayout.WEST);
        this.getContentPane().add(fieldsPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setVisible(true);
        window.repaint();
        window.displayMainWindow();
    }

    public String getPathText(){
        return simpleFieldPanel.getFilenameTextField();
    }

    public String getFileNameText(){
        return simpleFieldPanel.getPathTextField();
    }
}
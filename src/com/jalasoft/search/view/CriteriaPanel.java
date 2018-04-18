package com.jalasoft.search.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CriteriaPanel extends JPanel {
    private JPanel tablePanel;
    private JPanel saveCriteriaFormPanel;
    private JLabel criteriaSaveLabel;
    private JTextField criteriaSaveTextField;
    private JButton criteriaSaveButton;

    private JTable criteriaTable;
    private DefaultTableModel defaultTableModel;
    //headers for the table
    private String[] headerTable = new String[] { "ID", "Criteria Name" };

    public CriteriaPanel(){
        init();
    }

    private void init() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Criteria Table"));
        this.setPreferredSize(new Dimension(1000, 200));

        tablePanel = new JPanel(new GridLayout(1,1));
        tablePanel.setPreferredSize(new Dimension(700,200));

        defaultTableModel = new DefaultTableModel(new Object[][] { }, headerTable);
        criteriaTable = new JTable(defaultTableModel);
        tablePanel.add(new JScrollPane(criteriaTable));

        saveCriteriaFormPanel = new JPanel(new GridLayout(3,1));
        saveCriteriaFormPanel.setLayout(new BoxLayout(saveCriteriaFormPanel, BoxLayout.Y_AXIS));
        saveCriteriaFormPanel.setPreferredSize(new Dimension(300,200));
        this.add(tablePanel);
        this.add(saveCriteriaFormPanel);

        defaultTableModel.addRow(new Object[]{ "1", "Criteria 1"});
        defaultTableModel.addRow(new Object[]{ "2", "Criteria 2"});
        defaultTableModel.addRow(new Object[]{ "3", "Criteria 3"});
        defaultTableModel.addRow(new Object[]{ "4", "Criteria 4"});
        defaultTableModel.addRow(new Object[]{ "5", "Criteria 5"});

        criteriaTable.getSelectionModel().addListSelectionListener(e -> loadCriteria());

        criteriaSaveLabel = new JLabel("Criteria Name");
        criteriaSaveLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        criteriaSaveTextField = new JTextField(15);
        criteriaSaveTextField.setMaximumSize(criteriaSaveTextField.getPreferredSize());
        criteriaSaveTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        criteriaSaveButton = new JButton("Save");
        criteriaSaveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        saveCriteriaFormPanel.add(criteriaSaveLabel);
        saveCriteriaFormPanel.add(criteriaSaveTextField);
        saveCriteriaFormPanel.add(criteriaSaveButton);
    }

    private void loadCriteria() {
        System.out.println("Selected: " + criteriaTable.getValueAt(criteriaTable.getSelectedRow(),1));
    }

    /**
     * This method is to add rows on result table about search results
     * */
    public void addRowOnTable(Object[] newRow){
        defaultTableModel.addRow(newRow);
    }

    public JButton getCriteriaSaveButton(){
        return criteriaSaveButton;
    }
}

/*
 * Search .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.view;
import javax.swing.*;
import java.awt.*;

/**
 *
 This class implements the GUI for Body adding all fields panels this.
 *
 * @version  1.0
 * @author Rodrigo Saul Cespedes Murillo
 */
public class BodyPanel extends JPanel {

    private JPanel fieldsPanel;
    private SimpleFieldsPanel simpleFieldPanel;
    private AdvancedFieldsPanel advancedFieldPanel;
    private CriteriaPanel criteriaPanel;
    private ResultSearchPanel resultSearchPanel;

    /**
     * Constructor calls to init method to initialize all components
     * */
    public BodyPanel(){
        init();
    }

    /**
     * * This method initialize all components all components on body Panel
     * */
    private void init() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(1000,900));

        simpleFieldPanel = new SimpleFieldsPanel();
        advancedFieldPanel = new AdvancedFieldsPanel();
        criteriaPanel = new CriteriaPanel();
        resultSearchPanel = new ResultSearchPanel();

        fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(1,2));
        fieldsPanel.setPreferredSize(new Dimension(1000, 200));
        fieldsPanel.add(simpleFieldPanel);
        fieldsPanel.add(advancedFieldPanel);

        this.add(fieldsPanel);
        this.add(criteriaPanel);
        this.add(resultSearchPanel);
    }

    /**
     * This method returns simpleFieldPanel instance
     * @return SimpleFieldsPanel simpleFieldPanel component
     * */
    public SimpleFieldsPanel getSimpleFieldPanel(){
        return simpleFieldPanel;
    }

    /**
     * This method returns AdvancedFieldsPanel instance
     * @return AdvancedFieldsPanel advancedFieldPanel component
     * */
    public AdvancedFieldsPanel getAdvancedFieldPanel(){
        return advancedFieldPanel;
    }

    /**
     * This method returns ResultSearchPanel instance
     * @return ResultSearchPanel resultSearchPanel component
     * */
    public ResultSearchPanel getResultSearchPanel(){
        return resultSearchPanel;
    }
}
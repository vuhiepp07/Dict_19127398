package vn.edu.hcmus.student.sv19127398;

import javax.swing.*;
import java.awt.*;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/23/2021 - 10:44 PM
 * Description: ...
 */
public class MenuFrame extends JFrame{
    JLabel StudentInfo, MenuLabel;
    JButton SearchByWord_btn, SearchByDef_btn, ViewSearchHistory_btn, AddNewSlang_btn,
            EditSlang_btn, DeleteSlang_btn, ResetDict_btn, RandomSlang_btn, Quiz_btn, About_btn, Exit_btn;
    static JFrame ThisFrame;

    public MenuFrame(){
        StudentInfo = new JLabel("19127398");
        MenuLabel = new JLabel("DICTIONARY");
        SearchByWord_btn = new JButton("Search by word");
        SearchByDef_btn = new JButton("Search by definition");
        ViewSearchHistory_btn = new JButton("View search history");
        AddNewSlang_btn = new JButton("Add new slang word to dictionary");
        EditSlang_btn = new JButton("Edit a slang word");
        DeleteSlang_btn = new JButton("Delete a slang word");
        ResetDict_btn = new JButton("Reset dictionary data to default");
        RandomSlang_btn = new JButton("Random a slang word");
        Quiz_btn = new JButton("Play quiz game");
        About_btn = new JButton("About");
        Exit_btn = new JButton("Exit");
        EventHandler eventListener = new EventHandler();

        SearchByWord_btn.setActionCommand("SearchByWord");
        SearchByDef_btn.setActionCommand("SearchByDefinition");
        ViewSearchHistory_btn.setActionCommand("ViewSearchHistory");
        AddNewSlang_btn.setActionCommand("AddNewSlang");
        EditSlang_btn.setActionCommand("EditSlang");
        DeleteSlang_btn.setActionCommand("DeleteSlang");
        ResetDict_btn.setActionCommand("ResetDictionary");
        RandomSlang_btn.setActionCommand("RandomSlang");
        Quiz_btn.setActionCommand("PlayQuiz");
        About_btn.setActionCommand("AboutStudent");
        Exit_btn.setActionCommand("ExitMenuFrame");

        SearchByWord_btn.addActionListener(eventListener);
        SearchByDef_btn.addActionListener(eventListener);
        ViewSearchHistory_btn.addActionListener(eventListener);
        AddNewSlang_btn.addActionListener(eventListener);
        EditSlang_btn.addActionListener(eventListener);
        DeleteSlang_btn.addActionListener(eventListener);
        ResetDict_btn.addActionListener(eventListener);
        RandomSlang_btn.addActionListener(eventListener);
        Quiz_btn.addActionListener(eventListener);
        About_btn.addActionListener(eventListener);
        Exit_btn.addActionListener(eventListener);
        addComponentsToFrame(getContentPane());
    }

    public void addComponentsToFrame(Container container){
        container.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        headerPanel.add(MenuLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0,20)));

        JPanel menuOptions = new JPanel();
        menuOptions.setLayout(new BoxLayout(menuOptions,BoxLayout.Y_AXIS));
        addComponentsToMenuPanel(menuOptions, SearchByWord_btn);
        addComponentsToMenuPanel(menuOptions, SearchByDef_btn);
        addComponentsToMenuPanel(menuOptions, ViewSearchHistory_btn);
        addComponentsToMenuPanel(menuOptions, EditSlang_btn);
        addComponentsToMenuPanel(menuOptions, DeleteSlang_btn);
        addComponentsToMenuPanel(menuOptions, ResetDict_btn);
        addComponentsToMenuPanel(menuOptions, RandomSlang_btn);
        addComponentsToMenuPanel(menuOptions, Quiz_btn);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout());
        footerPanel.add(About_btn);
        footerPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        footerPanel.add(Exit_btn);

        container.add(headerPanel, BorderLayout.PAGE_START);
        container.add(menuOptions, BorderLayout.CENTER);
        container.add(footerPanel, BorderLayout.PAGE_END);
    }

    public void addComponentsToMenuPanel(JPanel menuOptions, JButton btn){
        menuOptions.add(btn, Component.CENTER_ALIGNMENT);
        menuOptions.add(Box.createRigidArea(new Dimension(0,10)));
    }

    public static void CreateAndShowMenuFrame(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        ThisFrame = new MenuFrame();
        ThisFrame.pack();
        ThisFrame.setVisible(true);
        ThisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void closeFrame(){
        ThisFrame.dispose();
    }
}

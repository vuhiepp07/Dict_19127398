package vn.edu.hcmus.student.sv19127398;

import javax.swing.*;
import java.awt.*;
import java.util.zip.GZIPInputStream;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 1/4/2022 - 11:32 AM
 * Description: ...
 */
public class AboutFrame extends JFrame {
    JLabel NameLabel, IDLabel, ClassLabel, TheoryLabel, PraticeLabel1, PraticeLabel2, SchoolLabel;
    JButton Ok_btn;
    static JFrame ThisFrame;

    /**
     * Default constructor, initialize labels, buttons, set action command and add action listener to the buttons
     */
    public  AboutFrame(){
        SchoolLabel = new JLabel("HCM UNIVERSITY OF SCIENCE");
        NameLabel = new JLabel("Author: " + "Vu Quang Hiep");
        IDLabel = new JLabel("Student ID: " + "19127398");
        ClassLabel = new JLabel("Class: JAVA KTPM03");
        TheoryLabel = new JLabel("Theory lecturer: Nguyen Van Khiet");
        PraticeLabel1 = new JLabel("Pratice instructor 1: Nguyen Duc Huy");
        PraticeLabel2 = new JLabel("Pratice instructor 2: Nguyen Van Vu");

        Ok_btn = new JButton("OK");
        Ok_btn.setActionCommand("AboutBackToMenuFrame");
        EventHandler eventListener = new EventHandler();
        Ok_btn.addActionListener(eventListener);
        addComponentsToFrame(getContentPane());
    }

    /**
     * Add buttons, labels to panel and the add panels to the frame
     * @param container Container
     */
    public void addComponentsToFrame(Container container){
        container.setLayout(new GridLayout(0,1));

        JPanel InformationPanel = new JPanel();
        InformationPanel.setLayout(new GridLayout(0, 1));
        InformationPanel.add(SchoolLabel);
        InformationPanel.add(NameLabel);
        InformationPanel.add(IDLabel);
        InformationPanel.add(ClassLabel);
        InformationPanel.add(TheoryLabel);
        InformationPanel.add(PraticeLabel1);
        InformationPanel.add(PraticeLabel2);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());
        footerPanel.add(Ok_btn, BorderLayout.PAGE_END);

        container.add(InformationPanel);
        container.add(footerPanel);
    }

    /**
     * Create and set visible to the About Frame
     */
    public static void CreateAndShowAboutFrame(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        ThisFrame = new AboutFrame();
        ThisFrame.pack();
        ThisFrame.setVisible(true);
        ThisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Exit and close the frame
     */
    public static void closeFrame(){
        ThisFrame.dispose();
    }
}

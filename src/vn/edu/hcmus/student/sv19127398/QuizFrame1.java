package vn.edu.hcmus.student.sv19127398;

import javax.swing.*;
import java.awt.*;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/25/2021 - 10:56 PM
 * Description: ...
 */
public class QuizFrame1 extends JFrame {
    JLabel FrameLabel;
    JButton QuizBySlang_btn, QuizByDef_btn, Cancel_btn;
    static JFrame ThisFrame;

    /**
     * Default constructor, initialize buttons and labels of the frame, set action command and add action listener
     */
    public QuizFrame1(){
        FrameLabel = new JLabel("CHOOSE ONE TYPE OF QUIZ");
        QuizBySlang_btn = new JButton("Quiz by Slang");
        QuizByDef_btn = new JButton("Quiz by Definition");
        Cancel_btn = new JButton("Cancel");

        QuizBySlang_btn.setActionCommand("QuizBySlang");
        QuizByDef_btn.setActionCommand("QuizByDefinition");
        Cancel_btn.setActionCommand("Quiz1BackToMenuFrame");

        EventHandler eventListener = new EventHandler();
        QuizBySlang_btn.addActionListener(eventListener);
        QuizByDef_btn.addActionListener(eventListener);
        Cancel_btn.addActionListener(eventListener);
        addComponentsToFrame(getContentPane());
    }

    /**
     * Add Buttons and Labels to Panels, then add Panels to frame
     * @param container
     */
    public void addComponentsToFrame(Container container){
        container.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        headerPanel.add(FrameLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0,20)));

        JPanel QuizOptions = new JPanel();
        QuizOptions.setLayout(new GridLayout(0,1));
        QuizOptions.add(QuizBySlang_btn);
        QuizOptions.add(QuizByDef_btn);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout());
        footerPanel.add(Cancel_btn);

        container.add(headerPanel, BorderLayout.PAGE_START);
        container.add(QuizOptions, BorderLayout.CENTER);
        container.add(footerPanel, BorderLayout.PAGE_END);
    }

    /**
     * Create and set visible to the Quiz frame
     */
    public static void CreateAndShowQuizFrame1(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        ThisFrame = new QuizFrame1();
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

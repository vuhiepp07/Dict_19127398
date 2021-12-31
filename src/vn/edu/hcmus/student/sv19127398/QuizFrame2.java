package vn.edu.hcmus.student.sv19127398;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/25/2021 - 10:56 PM
 * Description: ...
 */
public class QuizFrame2 extends JFrame{
    JLabel FrameLabel;
    List<JButton> Answers;
    JButton Cancel_btn;
    static  JFrame ThisFrame;
    static int trueAns;

    public QuizFrame2(){
    }

    public QuizFrame2(String Slang, String Def, List<String> WrongAns, int type){
        Answers = new ArrayList<JButton>();
        Cancel_btn = new JButton("Cancel");
        Random generator = new Random();
        trueAns = generator.nextInt(4);
        if(type == 1) //Nếu người dùng đang chơi quiz by slang
        {
            FrameLabel = new JLabel("Slang: " + Slang);
            for(int i = 0, h = 0; i < 3; i++){
                JButton Ans;
                if(i == trueAns){
                    Ans = new JButton(Def);
                }
                else{
                    Ans = new JButton(WrongAns.get(h));
                    h++;
                }
                Answers.add(Ans);
            }
        }
        else if(type == 2) //Nếu người dùng đang chơi quiz by def
        {
            FrameLabel = new JLabel("Definition: " + Def);
            for(int i = 0, h = 0; i < 4; i++){
                JButton Ans;
                if(i == trueAns){
                    Ans = new JButton(Slang);
                }
                else{
                    Ans = new JButton(WrongAns.get(h));
                    h++;
                }
                Answers.add(Ans);
            }
        }

        EventHandler eventListener = new EventHandler();
        Cancel_btn.setActionCommand("Quiz2BackToMenuFrame");
        for(int i = 0; i < 4; i++){
            Answers.get(i).setActionCommand(String.valueOf(i));
        }

        Cancel_btn.addActionListener(eventListener);
        for(int i = 0; i < 4; i++){
            Answers.get(i).addActionListener(eventListener);
        }

        addComponentsToFrame(getContentPane());
    }

    public void addComponentsToFrame(Container container){
        container.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        headerPanel.add(FrameLabel);

        JPanel AnsPanel = new JPanel();
        AnsPanel.setLayout(new GridLayout(2,2));
        for(int i = 0; i < Answers.size(); i++){
            AnsPanel.add(Answers.get(i));
        }

        container.add(headerPanel, BorderLayout.PAGE_START);
        container.add(AnsPanel, BorderLayout.CENTER);
    }

    public static String getTrueAnswer(){
        return String.valueOf(trueAns);
    }

    public static void CreateAndShowMenuFrame(String Slang, String Def, List<String> WrongAns, int type){
        JFrame.setDefaultLookAndFeelDecorated(true);
        ThisFrame = new QuizFrame2(Slang, Def, WrongAns, type);
        ThisFrame.pack();
        ThisFrame.setVisible(true);
        ThisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void closeFrame(){
        ThisFrame.dispose();
    }
}

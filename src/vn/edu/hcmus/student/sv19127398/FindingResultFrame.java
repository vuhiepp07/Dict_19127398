package vn.edu.hcmus.student.sv19127398;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/24/2021 - 3:31 PM
 * Description: ...
 */
public class FindingResultFrame extends JFrame{
    String SearchKey;
    JLabel FrameLabel;
    ArrayList<String> Result;
    JButton Ok_btn;
    JList ResultList;
    JScrollPane scrollPane;
    int FindType;
    static JFrame ThisFrame;

    public FindingResultFrame(){}

    public FindingResultFrame(String key, int type){
        SearchKey = key;
        FindType = type;
        Ok_btn = new JButton("OK");
        Ok_btn.setActionCommand("ResultBackToMenuFrame");
        EventHandler eventListener = new EventHandler();
        Ok_btn.addActionListener(eventListener);

        if(FindType == 1){ // Nếu là tìm kiếm Definition bằng Slang word
            Result = Dictionary.findByWord(SearchKey);
            FrameLabel = new JLabel("Slang word: " + key);
            Result.add(0, "Definition: ");
        }
        else if(FindType == 2){ // Nếu là tìm kiếm Slang word bằng Definition
            Result = ReverseDictionary.findByWord(SearchKey);
            FrameLabel = new JLabel("Definition: " + key);
            Result.add(0, "Slang word: ");
        }
        String[] arr = new String[Result.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Result.get(i);
        }
        ResultList = new JList(arr);
        scrollPane = new JScrollPane(ResultList);
        addComponentsToFrame(getContentPane());
    }

    public void addComponentsToFrame(Container container){
        container.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        headerPanel.add(FrameLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0,20)));

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout());
        footerPanel.add(Ok_btn);

        container.add(headerPanel, BorderLayout.PAGE_START);
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(footerPanel, BorderLayout.PAGE_END);
    }

    public static void CreateAndShowFindingResultFrame(String SearchKey, int findType){
        JFrame.setDefaultLookAndFeelDecorated(true);
        ThisFrame = new FindingResultFrame(SearchKey, findType);
        ThisFrame.pack();
        ThisFrame.setVisible(true);
        ThisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void closeFrame(){
        ThisFrame.dispose();
    }
}

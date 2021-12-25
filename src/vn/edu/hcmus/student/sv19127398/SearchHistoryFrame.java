package vn.edu.hcmus.student.sv19127398;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/25/2021 - 5:28 PM
 * Description: ...
 */
public class SearchHistoryFrame extends JFrame {
    JLabel FrameLabel;
    ArrayList<String> Result;
    JButton Ok_btn;
    JButton DeleteHistory_btn;
    JList ResultList;
    JScrollPane scrollPane;
    static JFrame ThisFrame;

    public SearchHistoryFrame(){
        FrameLabel = new JLabel("HISTORY");
        Ok_btn = new JButton("OK");
        Ok_btn.setActionCommand("HistoryBackToMenuFrame");
        EventHandler eventListener = new EventHandler();
        Ok_btn.addActionListener(eventListener);
        DeleteHistory_btn = new JButton("Clear history");
        DeleteHistory_btn.setActionCommand("ClearHistory");
        DeleteHistory_btn.addActionListener(eventListener);

        Result = Dictionary.get_SearchHistory();
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
        footerPanel.add(DeleteHistory_btn);
        footerPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        footerPanel.add(Ok_btn);

        container.add(headerPanel, BorderLayout.PAGE_START);
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(footerPanel, BorderLayout.PAGE_END);
    }

    public static void CreateAndShowSearchHistoryFrame(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        ThisFrame = new SearchHistoryFrame();
        ThisFrame.pack();
        ThisFrame.setVisible(true);
        ThisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void closeFrame(){
        ThisFrame.dispose();
    }
}

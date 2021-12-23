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
    JLabel StudentInfo, Menu;
    JButton SearchByWord_btn, SearchByDef_btn, ViewSearchHistory_btn, AddNewSlang_btn,
            EditSlang_btn, DeleteSlang_btn, ResetDict_btn, RandomSlang_btn, Quiz_btn;
    Container container;

    public MenuFrame(){
        StudentInfo = new JLabel("19127398");
        Menu = new JLabel("Dictionary");
        SearchByWord_btn = new JButton("Search by word");
        SearchByDef_btn = new JButton("Search by definition");
        ViewSearchHistory_btn = new JButton("View search history");
        AddNewSlang_btn = new JButton("Add new slang word to dictionary");
        EditSlang_btn = new JButton("Edit a slang word");
        DeleteSlang_btn = new JButton("Delete a slang word");
        ResetDict_btn = new JButton("Reset dictionary data to default");
        RandomSlang_btn = new JButton("Random a slang word");
        Quiz_btn = new JButton("Play quiz game");
        container = getContentPane();
    }

    public void addComponents(){
        container.setLayout(new BorderLayout());
    }

}

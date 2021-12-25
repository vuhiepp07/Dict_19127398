package vn.edu.hcmus.student.sv19127398;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/24/2021 - 2:53 PM
 * Description: ...
 */
public class EventHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "SearchByWord" || e.getActionCommand() == "SearchByDefinition") {
            String SearchKey;
            if (e.getActionCommand() == "SearchByWord") {
                SearchKey = JOptionPane.showInputDialog(null, "Enter Slang word:",
                        "Search By Word",JOptionPane.QUESTION_MESSAGE);
                if (Dictionary.Check_SlangExist(SearchKey) == -1) {
                    JOptionPane.showMessageDialog(null, "Slang word you find doesn't exist",
                            "Search By Word",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    MenuFrame.closeFrame();
                    FindingResultFrame.CreateAndShowFindingResultFrame(SearchKey,1);
                }
            } else if (e.getActionCommand() == "SearchByDefinition") {
                SearchKey = JOptionPane.showInputDialog(null, "Enter Definition of a Slang word:",
                        "Search By Definition",JOptionPane.QUESTION_MESSAGE);
                if (Dictionary.Check_DefinitionExist(SearchKey) == -1) {
                    JOptionPane.showMessageDialog(null, "Definition you find doesn't exist",
                            "Search By Definition",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    MenuFrame.closeFrame();
                    FindingResultFrame.CreateAndShowFindingResultFrame(SearchKey,2);
                }
            }
        }
        else if(e.getActionCommand() == "ViewSearchHistory"){
            SearchHistoryFrame.CreateAndShowSearchHistoryFrame();
            MenuFrame.closeFrame();
        }
        else if(e.getActionCommand() == "ClearHistory"){
            Dictionary.Delete_SearchHistory();
            SearchHistoryFrame.closeFrame();
            SearchHistoryFrame.CreateAndShowSearchHistoryFrame();
        }
        else if(e.getActionCommand() == "AddNewSlang"){

        }
        else if(e.getActionCommand() == "EditSlang"){

        }
        else if(e.getActionCommand() == "DeleteSlang"){
            String Slang;
            Slang = JOptionPane.showInputDialog(null, "Enter Slang word you want to delete:",
                    "Delete Slang", JOptionPane.QUESTION_MESSAGE);
            if (Dictionary.Check_SlangExist(Slang) == -1) {
                JOptionPane.showMessageDialog(null, "Slang word you find doesn't exist",
                        "Delete Slang", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                int ConfirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "
                        + Slang + " ?", "Confirm delete Slang", JOptionPane.YES_NO_OPTION);
                if(ConfirmResult == JOptionPane.YES_OPTION) {
                    Dictionary.Delete(Slang);
                    JOptionPane.showMessageDialog(null, "Delete successful slang word " + Slang,
                            "Delete Slang", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else if(e.getActionCommand() == "ResetDictionary"){
            FileHandler.ReadDataFromFile("slang.txt");
            JOptionPane.showMessageDialog(null, "Dictionary has been reseted to default, " +
                    "all edited and deleted slang words have been recovered and Slang words which had been add by user have been deleted",
                    "Reset Dictionary", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getActionCommand() == "RandomSlang"){
            ArrayList<String> RandomResult = Dictionary.Random();
            StringBuilder DefinitionList = new StringBuilder();
            for(int i = 1; i < RandomResult.size(); i++){
                DefinitionList.append(RandomResult.get(i));
                if( i!= RandomResult.size()-1) {
                    DefinitionList.append(", ");
                }
            }
            JOptionPane.showMessageDialog(null, RandomResult.get(0) + ": "
                    + DefinitionList.toString(), "Random Slang", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getActionCommand() == "PlayQuiz"){
            QuizFrame1.CreateAndShowQuizFrame1();
            MenuFrame.closeFrame();
        }
        else if(e.getActionCommand() == "AboutStudent"){
        }
        else if(e.getActionCommand() == "ExitMenuFrame"){
            MenuFrame.closeFrame();
            FileHandler.WriteDown_SearchHisFile(Dictionary.get_SearchHistory(),"searchHistory.txt");
            FileHandler.WriteDictDataTo_EditedEdition_File("slangUserEditedEdition.txt");
            System.exit(0);
        }
        else if(e.getActionCommand() == "ResultBackToMenuFrame"){
            FindingResultFrame.closeFrame();
            MenuFrame.CreateAndShowMenuFrame();
        }
        else if(e.getActionCommand() == "HistoryBackToMenuFrame"){
            SearchHistoryFrame.closeFrame();
            MenuFrame.CreateAndShowMenuFrame();
        }
    }
}

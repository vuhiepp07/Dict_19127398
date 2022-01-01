package vn.edu.hcmus.student.sv19127398;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
            String Slang;
            Slang = JOptionPane.showInputDialog(null, "Enter Slang word you want to add:",
                    "Add new Slang", JOptionPane.QUESTION_MESSAGE);
            if(Dictionary.Check_SlangExist(Slang) == 1){

            }
            else{
                String numOfDef;
                numOfDef = JOptionPane.showInputDialog(null, "How many definition of this slang you want to input:",
                        "Add new Slang", JOptionPane.QUESTION_MESSAGE);
                int n = Integer.valueOf(numOfDef);
                ArrayList<String> Val = new ArrayList<String>();
                for(int i = 0; i < n; i++){
                    String temp = JOptionPane.showInputDialog(null, "Enter definition " + i + 1,
                            "Enter definition", JOptionPane.QUESTION_MESSAGE);
                    Val.add(temp);
                }
                Dictionary.add(Slang, Val);
            }
        }
        else if(e.getActionCommand() == "EditSlang"){
            String Slang;
            Slang = JOptionPane.showInputDialog(null, "Enter Slang word you want to edit:",
                    "Edit Slang", JOptionPane.QUESTION_MESSAGE);
            if(Dictionary.Check_SlangExist(Slang) == 1){
                int choice;
                UIManager.put("OptionPane.yesButtonText", "Keep the old definition and add new ones"); // https://stackoverflow.com/questions/14407804/how-to-change-the-default-text-of-buttons-in-joptionpane-showinputdialog
                UIManager.put("OptionPane.noButtonText", "Delete the old definition and add new ones");
                choice = JOptionPane.showConfirmDialog(null, "Choose edit type",
                        "Edit Slang", JOptionPane.OK_OPTION);
                UIManager.put("OptionPane.yesButtonText", "Yes");
                UIManager.put("OptionPane.noButtonText", "No");
                if(choice == JOptionPane.NO_OPTION){
                    Dictionary.Delete(Slang);
                }
                String numOfDef = JOptionPane.showInputDialog(null, "How many definition of this slang you want to append:",
                        "Add new Slang", JOptionPane.QUESTION_MESSAGE);
                int n = Integer.valueOf(numOfDef);
                ArrayList<String> Val = new ArrayList<String>();
                for(int i = 0; i < n; i++){
                    String temp = JOptionPane.showInputDialog(null, "Enter definition " + i + 1,
                            "Enter definition", JOptionPane.QUESTION_MESSAGE);
                    Val.add(temp);
                }
                Dictionary.add(Slang, Val);
            }
            else{
                JOptionPane.showMessageDialog(null, "Slang word you want to edit doesn't exist",
                        "Edit Slang", JOptionPane.INFORMATION_MESSAGE);
            }
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
        else if(e.getActionCommand() == "QuizBySlang"){
            int ConfirmResult = JOptionPane.showConfirmDialog(null, "Program will give you a Slang word and 4 Definition, " +
                    "your mission is to select the appropriate Definition that fit with the given Slang word, if you select the correct answer you win. " +
                    "Are you ready?", "Quiz By Slang Rules", JOptionPane.YES_NO_OPTION);
            if(ConfirmResult == JOptionPane.YES_OPTION) {
                ArrayList<String> quiz  = Dictionary.quiz_Slang();
                String Slang = quiz.get(0);
                String Def = quiz.get(1);
                ArrayList<String> WrongAnswer = new ArrayList<String>();
                for(int i = 2; i <quiz.size(); i++){
                    WrongAnswer.add(quiz.get(i));
                }
                QuizFrame2.CreateAndShowMenuFrame(Slang, Def, WrongAnswer, 2);
                QuizFrame1.closeFrame();
            }
        }
        else if(e.getActionCommand() == "QuizByDefinition"){
            int ConfirmResult = JOptionPane.showConfirmDialog(null, "Program will give you a Definition and 4 Slang words, " +
                    "your mission is to select the appropriate Slang word that fit with the given Definition, if you select the correct answer you win. " +
                    "Are you ready?", "Quiz By Slang Rules", JOptionPane.YES_NO_OPTION);
            if(ConfirmResult == JOptionPane.YES_OPTION) {
                ArrayList<String> quiz = Dictionary.quiz_Definition();
                String Slang = quiz.get(0);
                String Def = quiz.get(1);
                ArrayList<String> WrongAnswer = new ArrayList<String>();
                for(int i = 2; i <quiz.size(); i++){
                    WrongAnswer.add(quiz.get(i));
                }
                QuizFrame2.CreateAndShowMenuFrame(Slang, Def, WrongAnswer, 2);
                QuizFrame1.closeFrame();
            }
        }
        else if(e.getActionCommand().equals("0")){
            if(QuizFrame2.getTrueAnswer().equals("0")){
                JOptionPane.showMessageDialog(null, "Congratulation! You had chosen the right answer",
                        "Correct", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "You had chosen the wrong answer, good luck next time.",
                        "Incorrect", JOptionPane.INFORMATION_MESSAGE);
            }
            QuizFrame2.closeFrame();
            MenuFrame.CreateAndShowMenuFrame();
        }
        else if(e.getActionCommand().equals("1")){
            if(QuizFrame2.getTrueAnswer().equals("1")){
                JOptionPane.showMessageDialog(null, "Congratulation! You had chosen the right answer",
                        "Correct", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "You had chosen the wrong answer, good luck next time.",
                        "Incorrect", JOptionPane.INFORMATION_MESSAGE);
            }
            QuizFrame2.closeFrame();
            MenuFrame.CreateAndShowMenuFrame();
        }
        else if(e.getActionCommand().equals("2")){
            if(QuizFrame2.getTrueAnswer().equals("2")){
                JOptionPane.showMessageDialog(null, "Congratulation! You had chosen the right answer",
                        "Correct", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "You had chosen the wrong answer, good luck next time.",
                        "Incorrect", JOptionPane.INFORMATION_MESSAGE);
            }
            QuizFrame2.closeFrame();
            MenuFrame.CreateAndShowMenuFrame();
        }
        else if(e.getActionCommand().equals("3")){
            if(QuizFrame2.getTrueAnswer().equals("3")){
                JOptionPane.showMessageDialog(null, "Congratulation! You had chosen the right answer",
                        "Correct", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "You had chosen the wrong answer, good luck next time.",
                        "Incorrect", JOptionPane.INFORMATION_MESSAGE);
            }
            QuizFrame2.closeFrame();
            MenuFrame.CreateAndShowMenuFrame();
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
        else if(e.getActionCommand() == "Quiz1BackToMenuFrame"){
            QuizFrame1.closeFrame();
            MenuFrame.CreateAndShowMenuFrame();
        }
        else if(e.getActionCommand() == "Quiz2BackToMenuFrame"){
            QuizFrame2.closeFrame();
            MenuFrame.CreateAndShowMenuFrame();
        }
    }
}

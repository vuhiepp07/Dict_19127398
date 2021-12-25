package vn.edu.hcmus.student.sv19127398;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            JFrame temp = new JFrame();
            String SearchKey;
            if (e.getActionCommand() == "SearchByWord") {
                SearchKey = JOptionPane.showInputDialog(temp, "Enter Slang word:");
                if (Dictionary.Check_SlangExist(SearchKey) == -1) {
                    JOptionPane.showMessageDialog(temp, "Slang word you find doesn't exist");
                }
                else{
                    MenuFrame.closeFrame();
                    FindingResultFrame.CreateAndShowFindingResultFrame(SearchKey,1);
                }
            } else if (e.getActionCommand() == "SearchByDefinition") {
                SearchKey = JOptionPane.showInputDialog(temp, "Enter Definition of a Slang word:");
                if (Dictionary.Check_DefinitionExist(SearchKey) == -1) {
                    JOptionPane.showMessageDialog(temp, "Definition you find doesn't exist");
                }
                else{
                    MenuFrame.closeFrame();
                    FindingResultFrame.CreateAndShowFindingResultFrame(SearchKey,2);
                }
            }
        }
        else if(e.getActionCommand() == "ViewSearchHistory"){

        }
        else if(e.getActionCommand() == "AddNewSlang"){

        }
        else if(e.getActionCommand() == "EditSlang"){

        }
        else if(e.getActionCommand() == "DeleteSlang"){

        }
        else if(e.getActionCommand() == "ResetDictionary"){

        }
        else if(e.getActionCommand() == "RandomSlang"){

        }
        else if(e.getActionCommand() == "PlayQuiz"){

        }
        else if(e.getActionCommand() == "AboutStudent"){

        }
        else if(e.getActionCommand() == "ExitMenuFrame"){
            MenuFrame.closeFrame();
            System.exit(0);
        }
        else if(e.getActionCommand() == "ResultBackToMenuFrame"){
            FindingResultFrame.closeFrame();
            MenuFrame.CreateAndShowMenuFrame();
        }
    }
}

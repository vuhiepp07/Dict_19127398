package vn.edu.hcmus.student.sv19127398;

public class Main {

    public static void main(String[] args) {
        FileHandler.ReadDataFromFile("slangUserEditedEdition.txt");
        //FileHandler.ReadDataFromFile("slang.txt");
        MenuFrame.CreateAndShowMenuFrame();
        //Dictionary.viewDict();
    }
}

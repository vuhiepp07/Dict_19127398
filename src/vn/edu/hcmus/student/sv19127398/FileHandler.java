package vn.edu.hcmus.student.sv19127398;

import java.io.*;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/22/2021 - 8:50 AM
 * Description: ...
 */
public class FileHandler {
    public void SplitMeanings(){

    }

    public static int ReadDataFromFile(String filename){
        BufferedReader br = null;
        try{
            String DataLine;
            br = new BufferedReader(new FileReader(filename));
            while((DataLine = br.readLine()) != null){
                String[] splitData = DataLine.split("`");
                String Slang = splitData[0];
                if(splitData.length != 1){ // Tránh trường hợp chỉ có từ mà không có nghĩa
                    String[] meanings = splitData[1].split("\\|"); //https://stackoverflow.com/questions/8996842/errors-with-string-split
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        return 1;
    }
}

package vn.edu.hcmus.student.sv19127398;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/22/2021 - 8:50 AM
 * Description: ...
 */
public class FileHandler {
    public static void WriteDown_SearchHisFile(ArrayList<String> SearchHistory, String filename){
        FileWriter fw;
        try
        {
            fw = new FileWriter(filename);
            for(int i = 0; i < SearchHistory.size(); i++){
                fw.write(SearchHistory.get(i));
                fw.write(";");
            }
            fw.flush();
            fw.close();
        }
        catch(IOException exc){
            System.out.println("Error opening file");
        }
    }

    public static void Read_SearchHisFile(String filename){
        ArrayList<String> result = new ArrayList<String>();
        BufferedReader br = null;
        try{
            String DataLine;
            br = new BufferedReader(new FileReader(filename));
            while((DataLine = br.readLine()) != null){
                String[] splitData = DataLine.split(";");
                for(int i = 0; i < splitData.length; i++){
                    result.add(splitData[i]);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        Dictionary.update_SearchHis(result);
    }

    /*    Lưu thông tin từ điển sau khi người dùng thao tác chỉnh sửa trên từ điển vào 1 file txt riêng,
    hệ thống sẽ tự động đọc file này khi khởi độngcho đến khi người dùng chọn chức năng reset từ điển thì khi đó
    hệ thống mới đọc file từ điển gốc và lưu vào Cấu trúc dữ liệu Dictionary */
    public static void WriteDictDataTo_EditedEdition_File(String filename){
        HashMap<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
        dict.putAll(Dictionary.getDictionaryData());
        FileWriter fw;
        try
        {
            fw = new FileWriter(filename);
            Iterator<HashMap.Entry<String, ArrayList<String>>> iterator = dict.entrySet().iterator();
            while (iterator.hasNext()) {
                HashMap.Entry me = (HashMap.Entry)iterator.next();
                String Key = (String) me.getKey();
                ArrayList<String> Val = (ArrayList<String>) me.getValue();
                fw.write(Key);
                fw.write("`");
                for(int i = 0; i < Val.size(); i++) {
                    fw.write(Val.get(i));
                    fw.write("|");
                }
            }
            fw.flush();
            fw.close();
        }
        catch(IOException exc){
            System.out.println("Error opening file");
        }
    }

    public static int ReadDataFromFile(String filename){
        BufferedReader br = null;
        try{
            String DataLine;
            br = new BufferedReader(new FileReader(filename));
            while((DataLine = br.readLine()) != null){
                String[] splitData = DataLine.split("`");
                String[] temp_arr ={};
                ArrayList<String> meanings = new ArrayList<String>();
                String Slang = splitData[0];
                if(splitData.length != 1){ // Tránh trường hợp chỉ có từ mà không có nghĩa
                    temp_arr = splitData[1].split("\\|"); //https://stackoverflow.com/questions/8996842/errors-with-string-split
                }
                for(int i = 0; i < temp_arr.length; i++){
                    meanings.add(temp_arr[i]);
                }
                Dictionary.add(Slang, meanings);
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
        Read_SearchHisFile("searchHistory.txt");
        return 1;
    }
}

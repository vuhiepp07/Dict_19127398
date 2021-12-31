package vn.edu.hcmus.student.sv19127398;

import java.util.*;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/22/2021 - 10:19 AM
 * Description: ...
 */
public class Dictionary {
    static HashMap<String, ArrayList<String>> Dict = new HashMap<>();
    static ArrayList<String> Searching_History = new ArrayList<>();
    static int ResultQuizGame = -1;

    public static HashMap<String, ArrayList<String>> getDictionaryData(){
        return Dict;
    }

    public static ArrayList<String> get_SearchHistory(){
        return Searching_History;
    }

    public static void Delete_SearchHistory(){
        Searching_History.clear();
    }

    public static void searchHis_Handle(String Key){
        if(Searching_History.size() == 20) Searching_History.remove(0); // Giới hạn lịch sử tìm kiếm chỉ lưu 20 từ
        Searching_History.add(Key);
        FileHandler.WriteDown_SearchHisFile(Searching_History, "searchHistory.txt");
    }

    public static void update_SearchHis(ArrayList<String> history){
        Searching_History = history;
    }

    public static void add(String Key, ArrayList<String> Val){
        if(Dict.containsKey(Key)){
            ArrayList<String> Val_Temp = Dict.get(Key);
            for(int i = 0; i < Val_Temp.size(); i++){
                Val.add(Val_Temp.get(i));
            }
        }
        Dict.put(Key, Val);
    }

    public static void viewDict() {
        System.out.println(Dict.size());
        Iterator<HashMap.Entry<String, ArrayList<String>>> iterator = Dict.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry me = (HashMap.Entry)iterator.next();
            String Key = (String) me.getKey();
            ArrayList<String> Val = (ArrayList<String>) me.getValue();
            System.out.print(Key + ": " );
            for(int i = 0; i < Val.size(); i++){
                System.out.print(Val.get(i) + ",");
            }
            System.out.println();
        }
    }

    public static int Check_SlangExist(String Key){
        if(Dict.containsKey(Key) == true) return 1;
        return -1;
    }

    public static int Check_DefinitionExist(String Value){
        //if(Dict.containsValue(Value) == true) return 1;
        Iterator<HashMap.Entry<String, ArrayList<String>>> iterator = Dict.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry me = (HashMap.Entry) iterator.next();
            ArrayList<String> Val = (ArrayList<String>) me.getValue();
            for(int i = 0; i < Val.size(); i++){
                String temp = Val.get(i);
                temp = temp.substring(1, temp.length());
                if(Val.get(i).equals(Value) || temp.equals(Value)) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public static ArrayList<String> findByWord(String Key){
        searchHis_Handle(Key);
        ArrayList<String> Val = new ArrayList<String>();
        Val = Dict.get(Key);
        return Val;
    }

    public static ArrayList<String> findByDefinition(String Value){
        ArrayList<String> Result = new ArrayList<String>();
        Iterator<HashMap.Entry<String, ArrayList<String>>> iterator = Dict.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry me = (HashMap.Entry) iterator.next();
            String Key = (String) me.getKey();
            ArrayList<String> Val = (ArrayList<String>) me.getValue();
            for (int i = 0; i < Val.size(); i++) {
                String temp = Val.get(i);
                temp = temp.substring(1, temp.length());
                if(Val.get(i).equals(Value) || temp.equals(Value)) {
                    Result.add(Key);
                }
            }
        }
        return Result;
    }

    public static void Edit(String Key, ArrayList<String> Val){
        Dict.replace(Key,Val);
    }

    public static void Delete(String Key){
        Dict.remove(Key);
    }

    public static void Reset(){
        Dict.clear();
        FileHandler.ReadDataFromFile("slang.txt");
    }

    public static ArrayList<String> Random(){
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> Keys = new ArrayList<String>(Dict.keySet());
        int randIndex = new Random().nextInt(Keys.size());
        String key = Keys.get(randIndex);
        result.add(key);
        ArrayList<String> value = Dict.get(key);
        for(int i = 0; i < value.size(); i++){
            result.add(value.get(i));
        }
        return result;
    }

    public static ArrayList<String> quiz_Slang(){ //Đố vui, đưa ra một slang word và 4 definition để người dùng chọn
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> Keys = new ArrayList<String>(Dict.keySet());
        int randIndexKey = new Random().nextInt(Keys.size());
        String key = Keys.get(randIndexKey);
        ArrayList<String> value = Dict.get(key);
        result.add(key);
        result.add(value.get(0));
        int cnt = 0;
        while(cnt<3){
            int random_def = new Random().nextInt(Keys.size());
            if(random_def != randIndexKey){
                String key_temp = Keys.get(random_def);
                result.add((Dict.get(key_temp)).get(0));
                cnt++;
            }
        }
        return result;
    }

    public static ArrayList<String> quiz_Definition(){ //Đố vui, đưa ra một definition và 4 slang word để người dùng chọn
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> Keys = new ArrayList<String>(Dict.keySet());
        int randIndexKey = new Random().nextInt(Dict.keySet().size());
        String key = Keys.get(randIndexKey);
        ArrayList<String> value = Dict.get(key);
        result.add(key);
        result.add(value.get(0));
        int cnt = 0;
        while(cnt<3){
            int random_def = new Random().nextInt(Keys.size());
            if(random_def != randIndexKey){
                String key_temp = Keys.get(random_def);
                result.add(key_temp);
                cnt++;
            }
        }
        return result;
    }

    public static void SetResultQuizGame(int result){
        ResultQuizGame = result;
    }

    public static int GetResultQuizGame(){
        return ResultQuizGame;
    }
}

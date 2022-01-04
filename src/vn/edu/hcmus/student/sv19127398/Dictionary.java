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

    /**
     * Get data of the dictionary
     * @return Dict HashMap<String, ArrayList<String>>
     */
    public static HashMap<String, ArrayList<String>> getDictionaryData(){
        return Dict;
    }

    /**
     * Get data of the searching history
     * @return Searching_History ArrayList<String>
     */
    public static ArrayList<String> get_SearchHistory(){
        return Searching_History;
    }

    /**
     * Delete the searching history
     */
    public static void Delete_SearchHistory(){
        Searching_History.clear();
    }

    /**
     * Add a new Slang in to searching history after user searched it
     * @param Key String
     */
    public static void searchHis_Handle(String Key){
        if(Searching_History.size() == 20) Searching_History.remove(0); // Giới hạn lịch sử tìm kiếm chỉ lưu 20 từ
        Searching_History.add(Key);
        FileHandler.WriteDown_SearchHisFile(Searching_History, "searchHistory.txt");
    }

    /**
     * Update Searching history
     * @param history ArrayList<String>
     */
    public static void update_SearchHis(ArrayList<String> history){
        Searching_History = history;
    }

    /**
     * Add new Slang with definition to Dictionary
     * @param Key String
     * @param Val ArrayList<String>
     */
    public static void add(String Key, ArrayList<String> Val){
        if(Dict.containsKey(Key)){
            ArrayList<String> Val_Temp = Dict.get(Key);
            for(int i = 0; i < Val_Temp.size(); i++){
                Val.add(Val_Temp.get(i));
            }
        }
        Dict.put(Key, Val);
    }

    /**
     * View all the Slang word and definition in Dictionary
     */
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

    /**
     * Check if a Slang word is exist in the dictionary or not
     * @param Key String
     * @return -1(not exist) or 1(exist) int
     */
    public static int Check_SlangExist(String Key){
        if(Dict.containsKey(Key) == true) return 1;
        return -1;
    }

    /**
     * Check if a definition is exist in the dictionary or not
     * @param Value String
     * @return -1(not exist) or 1(exist) int
     */
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

    /**
     * Get definitions of a Slang word
     * @param Key String
     * @return Val ArrayList<String>
     */
    public static ArrayList<String> getValueFromKey(String Key){
        ArrayList<String> Val = new ArrayList<String>();
        Val = Dict.get(Key);
        return Val;
    }

    /**
     * Get definitions of a Slang word and add that Slang word into searching history
     * @param Key String
     * @return Val ArrayList<String<>
     */
    public static ArrayList<String> findByWord(String Key){
        searchHis_Handle(Key);
        ArrayList<String> Val = new ArrayList<String>();
        Val = Dict.get(Key);
        return Val;
    }

    /**
     * Get Slang word of a definition in the dictionary
     * @param Value String
     * @return Result ArrayList<String>
     */
    public static ArrayList<String> findByDefinition(String Value){
        ArrayList<String> Result = new ArrayList<String>();
        Iterator<HashMap.Entry<String, ArrayList<String>>> iterator = Dict.entrySet().iterator();
        while (iterator.hasNext()) { //iterate along the hash map
            HashMap.Entry me = (HashMap.Entry) iterator.next();
            String Key = (String) me.getKey();
            ArrayList<String> Val = (ArrayList<String>) me.getValue();
            for (int i = 0; i < Val.size(); i++) {
                String temp = Val.get(i);
                temp = temp.substring(1, temp.length());
                if(Val.get(i).equals(Value) || temp.equals(Value)) {
                    Result.add(Key);
                    break;
                }
            }
        }
        return Result;
    }

    /**
     * Delete a Slang word and its definitions in the dictionary
     * @param Key String
     */
    public static void Delete(String Key){
        Dict.remove(Key);
    }

    /**
     * Reset the dictionary to default with the resource data file 'slang.txt'
     */
    public static void Reset(){
        Dict.clear();
        FileHandler.ReadDataFromFile("slang.txt");
    }

    /**
     * Get a random Slang word with it definitions
     * @return result ArrayList<String>
     */
    public static ArrayList<String> Random(){
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> Keys = new ArrayList<String>(Dict.keySet());
        int randIndex = new Random().nextInt(Keys.size());
        String key = Keys.get(randIndex); // get a random Slang word
        result.add(key);
        ArrayList<String> value = Dict.get(key); // get the definitions due to the random Slang word
        for(int i = 0; i < value.size(); i++){
            result.add(value.get(i));
        }
        return result;
    }

    /**
     * Get a Slang with its definitions and then random 3 more definitions to support the quiz by Slang game
     * @return result ArrayList<String>
     */
    public static ArrayList<String> quiz_Slang(){
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> Keys = new ArrayList<String>(Dict.keySet());
        int randIndexKey = new Random().nextInt(Keys.size());
        String key = Keys.get(randIndexKey); // get a random Slang word
        ArrayList<String> value = Dict.get(key); // get the definition due to the random Slang
        result.add(key);
        result.add(value.get(0));
        int cnt = 0;
        while(cnt<3){ // get 3 more random definitions
            int random_def = new Random().nextInt(Keys.size());
            if(random_def != randIndexKey){
                String key_temp = Keys.get(random_def);
                result.add((Dict.get(key_temp)).get(0));
                cnt++;
            }
        }
        return result;
    }

    /**
     * Get a definition with its Slang and then random 3 more Slang words to support the quiz by Definition game
     * @return result ArrayList<String>
     */
    public static ArrayList<String> quiz_Definition(){
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> Keys = new ArrayList<String>(Dict.keySet());
        int randIndexKey = new Random().nextInt(Dict.keySet().size());
        String key = Keys.get(randIndexKey); //get A random Slang word
        ArrayList<String> value = Dict.get(key); // get the definition due to the random key
        result.add(key);
        result.add(value.get(0));
        int cnt = 0;
        while(cnt<3){ // get 3 more random Slang word
            int random_def = new Random().nextInt(Keys.size());
            if(random_def != randIndexKey){
                String key_temp = Keys.get(random_def);
                result.add(key_temp);
                cnt++;
            }
        }
        return result;
    }
}

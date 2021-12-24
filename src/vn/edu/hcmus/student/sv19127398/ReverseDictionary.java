package vn.edu.hcmus.student.sv19127398;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/24/2021 - 5:43 PM
 * Description: ...
 */
public class ReverseDictionary{
    static HashMap<String, ArrayList<String>> Dict = new HashMap<>();

    public static void add(String Key, ArrayList<String> Val){
        if(Dict.containsKey(Key)){
            ArrayList<String> Val_Temp = Dict.get(Key);
            for(int i = 0; i < Val_Temp.size(); i++){
                Val.add(Val_Temp.get(i));
            }
        }
        Dict.put(Key, Val);
    }

    public static int Check_SlangExist(String Key){
        if(Dict.containsKey(Key) == true) return 1;
        return -1;
    }

    public static ArrayList<String> findByWord(String Key){
        ArrayList<String> Val = new ArrayList<String>();
        Val = Dict.get(Key);
        return Val;
    }
}

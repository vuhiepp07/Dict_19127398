package vn.edu.hcmus.student.sv19127398;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * vn.edu.hcmus.student.sv19127398
 * Created by VuHiep
 * Date 12/22/2021 - 10:19 AM
 * Description: ...
 */
public class Dictionary {
    static HashMap<String, ArrayList<String>> Dict = new HashMap<>();

    static void add(String Key, ArrayList<String> Val){
        if(Dict.containsKey(Key)){
            ArrayList<String> Val_Temp = Dict.get(Key);
            for(int i = 0; i < Val_Temp.size(); i++){
                Val.add(Val_Temp.get(i));
            }
        }
        Dict.put(Key, Val);
    }

    static void viewDict() {
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
}

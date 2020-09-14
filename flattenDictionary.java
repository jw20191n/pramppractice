
import java.io.*;
import java.util.*;

public class Solution {

    public static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        HashMap<String, String> result = new HashMap<>();
        recursive("", dict, result);
        return result;
    }

    public static void recursive(String key, HashMap<String, Object> dict, HashMap<String, String> result){
        //iterate through the input 'dict'
        //if the value of current element is type string, then just add it to the result hashmap
        //otherwise keep iterate
        for(Map.Entry element : dict.entrySet()){
            String currKey = (String)element.getKey();

            //check whether the type of value is string or object
            if(element.getValue() instanceof String){
                //if the sent in key is null or "", means we are at the very out loop
                //else we append "." to the key sent in from last level and then append current key
                if(key == null || key.equals("")){
                    result.put(currKey, (String)element.getValue());
                }else{
                    result.put(key + "." + currKey, (String)element.getValue());
                }
            }else{
                if(key == null || key.equals("")){
                    recursive(currKey, (HashMap<String, Object>) element.getValue(), result);
                }else{
                    recursive(key + "." + currKey, (HashMap<String, Object>) element.getValue(), result);
                }
            }

        }
    }


    public static void main(String[] args) {
        // write your code here
        HashMap<String, Object> dict = new HashMap<>();
        dict.put("Key1", "1");
        HashMap<String, Object> inner = new HashMap<>();
        inner.put("a", "1");
        inner.put("b", "2");
        dict.put("Key2", inner);
        HashMap<String, String> result = flattenDictionary(dict);

        for(Map.Entry element : result.entrySet()){
            System.out.println(element.getKey() + " : " + element.getValue());
        }
    }
}

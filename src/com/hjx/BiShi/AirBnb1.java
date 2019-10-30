package com.hjx.BiShi;
import java.io.*;
import java.util.*;

class MyComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.charAt(0) - o2.charAt(0);
    }
}
public class AirBnb1 {

    public static List<String> costsOfNodes(List<String> lines) {
        List<String> res = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String s : lines){
            String[] arr = s.split(",");
            int defau = map.getOrDefault(arr[0], 1);
            for(int i = 1; i < arr.length; i ++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i], map.get(arr[i] + 1));
                }
                else{
                    map.put(arr[i], defau + 1);
                }

            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            res.add(entry.getKey() + "," + entry.getValue());
        }
        MyComparator myComparator = new MyComparator();
        Collections.sort(res, myComparator);

        return res;
    }

}

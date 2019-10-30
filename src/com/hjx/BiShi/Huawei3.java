package com.hjx.BiShi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Huawei3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<String, String>();
        for(int i = 0; i < n; i ++){
            String[] s = br.readLine().split(",");
            map.put(s[0]+"," + s[1], s[2]);
        }
        int m = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < m; i ++){
            String [] s1 = br.readLine().split(",");
            list.add(s1[2] + "," + s1[3] + "," + map.get(s1[0] +"," + s1[1]));
            map.remove(s1[0] + "," + s1[1]);
        }
        for(String s :map.keySet()){
            if(!list.contains(s)){
                list.add(s + "," + map.get(s));
            }
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i ++){
            if(i >= 1 && list.get(i).equals( list.get(i - 1))) continue;
            System.out.println(list.get(i));
        }
    }
}

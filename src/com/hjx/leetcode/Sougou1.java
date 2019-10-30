package com.hjx.leetcode;
import javafx.util.Pair;

import java.util.*;

public class Sougou1 {
    private int currentSize;
    private int size;
    List<String[]> list;

    public Sougou1(int size){
        this.currentSize = 0;
        this.size = size;
        list = new ArrayList<String[]>();
    }

    public void insert(String key, Long value){
        for(int i = 0; i < currentSize; i ++){
            if(list.get(i)[0].equals(key) && Long.valueOf(list.get(i)[1]) < value){
                list.remove(i);
                list.add(new String[]{key, String.valueOf(value)});
            }
        }
        if(currentSize == size){
            String[] old = list.remove(0);
            list.add(new String[]{key, String.valueOf(value)});
            System.out.println(old[0] + " " + old[1]);
        }

        list.add(new String[]{key, String.valueOf(value)});
        currentSize ++;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        Sougou1 sougou = new Sougou1(n);
        sc.next();
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            String key = s[0];
            Long value = Long.valueOf(s[1]);
            sougou.insert(key, value);
        }

    }
}

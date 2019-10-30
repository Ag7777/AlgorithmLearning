package com.hjx.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pinduoduo1 {
    public static void main(String args[]){
        int n = 5;
        int s = 100;
        ArrayList<ArrayList<Integer>> result = test3(n, s);
        for(ArrayList<Integer> list: result){
            for(int i = 0; i < list.size(); i ++) {
                System.out.print(list.get(i) + ",");
            }
            System.out.println();
        }
    }

    //n > 1, s < 100000
    public static ArrayList<ArrayList<Integer>> test3(int n, int s){
        if(s < ((1 + n) * n)/2) return new ArrayList();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 1; i <= n - 1; i ++){
            temp.add(i);
        }
        temp.add(s - ((n - 1) * n)/2);
        result.add(new ArrayList<Integer>(temp));
        help(n, s, result, temp, n - 1);
        return result;
    }

    public static void help(int n, int s, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int index){
        if(index <= 0 || index >= n) return;
        while(temp.get(index) - temp.get(index - 1) > 2){
            temp.set(index, temp.get(index) - 1);
            temp.set(index - 1, temp.get(index - 1) + 1);
            result.add(new ArrayList<Integer>(temp));
            help(n, s, result, temp, index + 1);
        }
        help(n, s, result, temp, index - 1);
    }
}

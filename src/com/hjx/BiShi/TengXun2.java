package com.hjx.BiShi;

import java.util.*;

public class TengXun2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i < n; i ++){
            int m = sc.nextInt();
            int number = sc.nextInt();
            for(int j = 0; j < m; j ++){
                array.add(number);
            }
        }
        Collections.sort(array);
        int max = 0;
        for(int i = 0; i < array.size()/2; i ++){
            max = Math.max(max, array.get(i) + array.get(array.size() - 1 - i));
        }
        System.out.println(max);
    }
}

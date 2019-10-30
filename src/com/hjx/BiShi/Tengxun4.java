package com.hjx.BiShi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Tengxun4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> array = new ArrayList<Integer>(n);
        for(int i = 0; i < n ; i++){
            array.add(sc.nextInt());
        }
        Collections.sort(array);
        for(int i = n - 1; i > 0; i --){
            array.set(i, array.get(i) - array.get(i - 1));
        }
        int i = 0;
        while(k > 0 && i < n){
            if(array.get(i) > 0){
                System.out.println(array.get(i));
                k --;
                i ++;
            }
            else{
                i ++;
            }
        }
        while(k > 0){
            System.out.println(0);
            k --;
        }
    }


}

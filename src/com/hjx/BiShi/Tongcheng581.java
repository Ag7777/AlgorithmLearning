package com.hjx.BiShi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tongcheng581 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        Set<String> set = new HashSet<String>();

        for(int i = 0; i < s.length; i ++){
            set.add(s[i]);
        }
        System.out.println(set.size());



    }
}

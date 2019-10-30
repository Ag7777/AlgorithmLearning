package com.hjx.leetcode;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Aiqiyi3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for(int i = 1; i <= s.length(); i++){
            Set<String> set = new HashSet<String>();
            for(int j = 0; j < s.length() - i; j ++){
                set.add(s.substring(j, j + i));
            }
            if(set.size() < Math.pow(4, i)){
                System.out.println("i");
                break;
            }
        }
    }
}

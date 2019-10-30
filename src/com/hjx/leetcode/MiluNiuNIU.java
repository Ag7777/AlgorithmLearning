package com.hjx.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class MiluNiuNIU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String direction = br.readLine();
        System.out.println(findDirection(direction));

    }

    public static char findDirection(String direction){
        char[] directions = new char[]{'N', 'E', 'S', 'W'};
        int index = 0;
        for(int i = 0; i < direction.length(); i ++){
            if(direction.charAt(i) == 'R'){
                index = (index + 1)%4;
            }
            else if(direction.charAt(i) == 'L'){
                index = (index + 3)%4;
            }
        }
        return directions[index];
    }
}

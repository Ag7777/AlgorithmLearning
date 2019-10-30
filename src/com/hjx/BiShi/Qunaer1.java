package com.hjx.BiShi;

public class Qunaer1 {
    public static void main(String[] args){
        int count = 0;
        for(int i = 1; i <= 10000; i ++){
            if(i % 3 == 0){
                count ++;
            }
            else if(i % 7 == 0 && i % 3 != 0){
                count ++;
            }
            else if(i % 11 == 0 && (i % 3 != 0 && i % 7 != 0)){
                count ++;
            }
        }
        System.out.println(10000 - count);
    }
}

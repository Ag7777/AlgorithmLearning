package com.hjx.BiShi;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class Huawei1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int indexA = 0, indexB = 0, indexR = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == 'A'){
                indexA = i;
            }
            else if(s.charAt(i) == 'B'){
                indexB = i;
            }
            else if(s.charAt(i) == 'R'){
                indexR = i
;            }
        }
        String[] strA = s.substring(indexA + 3, indexB - 2).split(",");
        String[] strB = s.substring(indexB + 3, indexR - 2).split(",");
        int R = Integer.valueOf(s.substring(indexR + 2));
        int[] A = new int[strA.length];
        int[] B = new int[strB.length];
        for(int i = 0; i < strA.length; i ++){
            A[i] = Integer.valueOf(strA[i]);
        }
        for(int i = 0; i < strB.length; i ++){
            B[i] = Integer.valueOf(strB[i]);
        }
        solution(A, B, R);
    }

    public static void solution(int[] A, int[] B, int R){
        int i =0;
        int j = 0;
        while(i < A.length  && j < B.length){
            if(A[i] > B[j]){
                j ++;
                continue;
            }
            else if(B[j] - A[i] <= R){
                System.out.printf("(" + A[i] + "," + B[j] + ")");
                j++;
            }
            else if(B[j] - A[i] > R && B[j - 1] - A[i] <= R){
                i ++;
            }
            else {
                System.out.printf("(" + A[i] + "," + B[j] + ")");
                i++;
            }
        }
    }
}


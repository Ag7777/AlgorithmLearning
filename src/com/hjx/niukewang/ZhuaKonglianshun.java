package com.hjx.niukewang;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
* 1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
*
* 输入：第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）

* 输出：一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
* * */
public class ZhuaKonglianshun {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        String[] lo = str.split(" ");
        int[] location = new int[lo.length];
        for(int i = 0; i < lo.length; i ++){
            location[i] = Integer.parseInt(lo[i]);

        }
        System.out.println(getLocation1(location, n, d));

    }

    public static int getLocation(int[] location, int n, int d){
        if(n < 3) return 0;
        int count = 0;
        for(int i = 0; i < n - 2; i ++){
            for(int j = i + 1; j < n - 1; j ++){
                if(location[j] - location[i] <= d){
                    for(int k = j + 1; k < n; k ++){
                        if(location[k] - location[i] <= d){
                            count ++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static int getLocation1(int[] location, int n, int d){
        if(n < 3) return 0;
        int count = 0;
        for(int i = 0; i < n - 2; i ++){
            for(int j = i + 2; j < n; j ++){
                if(location[j] - location[i] <= d){
                    count += (j - i - 1);
                }
            }
        }
        return count;
    }


}

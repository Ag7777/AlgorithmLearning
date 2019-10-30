package com.hjx.niukewang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
*1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
*
* 输入描述：第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。后面跟随N行，每行为一个待校验的字符串。
* 输出描述：N行，每行包括一个被修复后的字符串。
* */
public class CongmingBianji {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(new InputStreamReader(System.in));
//        int n = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i ++){
            String str = br.readLine();
            System.out.println(recover(str));
        }
    }

    public static String recover(String str){
        if(str.length() <= 2) return str;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length() - 1;){
            if(str.charAt(i) != str.charAt(i + 1)){
                sb.append(str.charAt(i));
                i ++;
                continue;
            }
            else{
                if(i >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)){
                    sb.append(str.charAt(i));
                }
                else {
                    sb.append(str.substring(i, i + 2));
                }
                int j;
                for(j = i + 2;j < str.length(); j ++){
                    if(str.charAt(i) != str.charAt(j)){
                        break;
                    }
                }
                i = i + (j - i);
            }
        }
        if(str.charAt(str.length() - 1) != str.charAt(str.length() - 2)){
            sb.append(str.charAt(str.length() - 1));
        }
        return sb.toString();
    }
}

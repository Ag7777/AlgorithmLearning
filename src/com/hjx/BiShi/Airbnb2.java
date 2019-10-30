package com.hjx.BiShi;

public class Airbnb2 {
    public static String divide(int dividend, int divisor) {
        // Write your code here
        String result = "";
        int part1 = dividend / divisor;
        result += part1;
        int part2 = dividend % divisor;
        if(part2 == 0) return result;
        else{
            result += ".";
            if(part2 * 10 % divisor == 0){
                return result + part2 * 10 / divisor;
            }
            String tmp = "";
            for(int i = 0; i < 1000; i ++){
                tmp += part2 * 10 / divisor;
                part2 = part2 * 10 % divisor;
            }
            int start = 0;
            int end = 0;

        }

        return result;

    }
}

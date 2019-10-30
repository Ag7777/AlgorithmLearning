package com.hjx.leetcodeStart;

/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
 */

import java.util.List;
import java.util.ArrayList;

public class Leetcode241 {
    public static void main(String[] args){
        String input = "2*3-4*5";
        List<Integer> res = diffWaysToCompute(input);
        for(int num : res){
            System.out.println(num);
        }
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if(input == null) return res;

        for(int i = 0; i < input.length(); i ++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(int j = 0; j < left.size(); j ++){
                    for(int k = 0; k < right.size(); k ++){
                        switch(input.charAt(i)){
                            case '+' : res.add(left.get(j) + right.get(k)); break;
                            case '-' : res.add(left.get(j) - right.get(k)); break;
                            case '*' : res.add(left.get(j) * right.get(k));
                        }
                    }
                }
                if(left.size() == 0 || right.size() == 0){
                    if(left.size() == 0) {
                        for(int num : right){
                            res.add(num);
                        }
                    }
                    else{
                        for(int num: left){
                            res.add(num);
                        }
                    }
                }
            }
        }
        if(res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}

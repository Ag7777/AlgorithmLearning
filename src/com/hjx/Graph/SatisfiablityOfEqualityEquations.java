package com.hjx.Graph;

/*
Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.



Example 1:

Input: ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
Example 2:

Input: ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 */

import java.util.Map;
import java.util.HashMap;

public class SatisfiablityOfEqualityEquations {
    public static void main(String[] args){
        String[] equations = new String[]{"a==c", "c!=d", "d==a"};
        System.out.println(equationsPossible(equations));
    }

    //union find
    public static boolean equationsPossible(String[] equations) {
        Map<Character, Character> parent = new HashMap<Character, Character>();
        for(String e : equations){
            Character x = e.charAt(0);
            Character y = e.charAt(3);
            Character eq = e.charAt(1);
            if(eq == '='){
                union(x, y , parent);
            }
        }

        for(String e : equations){
            Character x = e.charAt(0);
            Character y = e.charAt(3);
            Character eq = e.charAt(1);
            if(eq == '!'){
                if(find(x, parent) == find(y, parent)) return false;
            }
        }
        return true;
    }

    public static Character find(Character x, Map<Character, Character> parent){
        if(!parent.containsKey(x)){
            parent.put(x, x);
            return x;
        }
        else{
            if(parent.get(x) == x)
                return x;
            else {
                parent.put(x, find(parent.get(x), parent));
                return parent.get(x);
            }
        }
    }

    public static void union(Character x, Character y, Map<Character, Character> parent){
        Character rootx = find(x, parent);
        Character rooty = find(y, parent);
        if(rootx == rooty) return;
        parent.put(rootx, rooty);

    }
}

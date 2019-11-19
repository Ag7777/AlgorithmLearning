package com.hjx.String;
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class FindAllAnagramsInString {
    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagramsBruforce(String s, String p) {
        if(s == null || s.length() < p.length()) return new ArrayList<>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < p.length(); i ++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i <= s.length() - p.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                Map<Character, Integer> tmp = new HashMap<>(map);
                int j = i;
                for(j = i; j < i + p.length(); j ++){
                    if(tmp.containsKey(s.charAt(j)) && tmp.get(s.charAt(j)) > 0){
                        tmp.put(s.charAt(j), tmp.get(s.charAt(j)) - 1);
                    }
                    else if(!tmp.containsKey(s.charAt(j))){
                        i = j;
                        break;
                    }
                    else{
                        break;
                    }
                }
                if(j == i + p.length()) res.add(i);

            }

        }
        return res;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() < p.length()) return res;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < p.length(); i ++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int count = 0;
        int l = 0, r = 0;
        while(r < s.length()){
            char tmp = s.charAt(r);
            map.put(tmp, map.getOrDefault(tmp, 0) - 1);
            if(map.get(tmp) >= 0){
                count ++;
            }
            r++;
            if(count == p.length()){
                res.add(l);
            }
            if(r - l == p.length()){
                if(map.get(s.charAt(l)) >= 0) count --;
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                l ++;
            }
        }
        return res;
    }
}

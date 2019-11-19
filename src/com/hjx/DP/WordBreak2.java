package com.hjx.DP;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {
    //DFS TLE
    public List<String> wordBreakDFS(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        DFS(s, wordDict, 0, 0, new ArrayList<String>(), res);
        return res;
    }

    public void DFS(String s, List<String> wordDict, int start, int end, List<String> cur, List<String> res){
        if(start == s.length()){
            String tmp = cur.get(0);
            for(int i = 1; i < cur.size(); i ++){
                tmp = tmp + " " + cur.get(i);
            }
            res.add(tmp);
            return;
        }
        for(int i = end; i < s.length(); i ++){
            if(wordDict.contains(s.substring(start, i + 1))){
                cur.add(s.substring(start, i + 1));
                DFS(s, wordDict, i + 1, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

//    //DP
//    public List<String> wordBreak(String s, List<String> wordDict) {
//
//    }
}

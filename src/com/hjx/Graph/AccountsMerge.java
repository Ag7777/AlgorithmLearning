package com.hjx.Graph;

/*
Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input:
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation:
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 */
import java.util.*;

public class AccountsMerge {

    //DFS
    public List<List<String>> accountsMergeDFS(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (accounts.size() == 0) return res;
//        Collections.sort(accounts, (o1, o2) -> o1.get(0).compareTo(o2.get(0)));
        Set<String> visited = new HashSet<String>();
        //build email graph
        Map<String, Set<String>> g = new HashMap<String, Set<String>>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!g.containsKey(account.get(i))) {
                    g.put(account.get(i), new HashSet<String>());
                }
                g.get(account.get(i)).add(account.get(1));
                g.get(account.get(1)).add(account.get(i));
            }
        }
        //DFS
        for (List<String> account : accounts) {
            if(visited.contains(account.get(1))) continue;
            List<String> tmp = new ArrayList<String>();
            DFS(g, visited, tmp, account.get(1));
            Collections.sort(tmp);
            tmp.add(0, account.get(0));
            res.add(tmp);
        }

        return res;
    }

    public void DFS(Map<String, Set<String>> g, Set<String> visited, List<String> list, String cur){
        if(visited.contains(cur)) return;
        list.add(cur);
        visited.add(cur);
        for(String s : g.get(cur)){
            DFS(g, visited, list, s);
        }
    }

    //Union find
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //union find parent set
        Map<String, String> parent = new HashMap<String, String>();

        //email -> name
        Map<String, String> owner = new HashMap<String, String>();
        Map<String, TreeSet<String>> union = new HashMap<String, TreeSet<String>>();

        //init
        for(List<String> account : accounts){
            for(int i = 1; i < account.size(); i++){
                if(! parent.containsKey(account.get(i))) {
                    parent.put(account.get(i), account.get(i));
                    owner.put(account.get(i), account.get(0));
                }
            }
        }

        for(List<String> account : accounts){
            String p = account.get(1);
            for(int i = 2; i < account.size(); i ++){
                if(find(account.get(i), parent) == account.get(i)){
                    parent.put(account.get(i), find(p, parent));
                }
                else{
                    parent.put(find(account.get(i), parent), find(p, parent));
                }
            }
        }

        List<List<String>> res = new ArrayList<List<String>>();
        for(List<String> account : accounts){
            String p = find(account.get(1), parent);
            if(!union.containsKey(p)){
                union.put(p, new TreeSet<String>());
            }
            for(int i = 1; i < account.size(); i ++){
                union.get(p).add(account.get(i));
            }
        }

        for(String p : union.keySet()){
            List<String> tmp = new ArrayList<String>(union.get(p));
            tmp.add(0, owner.get(p));
            res.add(tmp);
        }
        return res;
    }

    public String find(String x, Map<String, String> parent){
        return parent.get(x) == x ? x : find(parent.get(x), parent);
    }

    public boolean union(String x, String y, Map<String, String> parent){
        String rootx = find(x, parent);
        String rooty = find(y, parent);
        if(rootx == rooty) return true;
        parent.put(rootx, rooty);
        return false;
    }
}

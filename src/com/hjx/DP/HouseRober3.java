package com.hjx.DP;

import java.util.HashMap;

/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRober3 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int robDFS(TreeNode root) {
        if(root == null) return 0;
        return Math.max(DFS(root, true), DFS(root, false));
    }
    //stole root: flag = true; not stole: flag = false
    public int DFS(TreeNode root, boolean flag){
        if(root == null) return 0;
        if(flag){
             int r1 = root.val + DFS(root.left, false) + DFS(root.right, false);
             int r2 = DFS(root.left, true) + DFS(root.right, true);
             return Math.max(r1, r2);
        }
        else
            return DFS(root.left, true) + DFS(root.right, true);
    }

    public int rob(TreeNode root){
        return robSub(root, new HashMap<TreeNode, Integer>());
    }

    public int robSub(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int val = 0;
        if(root.left != null){
            val = val + robSub(root.left.left, map) + robSub(root.left.right, map);
        }
        if(root.right != null){
            val = val + robSub(root.right.left, map) + robSub(root.right.right, map);
        }
        val = Math.max(root.val + val, rob(root.left) + rob(root.right));
        map.put(root, val);
        return val;
    }

    public int rob2(TreeNode root){
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    //res[0] not stole, res[1] stole
    public int[] robSub(TreeNode root){
        if(root == null) return new int[2];
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}

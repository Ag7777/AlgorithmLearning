package com.hjx.BiShi;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Renren1 {
    public static void main(String[] args){
        KeCheng[] kecheng = new KeCheng[5];

        kecheng[0] = new KeCheng(10, "cyuyan", new Integer[0]);
        kecheng[1] = new KeCheng(2, "数据结构", new Integer[]{10});
        kecheng[2] = new KeCheng(3, "编译原理", new Integer[]{2});
        kecheng[3] = new KeCheng(4, "数据库原理", new Integer[2]);
        kecheng[4] = new KeCheng(5, "毕业设计", new Integer[]{3, 4});

        List<Integer[]> list = new ArrayList<Integer[]>();
        for(int i = 0; i < kecheng.length; i ++){
            list.add(kecheng[i].dependOn);
        }


    }
}

class Node{

    int val;

}

class KeCheng{
    int id;
    String name;
    Integer[] dependOn;

    public KeCheng(int id, String name, Integer[] dependOn){
        this.id = id;
        this.name = name;
        this.dependOn = dependOn;
    }
}
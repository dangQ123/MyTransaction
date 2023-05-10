package edu.njust.transaction;

public class Data {

    //名称
    public String name;

    //读时间
    public int RT;

    //写时间
    public int WT;

    public Data(String name) {
        this.name=name;
        RT=0;
        WT=0;
    }

    public Data(String name, int RT, int WT) {
        this.name = name;
        this.RT = RT;
        this.WT = WT;
    }
}

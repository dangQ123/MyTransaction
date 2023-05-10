package edu.njust.transaction;

// 执行具体的操作
public class Action {

    //操作的元素
    public String dataName;
    //操作的类型
    public String type;
    //所属事务
    public int order;

    public Action(String dataName, String type, int order) {
        this.dataName = dataName;
        this.type = type;
        this.order = order;
    }

}

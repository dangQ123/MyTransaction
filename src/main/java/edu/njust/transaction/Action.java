package edu.njust.transaction;

// 执行具体的操作
public class Action {

    //操作的元素
    public String dataName;
    //操作的类型
    public String type;

    public Action(String dataName, String type) {
        this.dataName = dataName;
        this.type = type;
    }

}

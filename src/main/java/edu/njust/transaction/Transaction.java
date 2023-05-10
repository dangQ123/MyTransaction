package edu.njust.transaction;

import java.util.List;

public class Transaction {
    //事务时间戳
    public int TS;
    //执行的操作列表
    public List<Action> actionList;
    //事务状态
    public boolean status=true;
    public Transaction(int TS, List<Action> actionList) {
        this.TS = TS;
        this.actionList = actionList;
    }
    //返回顺序执行的操作
    public Action getActionByIndex(int idx) {
        return actionList.get(idx);
    }
    //得到事务操作次数
    public int getActionListSize(){
        return this.actionList.size();
    }

}

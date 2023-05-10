package edu.njust;

import edu.njust.transaction.Action;
import edu.njust.transaction.Data;
import edu.njust.transaction.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionMain {

    //事务列表
    public List<Transaction> transactionList;

    //元素列表
    public Map<String,Data> dataList;

    //操作列表
    public List<Action> actionList;

    public TransactionMain() {
        transactionList=new ArrayList<>();
        dataList=new HashMap();
        actionList=new ArrayList<>();
    }

    //添加事务
    public void addTransaction(Transaction transaction){
        this.transactionList.add(transaction);
    }

    //添加元素
    public void addData(Data data){
        this.dataList.put(data.name,data);
    }

    //添加操作
    public void addAction(Action action){
        actionList.add(action);
    }

    //进行事务调度
    public void operate(){
        //遍历事务
        for (int i = 0; i < actionList.size(); i++) {
            //得到要执行的操作
            Action action = actionList.get(i);
            //得到所属事务
            Transaction transaction = transactionList.get(action.order);
            //事务没有终止
            if (transaction.status) {
                //获取要操作的元素
                String dataName = action.dataName;
                Data data = this.dataList.get(dataName);
                //判断操作类型
                if (action.type.equals("R")) {
                    //类型为读并且读可实现
                    if (transaction.TS > data.WT) {
                        data.RT=transaction.TS;
                        System.out.println("元素" + data.name + "读时间置为：" + data.RT);
                    } else {
                        transaction.status=false;
                        System.out.println("读时间在写时间前，回滚");
                    }
                } else {
                    //元素读时间不大于事务写时间
                    if (transaction.TS >= data.RT) {
                        //类型为写且可实现，需要执行
                        if (transaction.TS >= data.WT) {
                            data.WT=transaction.TS;
                            System.out.println("元素" + data.name + "写时间置为：" + data.WT);
                        }
                    } else {
                        transaction.status = false;
                        System.out.println("事务终止");
                    }
                }
            }
        }
    }

}

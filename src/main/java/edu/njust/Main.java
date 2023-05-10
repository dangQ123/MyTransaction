package edu.njust;

import edu.njust.transaction.Action;
import edu.njust.transaction.Data;
import edu.njust.transaction.Transaction;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TransactionMain transactionByTime = new TransactionMain();
        //三个元素
        Data a = new Data("A");
        Data b = new Data("B");
        Data c = new Data("C");
        //三个事务
        Transaction T1 = new Transaction(200, new ArrayList<Action>());
        Transaction T2 = new Transaction(150, new ArrayList<Action>());
        Transaction T3 = new Transaction(175, new ArrayList<Action>());
        T1.actionList.add(new Action("B", "R"));
        T1.actionList.add(new Action("B","W"));
        T1.actionList.add(new Action("A","W"));
        T2.actionList.add(new Action("A","R"));
        T2.actionList.add(new Action("C","W"));
        T3.actionList.add(new Action("C","R"));
        T3.actionList.add(new Action("A","W"));
        //事务列表添加事务和元素
        transactionByTime.addTransaction(T1);
        transactionByTime.addTransaction(T2);
        transactionByTime.addTransaction(T3);
        transactionByTime.addData(a);
        transactionByTime.addData(b);
        transactionByTime.addData(c);
        //开始执行
        transactionByTime.operate();
    }

}

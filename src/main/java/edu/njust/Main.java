package edu.njust;

import edu.njust.transaction.Action;
import edu.njust.transaction.Data;
import edu.njust.transaction.Transaction;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TransactionMain transactionMain = new TransactionMain();
        //三个元素
        Data a = new Data("A");
        Data b = new Data("B");
        Data c = new Data("C");
        //三个事务
        Transaction T1 = new Transaction(200);
        Transaction T2 = new Transaction(150);
        Transaction T3 = new Transaction(175);
        transactionMain.addAction(new Action("B", "R",0));
        transactionMain.addAction(new Action("A","R",1));
        transactionMain.addAction(new Action("C","R",2));
        transactionMain.addAction(new Action("B","W",0));
        transactionMain.addAction(new Action("A","W",0));
        transactionMain.addAction(new Action("C","W",1));
        transactionMain.addAction(new Action("A","W",2));
        //事务列表添加事务和元素
        transactionMain.addTransaction(T1);
        transactionMain.addTransaction(T2);
        transactionMain.addTransaction(T3);
        transactionMain.addData(a);
        transactionMain.addData(b);
        transactionMain.addData(c);
        //开始执行
        transactionMain.operate();
    }

}

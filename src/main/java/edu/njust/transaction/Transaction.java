package edu.njust.transaction;

import java.util.List;

public class Transaction {
    //事务时间戳
    public int TS;
    //事务状态
    public boolean status=true;
    public Transaction(int TS) {
        this.TS = TS;
    }

    public Transaction(){
        TS = 0;
    }

    public Transaction(int TS, boolean status) {
        this.TS = TS;
        this.status = status;
    }
}

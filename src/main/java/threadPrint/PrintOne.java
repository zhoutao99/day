package threadPrint;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOne {
    public static void main(String[] args) {
        Lock ll=new ReentrantLock();
        ThDemo th=new ThDemo(ll);


        Thread t1=new Thread(th);
        Thread t2=new Thread(th);
        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();

    }
}

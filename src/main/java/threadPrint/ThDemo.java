package threadPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ThDemo implements Runnable {
    private Lock l;
    private Condition c;
    int i;

    public ThDemo(Lock ll) {
        this.l = ll;
        this.c = l.newCondition();
    }

    @Override
    public void run() {
        while (true) {
            l.lock();
            if (i > 100) {
                c.signal();
                l.unlock();
                break;
            } else {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                i++;
                try {
                    c.signal();
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            l.unlock();
        }
    }
}

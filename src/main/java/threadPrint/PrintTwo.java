package threadPrint;

public class PrintTwo implements Runnable {

    int num = 1;

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                //唤醒wait()的一个或者所有线程
                notify();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                } else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

class Test2 {

    public static void main(String[] args) {
        PrintTwo printNum = new PrintTwo();

        Thread t1 = new Thread(printNum);
        Thread t2 = new Thread(printNum);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }

}
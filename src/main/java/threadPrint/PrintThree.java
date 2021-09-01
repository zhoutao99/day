package threadPrint;

public class PrintThree {
    public void print1() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < 101; i = i + 2) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i == 100) {
                    this.notify();
                    break;
                }
                this.notify();
                this.wait();
            }
        }
    }

    public void print2() throws InterruptedException {
        synchronized (this) {
            for (int i = 1; i < 101; i = i + 2) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i == 99) {
                    this.notify();
                    break;
                }
                this.notify();
                this.wait();
            }
        }
    }

    public static void main(String[] args) {
        PrintThree p = new PrintThree();
        Thread t1 = new Thread(() -> {
            try {
                p.print1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                p.print2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();
    }
}

package javaPrograms;

class Resource { }
public class DeadlockDemo {
    private final Resource r1 = new Resource();
    private final Resource r2 = new Resource();

    public void t1() {
        synchronized (r1) {
            System.out.println("t1 locked r1");
            sleep(100);
            synchronized (r2) {
                System.out.println("t1 locked r2");
            }
        }
    }

    public void t2() {
        synchronized (r2) {
            System.out.println("t2 locked r2");
            sleep(100);
            synchronized (r1) {
                System.out.println("t2 locked r1");
            }
        }
    }

    static void sleep(long ms) { try { Thread.sleep(ms); } catch (InterruptedException ignored) {} }

    public static void main(String[] args) {
        DeadlockDemo d = new DeadlockDemo();
        new Thread(d::t1, "T1").start();
        new Thread(d::t2, "T2").start();
    }
}

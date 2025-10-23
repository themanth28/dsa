package javaPrograms;

class A {
    synchronized void methodA(B b) {
        System.out.println("Thread1 locked A");
        try { Thread.sleep(1000); } catch (Exception e) {}
        b.last();
    }
    synchronized void last() { System.out.println("Inside A.last()"); }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread2 locked B");
        try { Thread.sleep(1000); } catch (Exception e) {}
        a.last();
    }
    synchronized void last() { System.out.println("Inside B.last()"); }
}

public class DeadlockExample extends Thread {
    A a = new A();
    B b = new B();

    public void run() { b.methodB(a); }

    public static void main(String[] args) {
        DeadlockExample d = new DeadlockExample();
        new Thread(() -> d.a.methodA(d.b)).start();
        d.start();
    }
}

class A {
    synchronized void method(B b) {
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last()");
    }
}

class B {
    synchronized void method(A a) {
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last()");
    }
}

class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    Deadlock() {
        Thread t = new Thread(this);
        int count = 20000;

        t.start();
        while (count-->0);
        a.method(b);
    }

    public void run() {
        b.method(a);
    }
    public static void main(String[] args) {
        new Deadlock();
    }
}

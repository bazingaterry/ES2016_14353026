# Lab 4

## Task

使用 Java 实现死锁，阐述其原因。

```java
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
```

运行脚本。

```bash
#! /bin/bash
javac Deadlock.java
for (( i = 0; i < 10000; i++ )); do
    echo "$i times"
    java Deadlock
done
```

运行结果。

![](https://static.32ph.com/upload-pic/5qfke.jpg)

产生死锁的四个必要条件：
1. 互斥条件：一个资源每次只能被一个进程使用。
2. 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
3. 不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。
4. 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。

下面分析上述程序产生死锁的原因。

1. `Thread t = new Thread(this)` 创建了一个新线程，执行 run 函数，即 `b.method(a)`。
2. 主线程一段时间之后执行 `a.method(b)`。
3. 综上所述，`b.method(a)` 和 `a.method(b)` 会有可能被同时执行。
4. 假设主线程先执行，调用 `a.method(b)`，此时 a object 被主线程独占。
5. 假设此时子线程被调度，执行 `b.method(a)`，此时 b object 被子线程独占。在这个函数中又会调用 `a.last()`，但由于 a object 被主线程独占，子线程获取锁失败，休眠。
6. 主线程被调度，执行 `a.method(b)`，在这个函数中又会调用 `b.last()`，但由于 b object 被子线程独占，主线程获取锁失败，休眠。
7. 所有线程均被休眠，系统进入死锁状态。

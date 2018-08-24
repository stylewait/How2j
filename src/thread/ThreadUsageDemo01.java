package thread;

public class ThreadUsageDemo01 {
    public static void main(String[] args) {
        //实际的子线程
        MyThread t0 = new MyThread();
        t0.setName("线程000");
        t0.start();

        MyThread1 t1 = new MyThread1();
        t1.setName("线程111");
        t1.start();

        Thread thread = Thread.currentThread();
        System.out.println(thread);

        System.out.println(thread.getName());

        thread.setName("主线程");
        System.out.println(thread.getName());

        MyThread1 t2 = new MyThread1("新的线程");
        t2.start();
    }
}
//线程类
class MyThread extends Thread{
    public void run(){
        for(int i = 0; i < 10; i++) {
            System.out.println("hello" + i);
        }

        Thread thread = Thread.currentThread();
        System.out.println(thread);
        System.out.println(thread.getName());
    }

}

class MyThread1 extends Thread{
    public MyThread1(){}

    public MyThread1(String name) {
        super(name);
    }

    public void run(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
    }
}

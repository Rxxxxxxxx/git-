package com.hbxy.webstudy.lock;

/**
 * 不可重入锁
 */
public class LockTest01 {
    Lock lock=new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        doSome();
        lock.unlock();
    }

    public void doSome() throws InterruptedException {
        lock.lock();
        System.out.println();
        lock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        LockTest01 test01=new LockTest01();
        test01.a();
        test01.doSome();
    }
}
//不可重入锁
class Lock{
    private boolean isLocked=false;


    //使用锁
    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    //释放锁
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}

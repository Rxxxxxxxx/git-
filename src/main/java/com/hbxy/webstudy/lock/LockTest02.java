package com.hbxy.webstudy.lock;

/**
 * 可重入锁
 * 锁可以延续使用
 */
public class LockTest02 {
    ReLock lock=new ReLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSome();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public void doSome() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    public static void main(String[] args) throws InterruptedException {
        LockTest02 test01=new LockTest02();
        test01.a();
        test01.doSome();

        Thread.sleep(1000);
        System.out.println(test01.lock.getHoldCount());
    }
}
class ReLock{
    private boolean isLocked=false;
    private Thread lockedBy = null;  //存线程
    private int holdCount = 0;

    public int getHoldCount() {
        return holdCount;
    }

    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t=Thread.currentThread();
        while(isLocked&&lockedBy!=t){
            wait();
        }
        isLocked = true;
        lockedBy=t;
        holdCount++;
    }
    //释放锁
    public synchronized void unlock(){
        if (Thread.currentThread() == lockedBy) {
            holdCount--;
            if (holdCount == 0) {
                isLocked = false;
                notify();
                lockedBy=null;
            }
        }

    }
}
package hybrid;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue_1188 {
    Deque<Integer> blockingQueue = new ArrayDeque<>();
    int size = -1;
    ReentrantLock lock = new ReentrantLock();
    Condition emptyCondition = lock.newCondition();
    Condition fullCondition = lock.newCondition();

    public BoundedBlockingQueue_1188(int capacity) {
        this.size = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            if (blockingQueue.size() == size) {
                fullCondition.await();
            }
            blockingQueue.addLast(element);
            emptyCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            if (blockingQueue.size() == 0) {
                emptyCondition.await();
            }
            int val = blockingQueue.removeFirst();
            fullCondition.signal();
            return val;
        } finally {
            lock.unlock();
        }
    }

    public synchronized int size() {
        return this.blockingQueue.size();
    }
}

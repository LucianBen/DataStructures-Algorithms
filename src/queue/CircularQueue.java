package queue;

public class CircularQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n;
    // head 表示队头下标，tail 表示队尾下标
    private int head;
    private int tail;

    // 申请一个大小为 capacity 的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enquene(String item) {
        // 队列满了
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }


    // 出队
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) return null;
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }


}

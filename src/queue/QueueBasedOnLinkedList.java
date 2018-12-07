package queue;

public class QueueBasedOnLinkedList {
    private Node head = null;
    private Node tail = null;

    // 入队
    private void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    //出队
    private String dequeue() {
        if (head == tail) return null;
        String value = head.data;
        head = head.next;
        if (head == null) tail = null;
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data + "");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        private Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

}

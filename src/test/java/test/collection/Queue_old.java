package test.collection;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/13 15:33 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Queue_old {

    private int[] array;
    private int front;
    private int end;
    private int index;
    private int length;

    public Queue_old(int length) {
        array = new int[length];
        this.length = length;
        front = 0;
        end = 0;
        index = 0;
    }

    //插入一个元素队尾右移
    private void insert(int value) {
        if (isFull()) {
            System.out.println("is full,cannot insert");
            return;
        }
        array[end++] = value;
        index++;
    }

    //TODO
    private int remove() {
        if (isEmpty()) {
            System.out.println("is empty,cannot remove");
            return -1;
        }
        index--;
        return array[front++];
    }

    private int size() {
        return index;
    }

    private int peekFront() {
        return array[front];
    }

    private boolean isEmpty() {
        return index == 0;
    }

    private boolean isFull() {
        return index == length;
    }

    public static void main(String[] args) {
        Queue_old q = new Queue_old(4);
        System.out.println("test.collection.Queue_old is empty:" + q.isEmpty());

        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);

        System.out.println(q.size());
        System.out.println("front is " + q.peekFront());

        while (!q.isEmpty())
            System.out.println(q.remove());
    }

}

package test.collection;

import java.util.Arrays;

/**
 * Function: 队列模拟 - FIFO
 * Reason: 队列只能在表头进行删除，在表尾进行增加 - 使用于排队系统</br>
 * Date: 2017/9/13 18:54 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Queue<T> {

    private int DEFAULT_SIZE = 10;
    private int capacity;
    private Object[] elementData;
    private int front = 0;
    private int rear = 0;


    public Queue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public Queue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    public Queue(T element, int initSize) {
        if (initSize == 0) {
            capacity = DEFAULT_SIZE;
            elementData = new Object[capacity];
        } else {
            capacity = initSize;
            elementData = new Object[initSize];
        }
        elementData[0] = element;
        rear++;
    }

    public int size() {
        return rear - front;
    }

    public void add(T element) {
        if (rear > capacity - 1) {
            throw new IndexOutOfBoundsException("the queue is full");
        }
        elementData[rear++] = element;
    }

    /**
     * FIFO - 先进先出
     *
     * @return
     */
    public T remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("the queue is empty");
        }
        T oldValue = (T) elementData[front];
        elementData[front++] = null;//同时移动front指针
        return oldValue;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void clear() {
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }

    /**
     * 首元素
     *
     * @return
     */
    public T element() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("queue is empty");
        }
        return (T) elementData[front];
    }

    @Override
    public String toString() {
        return "Queue{" +
                "DEFAULT_SIZE=" + DEFAULT_SIZE +
                ", capacity=" + capacity +
                ", elementData=" + Arrays.toString(elementData) +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>("ABC", 20);
        queue.add("DEF");
        queue.add("egg");
        queue.remove();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.element());
        queue.clear();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
    }
}

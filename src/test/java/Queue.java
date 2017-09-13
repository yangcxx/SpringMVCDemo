/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
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
}

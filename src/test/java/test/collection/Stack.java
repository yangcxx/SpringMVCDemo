package test.collection;

/**
 * Function: FILO / LIFO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/14 10:12 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Stack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data,Node<T> next){
            this.data = data;
            this.next = next;
        }

        Node(T data){
            this(data,null);
        }
    }

    static LinkedList list = new LinkedList();

    public T push(T item){
        list.addFromHead(item);
        return item;
    }

    public void pop(){
        list.removeFromTail();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int search(T t){
        return list.indexOf(t);
    }

    public static void main(String[] args) {
        //TODO
    }
}

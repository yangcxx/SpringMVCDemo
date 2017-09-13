/**
 * Function: 单向队列模拟
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/13 17:20 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class LinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
        }

        private Node<T> head, tail;

        public Node() {
            head = tail = null;
        }

        /**
         * judge the list is empty
         *
         * @return
         */
        public boolean isEmpty() {
            return head == null;
        }

        /**
         * add head node
         *
         * @param item
         */
        public void addHead(T item) {
            Node<T> node = new Node<T>(item);
            Node<T> f = head;
            head = node;
            if (null == f) {
                tail = node;
            } else {
                node.next = f;
            }
        }

        /**
         * add the tail pointer
         *
         * @param item
         */
        public void addTail(T item) {
            if (!isEmpty()) {
                //cxy
                //tail = new Node<T>(item, tail);

                tail.next = new Node<T>(item);
                tail = tail.next;
            } else {
                head = tail = new Node<T>(item);
            }
        }

        /**
         * print the list
         */
        public void print() {
            if (isEmpty()) {
                System.out.println("null");
            } else {
                for (Node<T> node = head; node != null; node = node.next) {
                    System.out.println(node.data);
                }
            }
        }

        /**
         * insert node from head
         *
         * @param item
         */
        public void addFromHead(T item) {
            Node<T> node = new Node<T>(item);
            if (!isEmpty()) {
                node.next = head;
                head = node;
            } else {
                head = tail = node;
            }
        }

        /**
         * insert node from tail
         * //fixme
         *
         * @param item
         */
        public void addFromTail(T item) {
            Node<T> node = new Node<T>(item);
            if (!isEmpty()) {
                tail.next = node;
                tail = node;
            } else {
                head = tail = node;
            }
        }

        /**
         * delete node from head
         */
        public void removeFromHead() {
            if (!isEmpty()) {
                head = head.next;
            } else {
                System.out.println("The list is already empty");
            }
        }

        /**
         * delete from tail ,lower effect
         */
        public void removeFromTail() {
            Node<T> prev, curr = head;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
                if (curr.next == null)
                    prev.next = null;
            }


            //while (!curr.next.equals(tail)) {
            //    prev = curr;
            //    curr = curr.next;
            //    if (curr.next.equals(tail)) {
            //        prev.next = null;
            //    }
            //}
        }

        /**
         * insert a new node
         *
         * @param appointedItem
         * @param item
         */
        public boolean insert(T appointedItem, T item) {
            Node<T> node = new Node<T>(item);
            Node<T> prev = head, curr = head.next;
            if (!isEmpty()) {
                while (curr != null && !curr.data.equals(appointedItem)) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = node;
                node.next = curr.next;
                return true;
            }
            return false;
        }

        public void remove(T item) {
            //Node<T> prev = head,curr = head.next;
            //if (!isEmpty()){
            //    while (curr != null && !curr.data.equals(item)){
            //        prev = curr;
            //        curr = curr.next;
            //    }
            //    if (curr.data.equals(item)) {
            //        prev.next = curr.next;
            //    }
            //}
            Node<T> curr = head, prev = null;
            boolean found = false;
            while (curr != null && !found) {
                if (item.equals(curr.data)) {
                    if (prev == null) {
                        removeFromHead();
                    } else {
                        prev.next = curr.next;
                    }
                    found = true;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }

        public int indexOf(T item) {
            int index = 0;
            //Node<T> curr = head;
            //while (curr != null) {
            //    if (!curr.data.equals(item)) {
            //        index++;
            //        curr = curr.next;
            //    } else {
            //        return index;
            //    }
            //}
            for (Node<T> curr = head; curr != null; curr = curr.next) {
                if (curr.data.equals(item)) {
                    return index;
                }
                index++;
            }


            return -1;
        }

        public boolean contains(T item){
            return indexOf(item) != -1;
        }
    }

}

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Function: 模拟栈实现
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/13 14:49 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Stack_old {

    private String[] array;
    private int length;
    private int top;

    public Stack_old(int length) {
        this.length = length;
        array = new String[length];
        top = -1;
    }

    public void push(String value) {
        if (isFull()) {
            System.out.println("full,cannot insert");
            return;
        }
        array[++top] = value;
    }

    /**
     * 获取最后一个有效元素
     *
     * @return
     */
    public String pop() {
        return array[top--];//fixme
    }

    public boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if (top == length - 1) {
            return true;
        }
        return false;
    }

    public void display() {
        while (!isEmpty()) {
            System.out.println(pop());
        }
    }

    @Override
    public String toString() {
        return "test.Stack_old{" +
                "array=" + Arrays.toString(array) +
                ", length=" + length +
                ", top=" + top +
                '}';
    }

    public static void main(String[] args) {
        Stack_old s = new Stack_old(5);
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        s.push("6");
        //int pop = s.pop();
        //System.err.println("pop: "+pop);
        s.display();
        //System.out.println(s);

        System.out.println("-----------------------");
        //Scanner sc = new Scanner(System.in);
        //String nextLine = sc.nextLine();
        //test.Stack_old stack = new test.Stack_old(nextLine.length());
        //System.out.println(stack.reserve(nextLine));
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String string = bufferedReader.readLine();
            Stack_old stack = new Stack_old(string.length());
            System.out.println(stack.reserve(string));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 逆序
     *
     * @param in
     * @return
     */
    public String reserve(String in) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            push(String.valueOf(c));
        }
        while (!isEmpty()) {
            out.append(pop());
        }
        return out.toString();
    }

}

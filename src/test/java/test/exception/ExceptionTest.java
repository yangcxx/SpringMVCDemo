package test.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/15 16:09 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ExceptionTest {

    public static void main(String[] args) {
        boolean file = open();
        System.out.println("this is main return value:" + file);
    }

    public static boolean open() {
        String filename = "e:\\test.txtp";
        try {
            FileReader reader = new FileReader(filename);
            Scanner in = new Scanner(reader);
            String input = in.next();
            int value = Integer.parseInt(input);
            System.out.println(value);
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("this is catch_for_file not... block!");
            return false;
        } finally {
            System.out.println("this is finally block!");
        }
    }

}

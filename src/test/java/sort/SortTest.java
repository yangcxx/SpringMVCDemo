package sort;

import java.util.Arrays;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/11 18:09 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class SortTest {

    private int[] array;
    private int number = 0;

    public SortTest(int max) {
        array = new int[max];
    }

    public void insert(int value) {
        array[number] = value;
        number++;
    }

    /**
     * 二分法查找-前提数组必须排序
     * TODO 升序
     *
     * @param value
     * @return
     */
    public int binaryFind(int value) {
        int start = 0;
        int end = number - 1;//下标
        while (end >= start) {
            int index = (end + start) / 2;
            if (array[index] == value) {
                return index;
            } else if (array[index] > value) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return number;
    }

    public int find(int value) {
        for (int i = 0; i < number; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return number;
    }

    /**
     * 并未真实删除-仅将后面的元素向前复制（最后一个元素未作改动，修改了数组长度-下次添加时会覆盖）
     *
     * @param value
     * @return
     */
    public boolean delete(int value) {
        int index = find(value);
        if (index != number) {
            for (int i = index; i < number - 1; i++) {
                array[i] = array[i + 1];
            }
            number--;
            return true;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < number; i++) {
            System.out.printf(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        //int array[] = new int[10];
        //System.out.println(array[2]);//0
        //SortTest a[] = new SortTest[12];
        //System.out.println(a[1]);//对象初始化 - null
        //int array2[] ={1,2,3,4,5,5,6};
        /*SortTest ua = new SortTest(5);
        ua.insert(1);
        ua.insert(2);
        ua.insert(6);
        ua.insert(7);
        ua.insert(3);
        ua.display();

        if (ua.find(5) != ua.number) {
            System.out.println("find,the number index is " + ua.find(5));
        } else {
            System.out.println("not found");
        }

        if (ua.delete(5) != true) {
            System.out.println("cannot delete");
        }
        ua.delete(1);
        ua.display();*/

        //冒泡排序
        int[] a = {1, 4, 2, 5, 5, 7, 1, 3};
        //外层决定循环次数 - 每次循环得到一个极值
        for (int i = 0; i < a.length - 1; i++) {
            //相邻比较
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        System.out.println("冒泡排序-" + Arrays.toString(a));

        //顺序排序
        int[] a2 = {1, 4, 2, 5, 7, 3};
        for (int i = 0; i < a2.length - 1; i++) {
            int min = a2[i];
            for (int j = i + 1; j < a2.length - 1; j++) {
                if (min > a2[j]) {
                    int tmp = min;
                    min = a2[j];
                    a2[j] = tmp;
                }
            }
        }
        System.err.println("顺序排序--" + Arrays.toString(a2));

        //插入排序
        int[] a3 = {1, 3, 2, 1, 4, 2, 5, 7, 3};
        for (int i = 1; i < a3.length; i++) {
            int index = i;
            int tmp = a3[i];
            while (index > 0 && a3[index - 1] > tmp) {
                a3[index] = a3[index - 1];
                index--;
            }
            a3[index] = tmp;
        }
        System.out.println("插入排序--" + Arrays.toString(a3));


        //计数排序
        int[] a4 = {1, 2, 3, 4, 4, 4, 3, 1, 2, 3};
        int[] ints = countSort(a4, 4);
        System.out.println("计数排序---" + Arrays.toString(ints));

        int a5[] = {1, 2, 3, 4, 4, 4, 3, 1, 2, 3};
        int c[] = new int[5];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < a5.length; j++) {
                if (a5[j] == i) {
                    c[i]++;
                }
            }
        }
        int index = 0;
        for (int j = 0; j < c.length; j++) {
            for (int i = index; i < index + c[j]; i++) {
                a5[i] = j;
            }
            index += c[j];
        }
        System.out.println(Arrays.toString(a));

    }

    private static int[] countSort(int[] A, int k) {
        int[] C = new int[k + 1];//记录 A 数组中元素出现个数
        int length = A.length, sum = 0;
        int[] B = new int[length];//排序后结果数组
        for (int i = 0; i < length; i++) {
            C[A[i]] += 1;//统计A中各元素个数，存入C
        }
        for (int i = 0; i < k + 1; i++) {//修改C
            sum += C[i];
            C[i] = sum;
        }
        for (int i = length - 1; i >= 0; i--) {//遍历A，构造B
            B[C[A[i]] - 1] = A[i];//将A中该元素放到排序后数组B中指定位置
            C[A[i]]--;//将C中该元素-1，方便放下一个同样大小的元素
        }
        return B;
    }

}


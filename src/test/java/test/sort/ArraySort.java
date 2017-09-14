package test.sort;

import java.util.Arrays;

/**
 * Function: 排序
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/14 16:57 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ArraySort {

    /**
     * 选择排序：通过循环，找到最小数的下标 minIndex，并保持 minIndex 为待排序数组中最小值的下标
     *
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array) {
        int minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = tmp;
            }
        }
        return array;
    }

    /**
     * 插入排序：从待排序的数组中选出一个数来，插入到前面合适的位置
     *
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmpValue = array[i];
            int tmpIndex = i;
            while (tmpIndex > 0 && array[tmpIndex - 1] > tmpValue) {
                array[tmpIndex] = array[tmpIndex - 1];
                tmpIndex--;
            }
            array[tmpIndex] = tmpValue;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 5, 8, 1, 3, 5, 4, 6, 3, 1};
        System.out.println(Arrays.toString(insertSort(array)));
        System.err.println(Arrays.toString(selectSort(array)));
    }
}

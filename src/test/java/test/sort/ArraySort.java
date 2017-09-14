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
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubblingSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * cxy 快速排序 - 设置两个指针（i & j）分别指向第一个和最后一个，i 向后移动，j 向前移动，选第一个数为标准（一般如此），从后面开始，找到第一个比标准小的数，互换位置；然后再从前面找到第一个比标准大的数，互换位置
     *
     * @param array
     * @return
     */
    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int result = quickSortUtil(array, low, high);
            quickSort(array, low, result - 1);
            quickSort(array, result + 1, high);
        }
        return array;
    }

    private static int quickSortUtil(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            //从 high（后面）开始向前替换
            while (low < high && array[high] >= key) {
                high--;
            }
            array[low] = array[high];
            //从 low（前面）开始向后替换
            while (low < high && array[low] <= key) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = key;
        return low;
    }

    /**
     * 计数排序
     *
     * @param A
     * @param maxValue
     * @return
     */
    public static int[] countSort(int[] A, int maxValue) {
        int[] B = new int[maxValue + 1];
        int[] C = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[A[i]] += 1;
        }
        int sum = 0;
        for (int i = 0; i < B.length; i++) {
            sum += B[i];
            B[i] = sum;
        }
        for (int i = 0; i < C.length; i++) {
            C[B[A[i]] - 1] = A[i];
            B[A[i]]--;
        }

        return C;
    }

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
        int[] array1 = {4, 2, 5, 8, 1, 3, 5, 4, 6, 3, 1};
        int[] array2 = {4, 2, 5, 8, 1, 3, 5, 4, 6, 3, 1};
        int[] array3 = {4, 2, 5, 8, 1, 3, 5, 4, 6, 3, 1};
        int[] array4 = {4, 2, 5, 8, 1, 3, 5, 4, 6, 3, 1};
        int[] array5 = {4, 2, 5, 8, 1, 3, 5, 4, 6, 3, 1};
        System.out.println("插入排序： " + Arrays.toString(insertSort(array1)));
        System.out.println("选择排序： " + Arrays.toString(selectSort(array2)));
        System.out.println("计数排序： " + Arrays.toString(countSort(array3, 8)));
        System.out.println("没搞懂 - 快速排序： " + Arrays.toString(quickSort(array4, 0, array4.length - 1)));
        System.out.println("冒泡排序： " + Arrays.toString(bubblingSort(array5)));
    }
}

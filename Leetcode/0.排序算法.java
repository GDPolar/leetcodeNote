package Leetcode;

import java.util.Arrays;

class A {
    public static void main(String[] args) {
        int[] a = new int[]{4,6,4,7,9,3,5,7,9,3,2,1};
        System.out.println("排序前：" + Arrays.toString(a));
        heapSort(a, a.length);
        System.out.println("排序后：" + Arrays.toString(a));

    }


    /**
     * 冒泡排序
     * 时间复杂度：逆序时最坏 O（n^2）；有序时最好 O（n）
     * 空间复杂度：O（1）
     * 稳定排序
     * 原地排序
    */
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int flag = 0;
            for (int j = i + 1; j < a.length; j++) {
                // 稳定性
                if (a[j] < a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }


    /**
     * 插入排序
     * 时间复杂度：逆序时最坏为 O（n^2）；有序时最好 O（n）
     * 空间复杂度：O（1）
     * 稳定排序
     * 原地排序
     */
    public static void insertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            int j = i - 1;
            // 稳定性
            while (j >= 0 && num < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = num;
        }
    }


    /**
     * 希尔排序：直接插入排序的改进，又称缩小增量排序
     * 时间复杂度：逆序时最坏为 O（n^2）；有序时最好 O（n），平均 O（n^1.3）
     * 空间复杂度：O（1）
     * 不稳定排序
     * 原地排序
     */
    public static void shellSort(int[] a) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            // 同一子序列内插入排序
            for (int i = gap; i < a.length; i++) {
                int j = i - gap;
                int num = a[i];
                while (j >= 0 && a[j] > num) {
                    a[j + gap] = a[j];
                    j -= gap;
                }
                a[j + gap] = num;
            }
        }
    }


    /**
     * 选择排序：每次选最小的放在已排序的集合尾部
     * 时间复杂度：固定 O（n^2）
     * 空间复杂度：O（1）
     * 不稳定排序
     * 原地排序
     */
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int currMinIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[currMinIndex]) {
                    currMinIndex = j;
                }
            }
            int temp = a[currMinIndex];
            a[currMinIndex] = a[i];
            a[i] = temp;
        }
    }
    
    
    /**
     * 快速排序
     * 时间复杂度：每次选择的分界点都是序列中的最小或最大值（逆序或有序）时最坏 O（n^2）；平均 O（nlogn）
     * 空间复杂度：O（nlogn），递归树的高度 
     * 不稳定排序
     * 原地排序
     */
    public static void quickSort(int[] a, int begin, int end) {
        // [begin, end] 闭区间
        if (begin >= end) {
            return;
        }
        // 选第一个数作为基准，记录下来后，该位置就空出来
        int pivot = a[begin];
        int i = begin, j = end; 
        while (i < j) {
            // i 的位置空出来了，则从右开始
            while (i < j && a[j] >= pivot) {
                j--;
            }
            a[i] = a[j];
            // j 的位置空出来了，则从左开始
            while (i < j && a[i] <= pivot) {
                i++;
            }
            a[j] = a[i];
        }
        // 此时 i == j，且 a[i] 的元素已经被调走了
        a[i] = pivot;
        quickSort(a, begin, i - 1);
        quickSort(a, i + 1, end);
    }
    
    /**
     * 堆排序：大顶堆（任何节点一定大于子节点）
     * 时间复杂度：固定 O（nlogn）
     * 空间复杂度：O（1）
     * 不稳定排序
     * 原地排序
     */
    public static void heapSort(int[] a, int length) {
        // 1、从最后一个有孩子的节点开始倒序建堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(a, length, i);
        }
        // 2、每次取出堆顶元素并重新维护
        for (int i = length - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    public static void heapify(int[] a, int length, int current) {
        int lchild = 2 * current + 1;
        int rchild = 2 * current + 2;
        int max = current;
        if (lchild < length && a[max] < a[lchild]) {
            max = lchild;
        }
        if (rchild < length && a[max] < a[rchild]) {
            max = rchild;
        }
        if (max != current) {
            int temp = a[current];
            a[current] = a[max];
            a[max] = temp;
            heapify(a, length, max);
        }
    }


    /**
     * 归并排序
     * 时间复杂度：固定 O（nlogn）
     * 空间复杂度：O（n）。额外的序列去存储排序后的结果
     * 稳定排序
     * 非原地排序
     */
    public static void mergeSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int middle = (end - begin) / 2 + begin;
        mergeSort(a, begin, middle);
        mergeSort(a, middle + 1, end);
        // 合并
        int[] temp = new int[end - begin  + 1];
        int i = begin, j = middle + 1, k = 0;
        while (i <= middle && j <= end && k < temp.length) {
            // 稳定性
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 处理剩下的
        while (i <= middle) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }
        // 写入原数组
        for (int index = 0; index < temp.length; index++) {
            a[begin + index] = temp[index];
        }
        return;
    }
    

    /**
     * 基数排序
     */
    public static void radixSort() {
        
    }

    /**
     * 计数排序
    */
    public static void countingSort() {
        
    }

    /**
     * 桶排序
     */
    public static void bucketSort() {
        
    }
}

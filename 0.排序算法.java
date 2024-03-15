import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] a = new int[]{4,6,4,7,9,3,5,7,9,3,2,1};
        bubbleSort(a);
        System.err.println(Arrays.toString(a));
    }

    /*
    时间复杂度：O(n2) 
    空间复杂度：O(1) 
    稳定排序
    原地排序
    */
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    a[i] ^= a[j];
                    a[j] ^= a[i];
                    a[i] ^= a[j];
                }
            }
        }
    }

    public static void quickSort(int[] a, int begin, int end) {
        // [begin, end]

        int middle = a[begin];
        for (int i = begin, j = end; i < end; i++, j--) {
            
        }
        while (begin < end) {
            while (a[begin] <= middle) {
                begin++;
            }
            while (a[end] >= middle) {
                end--;
            }
            a[begin] ^= a[end];
            a[end] ^= a[begin];
            a[begin] ^= a[end];
            begin++;
            end--;
        }
        a[begin] = middle;
    }
}

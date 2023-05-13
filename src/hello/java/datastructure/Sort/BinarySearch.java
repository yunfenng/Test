package hello.java.datastructure.Sort;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int a) {
        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == a) {
                return mid;
            } else if (a > array[mid]) { //向右查找
                low = mid + 1;
            } else { //向左查找
                high = mid - 1;
            }
        }

        return -1;
    }

}

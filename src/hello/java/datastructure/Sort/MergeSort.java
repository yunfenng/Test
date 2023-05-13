package hello.java.datastructure.Sort;

/**
 * 归并排序
 */
public class MergeSort {

    public static int[] mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
        return data;
    }

    //对两边的数据进行递归
    public static void sort(int[] data, int left, int right) {
        if (left > right) return;
        //找出中间索引
        int center = (left + right) / 2;
        //对左边的数组进行递归
        sort(data, left, center);
        //对右边的数组进行递归
        sort(data, center, right);
        //将两个数组进行归并
        merge(data, left, center, right);
    }

    /**
     * 将两个数组归并：两个数组在归并前是有序的，在归并后依然是有序的
     * @param data 数组对象
     * @param left 左边数组第1个元素的索引
     * @param center 左边数组最后1个元素所有，center+1是右边数组第1个元素索引
     * @param right 右边数组最后1个元素的索引
     */
    private static void merge(int[] data, int left, int center, int right) {
        //临时数组
        int[] tmpArr = new int[data.length];
        //右边数组第1个元素索引
        int mid = center + 1;
        //third记录临时数组的索引
        int third = left;
        while (left <= center && mid <= right) {
            //从两个数组中取出最小的值放入临时数组中
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        //将剩余部分依次放入临时数组(实际上两个while只会执行其中一个)中
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }

        while (left <= mid) {
            tmpArr[third++] = data[left++];
        }

        //将临时数组的内容复制到原数组中
        //(原left-right范围内的内容被复制到原数组中)
//        while (tmp <= right) {
//            data[tmp] = tmpArr[tmp++];
//        }
    }

}

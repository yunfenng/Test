package hello.java.datastructure.Sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {

        //外层循环控制排序趟数
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            //内层循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true; //表示有数据交换
                }
            }
            if (!flag) break; //没有数据交换
        }
        return arr;
    }

}

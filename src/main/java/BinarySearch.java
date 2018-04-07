import java.util.Arrays;
import java.util.Scanner;

/**
 * 算法书中的问题练习
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] whiteList = {2, 3, 6, 7, 4, 8, 2};
        Arrays.sort(whiteList);
        for (int i : whiteList){System.out.print(i);}
        System.out.println();
        System.out.print(rank(whiteList, 2));
    }

    private static int rank(int[] arr, int key) {
        //  还有重复2的问题没考虑吧算是
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int[] readIntArray() {
        Scanner sc = new Scanner(System.in);
        int arrayLength = 7;
        int[] b = new int[arrayLength];
        System.out.printf("请输入%d个数字，用空格隔开，回车结束\n", arrayLength);
        //  将用户输入的一整行字符串赋给s
        String s = sc.nextLine();
        String[] c = s.split("\\s+");
        for (int i = 0; i < arrayLength; i++) {
            b[i] = Integer.parseInt(c[i]);
        }
        sc.close();
        return b;
    }

}

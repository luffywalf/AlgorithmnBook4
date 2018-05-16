/**
 * 希尔排序
 *
 * 就是插入排序的改进，间隔h开始比较换位置，一直到h=1又退回插入排序但是如今已大部分有序，so faster，youtube video is very clear
 *
 * 希尔排序比选择和插入排序要快得多，N越大约占优势
 * 性能不好证明，结论它的运行时间不达到平方级别
 * 代码简单，且不需要额外占内存
 *
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class Shell {
    public static void sort(Comparable[] a){
        int h = a.length/2;
        while (h > 0){
            /*  这里记得从h开始不然走没意义的step了，j>=h才会action */
            for(int i = h; i < a.length; i++){
                for(int j = i; j >= h && less(a[j], a[j-h]); j -= h){
                    exch(a, j, j-h);
                }
            }
            h/=2;
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    private static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Integer[] num = {8,3,6,2,9,3,6,7,2,5,1,78,5};
        sort(num);
        assert isSorted(num);
        show(num);
    }
}

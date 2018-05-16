/**
 * 三向切分的快速排序
 *
 * gt除了初始值及在最后一次gt=i之外都是指向大于v的子数组的最左端
 * lt始终指向3们的最左端
 *
 * 对于包含大量重复元素的数组，排序时间降低到了线性级别（香农信息量证明。。。）
 *
 * Created by Ding on 11/04/2018.
 * @author Ding
 */
public class Quick3way {
    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        int lt = lo, i = lo + 1, gt = hi;
        if (lo >= hi) return;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp > 0) exch(a, i, gt--);
            else if (cmp < 0) exch(a, i++, lt++);
            else i++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);

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
        Integer[] num = {3,6,1,2,8};
        /* 用快速排序前shuffle一下 会是很好哒 */
        sort(num);
        assert isSorted(num);
        show(num);
    }


}

/**
 * 自顶向下的归并排序
 *
 * 对于长度为N的任意数组，自顶向下的归并排序需要 (1/2)N*lg(N)至N*lg(N)次比较， 最多需要访问数组6N*lg(N)次
 * 证明可以看懂但我自己可能想不出来 还得再看 p186
 *
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (lo + hi)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        /*  改进  */
        if (less(a[mid+1],a[mid])) merge(a, lo, mid, hi);

    }
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo, j = mid + 1;

        for(int k = lo; k < hi; k++){
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++){
            /* 左半边用尽 */
            if (i > mid) a[k] = aux[j++];
            /* 右半边用尽 */
            else if (j > hi ) a[k] = aux[i++];
            else if (less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
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

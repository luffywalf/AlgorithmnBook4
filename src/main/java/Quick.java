/**
 * 快速排序
 * 就是找一个基准pivot 把剩余的元素 排成 比基准小的在左 比基准大的在右，左右子数组在递归进行sort
 *
 * 最坏情况输:输入数列越有序越糟糕，不论正向或反向 需要 (n^2)/2次比较 但发生这种情况的概率很低啦
 * 平均需要1.39nln(n)次比较 及1/6次交换 p199数学推导 我自己可能想不到
 * 最好情况：每次都恰好五五分，一次递归共需比较n次，递归深度为lg(n)---------nlg(n)
 *
 * 平均来说 归并排序也可以做到nlgn 但是快速排序的数据移动次数较少 所以还是更快的
 *
 * 算法改进 123 p200
 *
 * 双轴快速排序 https://www.cnblogs.com/nullzx/p/5880191.html
 *
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class Quick {
    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    public static int partition(Comparable[] a, int lo, int hi){
        /* 就取第一个元素为pivot */
        Comparable pivot = a[lo];
        int i = lo, j = hi + 1;

        while (true){
            /* 从左开始找比pivot大的元素 */
            while (less(a[++i], pivot)) if(i >= hi) break;
            /* 从右开始找比pivot小的元素 */
            while (less(pivot, a[--j])) if(j <= lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
        Integer[] num = {10,9,8,7,3};
        /* 用快速排序前shuffle一下 会是很好哒 */
        sort(num);
        assert isSorted(num);
        show(num);
    }

}

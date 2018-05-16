/**
 * 堆排序
 *
 * Created by Ding on 12/04/2018.
 *
 * @author Ding
 */
public class Heap<Key extends Comparable<Key>>{
    static private Integer[] pq;
    static private int N = 0;
    public Heap(int maxN){
        pq = (Integer[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){return N == 0; }
    public int size(){return N;}

    public static void sort(Comparable[] a){
        N = a.length;
        // 构建有序堆
        for (int i = N/2; i > 0; i--){
            sink(a, i, N);
        }
        while (N > 1){
            exch(a,1,N--);
            sink(a,1,N);
        }
    }

    public static void insert(Comparable[] a,Integer v){
        pq[++N] = v;
        swim(a,N);
    }
    public Integer delMax(Comparable[] a){
        /* 从根结点得到最大元素 */
        Integer max = pq[1];
        /* 将其和最后一个结点交换 */
        exch(a,1, N--);
        /* 防止越界 */
        pq[N+1] = null;
        /* 恢复堆的有序性 */
        sink(a,1,N);
        return max;
    }
    private static boolean less(Comparable[] a, int i, int j){
        System.out.print("yo:");
//        System.out.print(a.length);
        System.out.print(i);
        System.out.print(j);

        return a[i].compareTo(a[j]) < 0;}
    private static void exch(Comparable[] a, int i, int j)
    { Integer t = pq[i]; pq[i] = pq[j]; pq[j] = t;}
    // 上浮
    static private void swim(Comparable[] a, int k){
        while ( k > 1 && less(a,k/2, k)){
            exch(a,k/2, k);
            k = k/2;
        }
    }
    // 下沉
    private static void sink(Comparable[] a, int k, int N){
        while (2*k <= N){
            int j = 2*k;
            if (j < N && less(a, j,j+1)) j++;
            if(less(a,k,j)) exch(a, k, j);
            k = j;
        }
    }
    public static void main(String[] args){
        Integer[] num = {10,9,8,7,3};
        Integer[] a = new Integer[num.length+1];
        for(int i=1; i<num.length+1; i++){
            a[i] = num[i-1];
        }

//        Heap h = new Heap(5);


        sort(a);
        for(int i=0; i<5; i++){
            System.out.print(a[i]);
        }

    }

}

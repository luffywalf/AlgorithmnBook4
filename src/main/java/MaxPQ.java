/**
 * 基于堆的优先队列(这还不是排序算法)
 *
 * 我们不在pq[0]里放东西
 * static表示不要实例化就可以使用
 *
 * 插入元素操作只需要不超过lgN+1次操作，比较树高次就好了（+1看新插入的元素有使树高加1咩来决定吧）
 * 删除最大元素的操作不超过2lgN次比较
 *
 * 优先队列的各种实现的插入删除运行时间表对比 p211
 * 索引优先队列 pq[] && elements[] https://www.cnblogs.com/nullzx/p/6624731.html
 *
 * Created by Ding on 12/04/2018.
 *
 * @author Ding
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;
    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){return N == 0; }
    public int size(){return N;}

    public static void sort(Comparable[] a){
        int N = a.length;
    }


    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }
    public Key delMax(){
        /* 从根结点得到最大元素 */
        Key max = pq[1];
        /* 将其和最后一个结点交换 */
        exch(1, N--);
        /* 防止越界 */
        pq[N+1] = null;
        /* 恢复堆的有序性 */
        sink(1);
        return max;
    }
    private boolean less(int i, int j){ return pq[i].compareTo(pq[j]) < 0;}
    private void exch(int i, int j)
    { Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;}
    // 上浮
    private void swim(int k){
        while ( k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }
    // 下沉
    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if (j < N && less(j,j+1)) j++;
            if(less(k,j)) exch(k, j);
            k = j;
        }
    }
    public static void main(String[] args){
        MaxPQ<Integer> pq = new MaxPQ<>(5);
        pq.insert(3);
        pq.insert(5);
        pq.insert(7);
        pq.insert(2);
        pq.insert(4);
        System.out.println(pq.delMax());
        pq.insert(2);
        System.out.println(pq.delMax());

    }

}

/**
 * 插入排序
 *
 * 就是从头到尾 拿到一张牌 依次和左边比较 若更小就交换 就像插入一样。。。虽然我没觉得像2333
 * 与输入次序很有关系
 *
 * 平均情况下 比较～(n^2)/4 移动～(n^2)/4，需要计算不好写上来 https://www.cnblogs.com/icanth/archive/2012/06/12/2546250.html
 *           插入：设插入第k个元素时 插入位置是j  1<=j<=k 其需要比较k-j+1次
 *           移动：设插入第k个元素时 插入位置是j  1<=j<=k-1 因为当j=k时 无需进行移动操作 移动次数为k-j+2
 *
 * 最好情况下 输入已经是顺序了 比较n-1次 移动0次
 *
 * 最坏情况下 每次都要比较到底 都要移动 比较 n(n-1)/2 移动 n(n-1)/2
 *
 * 对于有很多重复主键的数组 我们需采用更复杂的模型
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class Insertion {
    public static void sort(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i; j > 0 && less(a[j],a[j-1]); j--){
                exch(a, j, j-1);
            }
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
        String[] num = {"A","C","B"};
        sort(num);
        assert isSorted(num);
        show(num);
    }

}

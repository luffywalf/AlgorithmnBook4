/**
 * 选择排序
 *
 * 首先找到数组中最小的元素，将它与数组中第一个元素互换
 * 然后在剩下的元素中再次找到最小的和数组中第二个元素互换，以此类推
 * 即不断选择剩余元素中最小的那个
 *
 * 交换操作的代码在内循环之外，所以总是N
 * 比较次数为 n-1 + ... + 1 = n(n-1)/2 注意是n-1开始哦
 * 等差数列求和公式 Sn = n*a1 + d* n(n-1)/2
 *
 * 特点
 * 运行时间和输入无关，好也坏，就已有序的和无序的数组比较时间相同
 * 数据移动即交换是最少的
 *
 * 这个和小boss说的 heap sort? 选择排序和优先队列 本质都还是很不同 优先队列是每次新来元素可以插入
 * 然后重新排等 选择排序没有这些功能。
 *
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class Selection {
    /**  我理解的这里要用Comparable是为了可以比较非数字类型等 **/
    public static void sort(Comparable[] a){
        for(int j = 0; j < a.length; j++){
            int minIndex = j;
            for(int i = j; i < a.length; i++){
                if (less(a[i], a[minIndex])) {
                    minIndex = i;
                }
            }
            exch(a, j, minIndex);
        }
        /*//数组有index就好了，min多余
        for(int j = 0; j < a.length; j++){
            Comparable min = a[j];
            int flag = j;
            for(int i = j; i < a.length; i++){
                if (less(a[i], min)) {
                    min = a[i];
                    flag = i;
                }
            }
            exch(a, j, flag);
        }*/
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

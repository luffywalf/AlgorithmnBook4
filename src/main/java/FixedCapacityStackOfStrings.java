/**
 * 范型
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class FixedCapacityStackOfStrings<Item> {
    private Item[] a;
    private int N;
    public FixedCapacityStackOfStrings(int cap){
//        a = new Item[cap];
        a = (Item[]) new Object[cap];
    }
    public boolean isEmpty(){ return N == 0; }
    public int size(){ return N; }
    /** 注意这里N++和--要配合使用 **/
    public void push(Item item){ a[N++] = item; }
    public Item pop(){ return a[--N]; }


    public static void main(String[] args){
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(10);
        System.out.println(s.isEmpty());
        s.push("time");
        s.push("your");
        s.push("take");
        s.push("not");
        s.push("do");
        System.out.println(s.size());
        for(int i=0; i<5; i++){
            System.out.print(s.pop()+" ");
        }
    }

}


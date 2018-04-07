import java.util.Iterator;

/**
 * 可变长可迭代的栈
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    private boolean isEmpty(){ return N == 0; }
    private int size(){ return N; }
    private void resize( int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i=0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        if( N == a.length ) resize(2*a.length);
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        /* 避免对象游离 */
        a[N] = null;
        if( N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    @Override
    public Iterator<Item> iterator(){ return new ReverseArrayIterator(); }
    private class ReverseArrayIterator implements Iterator<Item>{
        /** 按理说这里的 i=N 方式是起别名，那应该都会改变 为什么会出错？*/
        private int i = N;
        /**  继承父类方法，对其覆盖  **/
        @Override
        public boolean hasNext(){ return N > 0; }
        @Override
        public Item next(){ return a[--N]; }
        @Override
        public void remove(){};

    }

    public static void main(String[] args){
        ResizingArrayStack s = new ResizingArrayStack<>();
        System.out.println(s.isEmpty());
        s.push("time");
        s.push("your");
        s.push("take");
        s.push("not");
        s.push("do");
        while (s.iterator().hasNext()){
            Iterator<String> iter = s.iterator();
            System.out.print(iter.next()+" ");
        }
    }

}

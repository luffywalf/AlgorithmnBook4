import java.util.Iterator;

/**
 * 可变长可迭代的栈
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class Stack<Item> implements Iterable<Item> {
    private class Node{
        Item item;
        Node next;
    }
    /** 栈顶 **/
    private Node first;
    /** 元素数量 **/
    private int N;
    private boolean isEmpty(){ return first == null; }
    private int size(){ return N; }
    private void push(Item item){
        /*   // book version
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;*/

        /*  my version */
        Node newNode = new Node();
        newNode.next = first;
        first = newNode;
        newNode.item = item;
        N++;
    }
    private Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator(){ return new ListIterator(); }
    private class ListIterator implements Iterator<Item> {
        /** this problem again **/
        private Node current = first;
        @Override
        public boolean hasNext(){ return first != null; }
        @Override
        public Item next(){
            Item item = first.item;
            first = first.next;
            return item;
        }
        @Override
        public void remove(){};

    }

    public static void main(String[] args){
        Stack<String> s = new Stack<>();
        System.out.println(s.isEmpty());
        s.push("time");
        s.push("your");
        s.push("take");
        s.push("not");
        s.push("do");
        System.out.println(s.size());
        while (s.iterator().hasNext()){
            Iterator<String> iter = s.iterator();
            System.out.print(iter.next()+" ");
        }
    }
}

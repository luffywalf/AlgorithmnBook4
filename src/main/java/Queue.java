/**
 * 队列
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class Queue<Item> {
    private class Node{
        Item item;
        Node next;
    }
    /** 栈顶 **/
    private Node first;
    private Node last;
    private int N;
    private boolean isEmpty(){ return first == null; }
    private int size(){ return N; }
    private void enqueue(Item item){

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){ first = last; }
        else { oldLast.next = last; }
        N++;

        /*Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        if(isEmpty()){ last = newNode; first = last; }
        else { last.next = newNode; last = newNode;}
        N++;*/
    }
    private Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()){ last = null; }
        N--;
        return item;

    }
    public static void main(String[] args) {
        Queue<String> s = new Queue<>();
        System.out.println(s.isEmpty());
        s.enqueue("buddy");
        s.enqueue("ya");
        s.enqueue("miss");
        s.enqueue("really");
        s.enqueue("I");
        System.out.println(s.size());
        for (int i = 0; i < 5; i++) {
            System.out.print(s.dequeue() + " ");
        }

    }
}

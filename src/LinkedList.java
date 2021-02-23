import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LinkedList {
    // This class has a default constructor

    public LinkedList(){
        length = 0;
    }
    ListNode head;
    private int length =0;
    //Return the first node/head in the list

    public synchronized ListNode getHead(){
        return head;
    }
    // Insert a node at the beginning of the list
    public synchronized void insertAtBegin(ListNode node){
        node.setNext(head);
        head = node;
        length++;
    }

    // Insert at the end of the list
    public synchronized void insertAtEnd(ListNode node){
        if(head==null){
            head=node;
        }else{
            ListNode p,q;
            for(p =head; (q=p.next)!=null;p=q){
                p.next=node;
            }
            length++;
        }
    }

    // Inserting at any given position
    public synchronized void insert(int data , int position){
        if(position<0){
            position=0;
        }
        else if(position > length){
            position=length;
        }
        // If list is empty make it the only element
        else if(head == null){
            head = new ListNode(data);
        }

        // If adding at the fron tof the list
        else if(position==0){
            ListNode temp = new ListNode(data);
            temp.next= head;
            head=temp;
        }

        // Else find the correct position and insert
        else{
            ListNode temp = head;
            for(int i=1;i<position;i++){
                temp=temp.next;
            }
            ListNode newNode = new ListNode(data);
            newNode.next=temp.next;
            temp.next=newNode;
        }
        //the list is now one value longer
        length++;
    }

    //Remove and Return the node at the head of the list
    public synchronized ListNode removeFromBegin(){
        ListNode node = head;
        if(node!=null){
            head=node.next;
            node.next=null;
        }
        return node;
    }

    //Removing a node from End of the list
    public synchronized ListNode removeFromEnd(){
        if(head==null)
            return null;
        ListNode p = head, q = null, next=head.next;
        if(next==null){
            head=null;
            return p;
        }
        while((next=p.next)!=null){
            q=p;
            p=next;
        }
        q.next=null;
        return p;
    }
    //Remove a node matching the specified node from the list.
    //Use equals() instead of == to test for a matched node.

    public synchronized void removeMatched(ListNode node){
        if(head==null){
            return;
        }
        if(node.equals(head)){
            head=head.next;
            return;
        }
        ListNode p=head, q=null;
        while((q=p.next)!=null){
            if(node.equals(q)){
                p.next=q.next;
                return;
            }
            p=q;
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode head = new ListNode(5);
        ListNode secondNode = new ListNode(6);
        ListNode lastNode = new ListNode(7);
        list.insertAtEnd(lastNode);
        list.insertAtBegin(secondNode);
        System.out.println(list.length);
    }
}

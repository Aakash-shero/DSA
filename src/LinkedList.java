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

    //Removing a node from starting of the list

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

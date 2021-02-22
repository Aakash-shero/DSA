public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data){
        this.data =data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public int length(ListNode headNode){
        int length=0;

        ListNode currentNode = headNode;
        while(currentNode!=null){
            length++;
            currentNode= currentNode.next;
        }

        return length;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node2 = new ListNode(6);
        node.setNext(node2);
        ListNode myData = node.getNext();
        int l= node.length(node);
        System.out.println(l);
    }
}

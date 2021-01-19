public class FixedSizeArrayStack {
    protected int capacity;
    protected static final int CAPACITY = 10;
    protected int [] stackRep;
    protected int top = -1;

    public FixedSizeArrayStack(){
        this(CAPACITY);
    }

    public FixedSizeArrayStack(int cap){
        capacity=cap;
        stackRep = new int[capacity];
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return (top<0);
    }

    public void push (int data) throws Exception {
        if(size()==capacity) throw new Exception("Stack is Full");
        stackRep[++top]=data;
    }
    public int top() throws Exception{
        if(isEmpty()) throw new Exception("Stack in Empty");
        return stackRep[top];
    }
    public int pop() throws Exception{
        int data;
        if(isEmpty()) throw new Exception("Stack is Empty");
        data = stackRep[top];
        stackRep[top--]=Integer.MIN_VALUE;
        return data;
    }

    public String toString(){
        String s;
        s = "[";
        if(size()>0) s = s+ stackRep[0];
        if(size()>1){
            for (int i = 1; i <= size()-1;i++){
                s=s+","+ stackRep[i];
            }
        }
        return s + "] ";
    }

    public static void main(String[] args) throws Exception {
        FixedSizeArrayStack fsa = new FixedSizeArrayStack(20);
        fsa.push(2);
        System.out.println(fsa.size());
        System.out.println(fsa.isEmpty());
        System.out.println(fsa.toString());
        System.out.println(fsa.top());
        fsa.push(7);
        fsa.pop();
        System.out.println(fsa.top());
        System.out.println(Integer.MIN_VALUE);

    }
}

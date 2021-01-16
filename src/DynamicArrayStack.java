public class DynamicArrayStack {
    protected int capacity;
    protected static final int CAPACITY =16;
    protected static int MINCAPACITY = 1<<15;

    public static void main(String[] args) throws Exception {
        DynamicArrayStack das = new DynamicArrayStack(16);
        das.push(23);
        das.push(33);
        System.out.println(das.size());
        System.out.println(das.toString());
    }

    protected int top = -1;

    public int[] stackRep;
    public DynamicArrayStack(){
        this(CAPACITY);

    }

    public DynamicArrayStack(int cap){
        capacity=cap;
        stackRep= new int[capacity];
    }

    public boolean isEmpty(){
        return (top<0);
    }

    public int size(){
        return top+1;
    }
    public void push (int data) throws Exception{
        if (size() == capacity)  expand();
        stackRep[++top]= data;

    }

    public void expand(){
        int length = size();
        int[] newStack = new int[length<<1];
        System.arraycopy(stackRep,0,newStack,0,length);
        stackRep=newStack;
        this.capacity=this.capacity<<1;

    }

    //condition where the array has to be shrank to 1/2 if more than 3/4th of the array is empty is not implemented.
    public void shrink(){
        int length = top+1;
        if(length<capacity/2)
        {
            int [] newStack = new int[capacity/2];
            System.arraycopy(stackRep,0,newStack,0,newStack.length);
            stackRep=newStack;
            capacity=newStack.length;
        }

    }
    public int top() throws Exception{
        if(isEmpty()) throw new Exception("Stack is Empty");
        return stackRep[top];
    }

    public int pop() throws Exception{
        int data;
        if(isEmpty()) throw new Exception("Stack is Empty");
        data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE;
        shrink();
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
        return s + "]";
    }

}

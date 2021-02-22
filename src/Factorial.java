public class Factorial {
    public long factorial(long number){
        // recursive definition of method factorial
        if(number<=1) // test case for base case
        {
            return 1; // base case is 0! and 1!
        }
        else{
            return number*factorial(number-1);
        }
    }

    public static void main(String[] args) {
        Factorial obj = new Factorial();
        //printing out factorials from number 0-10
        for(int counter=0;counter<=10;counter++){
            System.out.printf("%d!=%d\n",counter ,obj.factorial(counter));
        }
    }
}

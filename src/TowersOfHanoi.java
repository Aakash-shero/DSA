public class TowersOfHanoi {
    public void TowersOfHanoi(int n,char fromPeg, char toPeg, char auxPeg){
        if(n==1){
            System.out.println("Move disk 1 from peg"+ fromPeg+ "to peg" + toPeg);
            return;
        }
        TowersOfHanoi(n-1,fromPeg,auxPeg,toPeg);
        System.out.println("Move disk from peg"+fromPeg +"to peg"+toPeg);
        TowersOfHanoi(n-1,auxPeg,toPeg,fromPeg);
    }
}

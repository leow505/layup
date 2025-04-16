/*
Layup Sequence
Implement an algorithm to compute the value of the Layup Sequence at n 10,000.
The sequence is defined:
 S(n)= 1 if n = 1
    = 2 if n =2
    = S(n-1) + S(n-2) if n is even
    = 2S(n-1) - S(n-2) if n is odd
 */
public class Main {
    public static void main(String[] args) {
        int n = 10000;
        System.out.println("N = " + n + ": " + computeLayupSeq(n));
    }
    private static long computeLayupSeq(int n ) {
        if (n==1) return 1;
        if (n==2) return 2;
        //avoid stack over flow
        long prev1 = 2;
        long prev2 = 1;
        long current = 0;
        for (int i = 3; i < n; i++) {
            if(i%2==0){
                current = prev1 + prev2;
            }else {
                current = 2 * prev1 - prev2;
            }
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
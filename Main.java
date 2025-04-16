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
        int n = 10;
        System.out.println("N = " + n + ": " + computeLayupSeq(n));
        System.out.println("Hello world");
    }
    //Using recursion to solve
    private static long computeLayupSeq(int n ) {
        if (n==1) return 1;
        if (n==2) return 2;
        if (n%2 == 0) {
            return computeLayupSeq(n-1) + computeLayupSeq(n-2);
        } else {
            return 2 * computeLayupSeq(n-2) - computeLayupSeq(n-2);
        }
    }
}
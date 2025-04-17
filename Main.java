import java.math.BigInteger;
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
        int n = 4;
        System.out.println("N = " + n + ": " + computeLayupSeq(n));
    }
    private static BigInteger computeLayupSeq(int n ) {
        /*S(1) = 1
          S(2) = 2
          S(3) = 2 * (3-1) - (3-2) -> 2 * (2) - (1) = 4-1= 3 -> n
          S(4) = (4-1) + (4-2) -> (3) + (2) = 5 -> n + 1
          S(5) = 2 * (5-1) - (5-2) -> 2 * (4) - (3) = 2*5-3 = 7
          S(6) = (6-1) + (6-2) -> (5) + (4) = 5+7 = 12
          S(7) = 2 * (7-1) - (7-2) -> 2 * (6) - (5) = 2*12-7 = 17
          1,2,3,5,7,12,17
          Seems to be like Fibonacci pattern
        */
        // Using Java BigInteger for big values
        BigInteger odd  = BigInteger.ONE; // S(1)
        BigInteger even = BigInteger.TWO; // S(2)
        //split n in half, since we will calculate both at once
        int K = (n + 1) / 2;
        for (int i = 1; i < K; i++) {
            // 2S(n-1) - S(n-2) if n is odd
            BigInteger nextOdd  = even.multiply(BigInteger.TWO).subtract(odd);
            // S(n-1) + S(n-2) if n is even
            BigInteger nextEven = nextOdd.add(even);

            odd  = nextOdd;
            even = nextEven;
        }
        return (n % 2 == 1) ? odd : even;
    }
}
import numpy as np


# odd = S(2n-1)
# even = S(2n)
# Odd_n+1 = S(2n+1) = 2S(2n) - S(2n-1) = 2*Even_n - Odd_n
# Even_n+1 = S(2n+2) = S(2n+1) + S(2n) = Odd_n+1 + Even_n
# Even_n+1 -> 2*Even_n - Odd_n + Even_n = 3*Even_n - Odd_n
# [-1,2] [-1,3] * [Odd, Even] = A * V_1 = V_2
# V_3 = A * A * V_1
# [-1,2] [-1,3] * [1,2] = S(3),S(4)
# [-1,2] [-1,3]^2 * [1,2] = [-1 4] [-2 7] * [1,2] = S(5),S(6)
def layup_sequence(n):
    if n ==1:
        return 1
    if n == 2:
        return 2
    A = np.array([[-1,2],[-1,3]],dtype=object)
    exponent = (n+1)//2
    A_pow = np.linalg.matrix_power(A, exponent-1)
    start = np.array([1,2],dtype=object)
    result = np.matmul(A_pow, start)
    return result[0] if n % 2== 1 else result[1]

print(layup_sequence(10000))
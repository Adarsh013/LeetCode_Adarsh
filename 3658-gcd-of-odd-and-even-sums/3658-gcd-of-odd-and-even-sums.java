class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOfodd = n*n;
        int sumOfEven = n * (n+1);

        return findGCD(sumOfodd, sumOfEven);
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        StringBuilder x = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '0') {
                x.append(c);
            }
        }

        if (x.length() == 0) {
            return 0;
        }

        long val = Long.parseLong(x.toString());
        long digitSum = sum(val);

        return val * digitSum;
    }

    long sum(long n) {
        long res = 0;

        while (n != 0) {
            res += n % 10;
            n /= 10;
        }

        return res;
    }
}
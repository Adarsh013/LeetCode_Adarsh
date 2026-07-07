class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        String x ="";
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c != '0') x+=s.charAt(i);
            else continue;
        }

        if(x.length() == 0) return 0;
        long val = Long.parseLong(x);
        long result = sum(val);

        return val*result;
    }

    long sum(long n){

        long rem = 0;
        long res = 0;
        while (n != 0){
            rem = n % 10;
            res = res + rem;
            n /= 10;
        }
        return res;
    }
}
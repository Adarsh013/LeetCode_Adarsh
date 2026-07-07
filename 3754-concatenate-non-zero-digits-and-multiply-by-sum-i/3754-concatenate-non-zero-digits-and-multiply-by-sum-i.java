class Solution {
    public long sumAndMultiply(int n) {

        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        
        long digitSum = 0;

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c != '0') {
                sb.append(c);
                digitSum += c - '0';
            }
        }

        if(sb.length() == 0) return 0;

        long val = Long.parseLong(sb.toString());

        return val*digitSum;
    }
}
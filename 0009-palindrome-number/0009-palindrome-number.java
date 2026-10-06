class Solution{
    public boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        int rem,res=0;
        int n=x;
        while (x!=0){
            rem= x%10;
            res=res*10+rem;
            x/=10;
        }
        return res == n;
    }
}

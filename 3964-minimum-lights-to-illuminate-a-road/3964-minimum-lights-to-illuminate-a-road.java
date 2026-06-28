class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int[]temp = new int[lights.length + 1];
        for(int i = 0 ; i < lights.length ; i++){
            if(lights[i] >= 1){
                temp[Math.max(0,i - lights[i])]++;
                temp[Math.min(n - 1,i + lights[i]) + 1]--; 
            }
        }
        for(int i = 1 ; i < lights.length ; i++){
            temp[i] += temp[i - 1];
        }
        int cnt = 0;
        temp[lights.length] = 1;
        int i = 0 , j =0;
        while(j < lights.length + 1){
            if(temp[j] > 0){
                cnt += (j - i + 2) / 3;
                i = ++j;
                continue;
            }
            j++;
        }
        return cnt;
    }
}
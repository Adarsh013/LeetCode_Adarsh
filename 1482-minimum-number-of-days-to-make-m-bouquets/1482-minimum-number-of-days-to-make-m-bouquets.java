class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        long req = (long)m * k;
        if((bloomDay.length) < req) return -1;
        
        for(int bloom : bloomDay){
            maxi = Math.max(maxi, bloom);
            mini = Math.min(mini, bloom);
        }

        int low = mini;
        int high = maxi;

        while(low <= high){
            int mid = low + (high - low) /2;

            if(canMake(bloomDay,m,k,mid)) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    boolean canMake(int[] bloomDay, int m, int k, int day){
        int flowers = 0;
        int boq = 0;

        for(int bloom : bloomDay){

            if(bloom <= day){
                flowers++;

                if(flowers == k){
                    boq++;
                    flowers = 0;
                }
            }
            else{
                flowers = 0;
            }
            
        }
        return boq >= m;
    }
}

// Target is to make m bouquets
// to make m boq we need to use k adjacents flowers